package com.aurionpro.BankMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.BankingMP.model.DBUtil;

public class AccountDAO {

    public Account getAccountByCustomerId(String customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE customer_id = ? AND status = 'active'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                    rs.getLong("account_number"),
                    rs.getString("customer_id"),
                    rs.getDouble("balance"),
                    rs.getString("upi"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccountByNumber(long accountNumber) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE account_number = ? AND status = 'active'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                    rs.getLong("account_number"),
                    rs.getString("customer_id"),
                    rs.getDouble("balance"),
                    rs.getString("upi"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean isCustomerIdExists(String customerId) throws SQLException {
        String query = "SELECT COUNT(*) FROM customers WHERE customer_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
    public void updateBalance(long accountNumber, double newBalance) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newBalance);
            ps.setLong(2, accountNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(long accountNumber) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE accounts SET status = 'inactive' WHERE account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, accountNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAllAccounts(String customerId) {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE customer_id = ? AND status = 'active'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(
                    rs.getLong("account_number"),
                    rs.getString("customer_id"),
                    rs.getDouble("balance"),
                    rs.getString("upi"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
