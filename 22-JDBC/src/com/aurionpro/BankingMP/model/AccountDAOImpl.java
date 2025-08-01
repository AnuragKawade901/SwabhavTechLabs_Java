package com.aurionpro.BankingMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {
	@Override
	public void createAccount(Account acc) throws SQLException {
		String sql = "INSERT INTO banking_acc (id, name, balance, password, mobile, email, pin) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, acc.getId());
			ps.setString(2, acc.getName());
			ps.setDouble(3, acc.getBalance());
			ps.setString(4, acc.getPassword());
			ps.setString(5, acc.getMobile());
			ps.setString(6, acc.getEmail());
			ps.setInt(7, acc.getPin()); // Ensure pin is being set in constructor

			ps.executeUpdate();
		}
	}

	@Override
	public Account getAccount(int id) throws SQLException {
		try (Connection con = DBUtil.getConnection()) {
			return getAccount(con, id);
		}
	}

	@Override
	public Account getAccount(Connection con, int id) throws SQLException {
	    String sql = "SELECT * FROM banking_acc WHERE id = ?";
	    try (PreparedStatement stmt = con.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return new Account(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getDouble("balance"),
	                rs.getString("password"),
	                rs.getString("mobile"),
	                rs.getString("email"),
	                rs.getInt("pin")
	            );
	        }
	        return null;
	    }
	}

	@Override
	public void updateBalance(Connection con, int id, double newBalance) throws SQLException {
		String query = "UPDATE banking_acc SET balance = ? WHERE id = ?";
		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setDouble(1, newBalance);
			stmt.setInt(2, id);
			int updated = stmt.executeUpdate();
			if (updated == 0) {
				throw new SQLException("❌ Account not found for update.");
			}
		}
	}

	@Override
	public void deleteAccount(int accountId) throws SQLException {
		String sql = "DELETE FROM banking_acc WHERE id = ?";
		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, accountId);
			int rows = ps.executeUpdate();
			if (rows == 0) {
				throw new SQLException("❌ Account ID not found. Deletion failed.");
			}
		}
	}
	@Override
	public void updateAccountDetails(int id, String newName, String newMobile, String newEmail) throws SQLException {
	    String sql = "UPDATE banking_acc SET name = ?, mobile = ?, email = ? WHERE id = ?";

	    try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, newName);
	        ps.setString(2, newMobile);
	        ps.setString(3, newEmail);
	        ps.setInt(4, id);

	        int updated = ps.executeUpdate();
	        if (updated == 0) {
	            throw new SQLException("❌ Account not found. Update failed.");
	        }
	    }
	}
	
}