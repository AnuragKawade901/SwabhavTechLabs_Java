package com.aurionpro.BankingMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionLogger {
    public static void log(Connection con, TransactionRecord record) throws SQLException {
        String sql = "INSERT INTO transactions (account_id, amount, type, related_account_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, record.getAccountId());
            ps.setDouble(2, record.getAmount());
            ps.setString(3, record.getType());
            if (record.getRelatedAccountId() == null) {
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(4, record.getRelatedAccountId());
            }
            ps.executeUpdate();
        }
    }
}
