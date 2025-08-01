package com.aurionpro.BankMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.BankingMP.model.DBUtil;

public class TransactionDAO {
	public boolean isAccountExists(long accNumber) {
	    String query = "SELECT COUNT(*) FROM accounts WHERE account_number = ?";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setLong(1, accNumber);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

    public void logTransaction(Transaction transaction) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO transactions (from_acc, to_acc, amount, type, timestamp) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, transaction.getFromAcc());
            ps.setLong(2, transaction.getToAcc());
            ps.setDouble(3, transaction.getAmount());
            ps.setString(4, transaction.getType());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactionHistory(long accountNumber) {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE from_acc = ? OR to_acc = ? ORDER BY timestamp DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, accountNumber);
            ps.setLong(2, accountNumber);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                transactions.add(new Transaction(
                    rs.getInt("id"),
                    rs.getLong("from_acc"),
                    rs.getLong("to_acc"),
                    rs.getDouble("amount"),
                    rs.getString("type"),
                    rs.getTimestamp("timestamp")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
