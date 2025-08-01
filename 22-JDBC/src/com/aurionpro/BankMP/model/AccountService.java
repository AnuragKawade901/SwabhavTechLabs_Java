package com.aurionpro.BankMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountService {
    private Scanner sc = new Scanner(System.in);

    public void createAccount(Connection conn, long accNo, String customerId, double balance, String upi) throws SQLException {
        String sql = "INSERT INTO accounts(account_number, customer_id, balance, upi, status) VALUES (?, ?, ?, ?, 'ACTIVE')";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, accNo);
        ps.setString(2, customerId);
        ps.setDouble(3, balance);
        ps.setString(4, upi);
        ps.executeUpdate();
    }

    public void accountMenu(String customerId, TransactionService transactionService) {
        while (true) {
            System.out.println("\n------ SBJ Account Menu ------");
            System.out.println("1. View Accounts");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Mini Statement");
            System.out.println("7. Full Statement");
            System.out.println("8. Logout");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> viewAccounts(customerId);
                case 2 -> checkBalance(customerId);
                case 3 -> deposit(customerId, transactionService);
                case 4 -> withdraw(customerId, transactionService);
                case 5 -> transfer(customerId, transactionService);
                case 6 -> transactionService.miniStatement(customerId);
                case 7 -> transactionService.fullStatement(customerId);
                case 8 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void viewAccounts(String customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nAccount List:");
            while (rs.next()) {
                System.out.println("Account No: " + rs.getLong("account_number") +
                        " | Balance: ₹" + rs.getDouble("balance") +
                        " | UPI: " + rs.getString("upi") +
                        " | Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkBalance(String customerId) {
        System.out.print("Enter account number: ");
        long acc = sc.nextLong();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT balance FROM accounts WHERE customer_id = ? AND account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ps.setLong(2, acc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Balance: ₹" + rs.getDouble("balance"));
            } else {
                System.out.println("Invalid account.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deposit(String customerId, TransactionService ts) {
        System.out.print("Enter account number: ");
        long acc = sc.nextLong();
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            String sql = "UPDATE accounts SET balance = balance + ? WHERE account_number = ? AND customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, amt);
            ps.setLong(2, acc);
            ps.setString(3, customerId);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                ts.recordTransaction(conn, acc, acc, amt, "DEPOSIT");
                conn.commit();
                System.out.println("✅ Deposit successful.");
            } else {
                System.out.println("❌ Invalid account.");
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(String customerId, TransactionService ts) {
        System.out.print("Enter account number: ");
        long acc = sc.nextLong();
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            String checkSql = "SELECT balance FROM accounts WHERE account_number = ? AND customer_id = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setLong(1, acc);
            checkPs.setString(2, customerId);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                double bal = rs.getDouble("balance");
                if (bal >= amt) {
                    String updateSql = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
                    PreparedStatement ps = conn.prepareStatement(updateSql);
                    ps.setDouble(1, amt);
                    ps.setLong(2, acc);
                    ps.executeUpdate();

                    ts.recordTransaction(conn, acc, acc, amt, "WITHDRAW");
                    conn.commit();
                    System.out.println("✅ Withdrawal successful.");
                } else {
                    System.out.println("❌ Insufficient balance.");
                    conn.rollback();
                }
            } else {
                System.out.println("❌ Invalid account.");
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void transfer(String customerId, TransactionService ts) {
        System.out.print("Enter FROM account number: ");
        long fromAcc = sc.nextLong();
        System.out.print("Enter TO account number: ");
        long toAcc = sc.nextLong();
        if (fromAcc == toAcc) {
            System.out.println("❌ Cannot transfer to same account.");
            return;
        }
        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            String balSql = "SELECT balance FROM accounts WHERE account_number = ? AND customer_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(balSql);
            ps1.setLong(1, fromAcc);
            ps1.setString(2, customerId);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                double bal = rs.getDouble("balance");
                if (bal >= amt) {
                    String withdrawSql = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
                    PreparedStatement ps2 = conn.prepareStatement(withdrawSql);
                    ps2.setDouble(1, amt);
                    ps2.setLong(2, fromAcc);
                    ps2.executeUpdate();

                    String depositSql = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
                    PreparedStatement ps3 = conn.prepareStatement(depositSql);
                    ps3.setDouble(1, amt);
                    ps3.setLong(2, toAcc);
                    int rows = ps3.executeUpdate();

                    if (rows > 0) {
                        ts.recordTransaction(conn, fromAcc, toAcc, amt, "TRANSFER");
                        conn.commit();
                        System.out.println("✅ Transfer successful.");
                    } else {
                        System.out.println("❌ Destination account not found.");
                        conn.rollback();
                    }
                } else {
                    System.out.println("❌ Insufficient balance.");
                    conn.rollback();
                }
            } else {
                System.out.println("❌ Invalid source account.");
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
