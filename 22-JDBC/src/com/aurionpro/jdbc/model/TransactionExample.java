package com.aurionpro.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Anika@178";

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);

            double amount = 100;
            int senderId = 1;    // Amit
            int receiverId = 2;  // 👈 Try changing this to 2 to simulate valid transfer

            // 🛑 Self-transfer check
            if (senderId == receiverId) {
                System.out.println("❌ Self-transfer is not allowed. Transaction aborted.");
                return;
            }

            // Get balances before transaction
            double senderBalanceBefore = getBalance(con, senderId);
            double receiverBalanceBefore = getBalance(con, receiverId);

            System.out.println("💰 Balances BEFORE transaction:");
            System.out.println("Sender (ID: " + senderId + "): ₹" + senderBalanceBefore);
            System.out.println("Receiver (ID: " + receiverId + "): ₹" + receiverBalanceBefore);

            if (senderBalanceBefore < amount) {
                System.out.println("❌ Insufficient funds. Transaction aborted.");
                return;
            }

            // Withdraw from sender
            PreparedStatement withdrawStmt = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ?"
            );
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, senderId);
            withdrawStmt.executeUpdate();

            // Deposit to receiver
            PreparedStatement depositStmt = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?"
            );
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, receiverId);
            depositStmt.executeUpdate();

            con.commit();
            System.out.println("✅ Transaction successful! ₹" + amount + " transferred.");

            // Get balances after transaction
            double senderBalanceAfter = getBalance(con, senderId);
            double receiverBalanceAfter = getBalance(con, receiverId);

            System.out.println("\n💰 Balances AFTER transaction:");
            System.out.println("Sender (ID: " + senderId + "): ₹" + senderBalanceAfter);
            System.out.println("Receiver (ID: " + receiverId + "): ₹" + receiverBalanceAfter);

        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("⛔️ Transaction rolled back.");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (con != null && !con.isClosed())
                    con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Helper method to get balance of an account
    private static double getBalance(Connection con, int accountId) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("balance");
        }
        return 0.0;
    }
}