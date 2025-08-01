package com.aurionpro.BankingMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {
	private final AccountDAO accountDAO;

	public BankServiceImpl(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	private int generateNewId() throws SQLException {
	    int id;
	    do {
	        id = 1000 + (int)(Math.random() * 9000); // random 4-digit number between 1000–9999
	    } while (accountExists(id));
	    return id;
	}

	private boolean accountExists(int id) throws SQLException {
	    try (Connection con = DBUtil.getConnection();
	         PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM banking_acc WHERE id = ?")) {
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0;
	            }
	        }
	    }
	    return false;
	}

	public int createAccount(String name, double deposit, String password, String mobile, String email) throws SQLException {
	    if (deposit < 100)
	        throw new IllegalArgumentException("❌ Minimum deposit must be ₹100.");

	    int id = generateNewId();

	    // Ask user for PIN
	    int pin = InputUtil.getValidInt("Set a 4-digit PIN: ");
	    if (String.valueOf(pin).length() != 4)
	        throw new IllegalArgumentException("❌ PIN must be exactly 4 digits.");

	    // Create account with initial deposit
	    Account acc = new Account(id, name, deposit, password, mobile, email, pin);
	    accountDAO.createAccount(acc);
	    return id;
	}
	@Override
	public Account login(int id, int pin) throws SQLException {
	    Account acc = accountDAO.getAccount(id);
	    if (acc == null)
	        throw new IllegalArgumentException("Account not found.");
	    if (acc.getPin() != pin)
	        throw new IllegalArgumentException("Invalid PIN.");
	    return acc;
	}

	public double checkBalance(int id) throws SQLException {
		Account acc = accountDAO.getAccount(id);
		if (acc == null)
			throw new IllegalArgumentException(" Account not found.");
		return acc.getBalance();
	}
	public void printTransactionHistory(int accountId) throws SQLException {
	    try (Connection con = DBUtil.getConnection()) {
	        String sql = "SELECT * FROM transactions WHERE account_id = ? ORDER BY timestamp DESC";
	        try (PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setInt(1, accountId);
	            var rs = ps.executeQuery();

	            List<String[]> rows = new ArrayList<>();
	            while (rs.next()) {
	                String type = rs.getString("type");
	                double amount = rs.getDouble("amount");
	                String time = rs.getTimestamp("timestamp").toString();
	                int related = rs.getInt("related_account_id");
	                String relStr = rs.wasNull() ? "-" : String.valueOf(related);

	                rows.add(new String[]{
	                        String.format("₹%.2f", amount),
	                        type.toUpperCase(),
	                        relStr,
	                        time
	                });
	            }

	            if (rows.isEmpty()) {
	                System.out.println("\n No transactions yet.");
	                return;
	            }

	            // Print header
	            System.out.println("\n Transaction History:");
	            System.out.println("+------------+-------------+------------+----------------------+");
	            System.out.printf("| %-10s | %-11s | %-10s | %-20s |\n", "Amount", "Type", "Related ID", "Timestamp");
	            System.out.println("+------------+-------------+------------+----------------------+");

	            // Print rows
	            for (String[] row : rows) {
	                System.out.printf("| %-10s | %-11s | %-10s | %-20s |\n",
	                        row[0], row[1], row[2], row[3]);
	            }

	            System.out.println("+------------+-------------+------------+----------------------+");
	        }
	    }
	}
	public void printMiniStatement(int accountId) throws SQLException {
	    try (Connection con = DBUtil.getConnection()) {
	        String sql = "SELECT * FROM transactions WHERE account_id = ? ORDER BY timestamp DESC LIMIT 5";
	        try (PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setInt(1, accountId);
	            ResultSet rs = ps.executeQuery();

	            System.out.println("\n ---- Mini Statement (Last 5 Transactions) ----");
	            boolean found = false;

	            System.out.printf("%-22s %-10s %-10s %-15s\n", "Timestamp", "Type", "Amount", "Related Acc");
	            System.out.println("---------------------------------------------------------------");

	            while (rs.next()) {
	                found = true;
	                String type = rs.getString("type");
	                double amount = rs.getDouble("amount");
	                String time = rs.getTimestamp("timestamp").toString();
	                int related = rs.getInt("related_account_id");
	                String relatedStr = rs.wasNull() ? "-" : String.valueOf(related);

	                System.out.printf("%-22s %-10s ₹%-9.2f %-15s\n", time, type.toUpperCase(), amount, relatedStr);
	            }

	            if (!found) {
	                System.out.println("No transactions found.");
	            }
	        }
	    }
	}
	public void deposit(int id, double amount) throws SQLException {
		if (amount <= 0)
			throw new IllegalArgumentException(" Deposit amount must be greater than ₹0.");

		Account acc = accountDAO.getAccount(id);
		if (acc == null)
			throw new IllegalArgumentException(" Account not found.");

		try (Connection con = DBUtil.getConnection()) {
		    accountDAO.updateBalance(con, id, acc.getBalance() + amount);
		    TransactionLogger.log(con, new TransactionRecord(id, amount, "deposit", null));
		    System.out.println(" ₹" + amount + " deposited.");
			
			
		}
	}

	public void withdraw(int id, double amount) throws SQLException {
		if (amount <= 0)
			throw new IllegalArgumentException(" Withdrawal amount must be greater than ₹0.");

		Account acc = accountDAO.getAccount(id);
		if (acc == null)
			throw new IllegalArgumentException(" Account not found.");
		if (acc.getBalance() < amount)
			throw new IllegalArgumentException(" Insufficient balance.");

		try (Connection con = DBUtil.getConnection()) {
		    accountDAO.updateBalance(con, id, acc.getBalance() - amount);
		    TransactionLogger.log(con, new TransactionRecord(id, amount, "withdraw", null));
		    System.out.println(" ₹" + amount + " withdrawn.");
		}
	}

	public void transfer(int fromId, int toId, double amount) throws SQLException {
	    try (Connection con = DBUtil.getConnection()) {
	        con.setAutoCommit(false);
	        Account from = accountDAO.getAccount(con, fromId);
	        Account to = accountDAO.getAccount(con, toId);

	        if (from == null || to == null) {
	            throw new RuntimeException("❌ Account not found.");
	        }

	        if (amount <= 0) {
	            throw new RuntimeException("❌ Amount must be positive.");
	        }

	        if (from.getBalance() < amount) {
	            throw new RuntimeException("❌ Insufficient funds.");
	        }

	        // Perform the transfer
	        accountDAO.updateBalance(con, fromId, from.getBalance() - amount);
	        accountDAO.updateBalance(con, toId, to.getBalance() + amount);

	        // Log both transactions
	        TransactionLogger.log(con, new TransactionRecord(fromId, amount, "transfer-out", toId));
	        TransactionLogger.log(con, new TransactionRecord(toId, amount, "transfer-in", fromId));

	        con.commit();
	        System.out.println("✅ ₹" + amount + " transferred to Account ID " + toId);
	    } catch (Exception e) {
	        throw new RuntimeException("❌ Transfer failed: " + e.getMessage());
	    }
	}
	@Override
	public void deleteAccount(int accountId, String password) throws SQLException {
	    Account acc = accountDAO.getAccount(accountId);

	    if (acc == null) {
	        throw new IllegalArgumentException("❌ Account not found.");
	    }

	    if (!acc.getPassword().equals(password)) {
	        throw new SecurityException("❌ Incorrect password. Cannot delete account.");
	    }

	    // Confirm with user
	    String confirm = InputUtil.getString("Are you sure you want to delete your account? (y/n): ").toLowerCase();
	    if (!confirm.equals("y")) {
	        System.out.println("❌ Account deletion cancelled.");
	        return;
	    }

	    accountDAO.deleteAccount(accountId);
	    System.out.println("✅ Account " + accountId + " deleted successfully.");
	}
	@Override
	public void updateAccountDetails(int id, String name, String mobile, String email) throws SQLException {
	    if (name == null || name.trim().isEmpty() || !name.matches("[a-zA-Z ]+")) {
	        throw new IllegalArgumentException("❌ Invalid name.");
	    }
	    if (!mobile.matches("\\d{10}")) {
	        throw new IllegalArgumentException("❌ Invalid mobile number.");
	    }
	    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
	        throw new IllegalArgumentException("❌ Invalid email format. Add @ or .com");
	    }

	    accountDAO.updateAccountDetails(id, name, mobile, email);
	    System.out.println(" Account details updated successfully.");
	}
	
	@Override
	public Account getAccount(int id) throws SQLException {
	    return accountDAO.getAccount(id);
	}
}



