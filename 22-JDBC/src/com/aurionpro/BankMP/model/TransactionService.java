package com.aurionpro.BankMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionService {

    public void recordTransaction(Connection conn, long fromAcc, long toAcc, double amount, String type) throws SQLException {
        String sql = "INSERT INTO transactions(from_account, to_account, amount, type, timestamp) VALUES (?, ?, ?, ?, NOW())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, fromAcc);
        ps.setLong(2, toAcc);
        ps.setDouble(3, amount);
        ps.setString(4, type);
        ps.executeUpdate();
    }

    public void miniStatement(String customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE from_account IN (SELECT account_number FROM accounts WHERE customer_id = ?) " +
                         "OR to_account IN (SELECT account_number FROM accounts WHERE customer_id = ?) ORDER BY timestamp DESC LIMIT 5";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ps.setString(2, customerId);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n📄 Mini Statement:");
            while (rs.next()) {
                System.out.println(rs.getTimestamp("timestamp") + " | " +
                        rs.getString("type") + " | ₹" +
                        rs.getDouble("amount") +
                        " | From: " + rs.getLong("from_account") +
                        " | To: " + rs.getLong("to_account"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fullStatement(String customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE from_account IN (SELECT account_number FROM accounts WHERE customer_id = ?) " +
                         "OR to_account IN (SELECT account_number FROM accounts WHERE customer_id = ?) ORDER BY timestamp DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ps.setString(2, customerId);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n📄 Full Statement:");
            while (rs.next()) {
                System.out.println(rs.getTimestamp("timestamp") + " | " +
                        rs.getString("type") + " | ₹" +
                        rs.getDouble("amount") +
                        " | From: " + rs.getLong("from_account") +
                        " | To: " + rs.getLong("to_account"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
