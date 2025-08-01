//package com.aurionpro.BankingMP.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CustomerDAOImpl implements CustomerDAO {
//    @Override
//    public Customer findByEmail(String email) throws SQLException {
//        String sql = "SELECT * FROM customers WHERE email = ?";
//        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, email);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Customer(
//                    rs.getInt("customer_id"),
//                    rs.getString("name"),
//                    rs.getString("mobile"),
//                    rs.getString("email"),
//                    rs.getString("password")
//                );
//            }
//            return null;
//        }
//    }
//
//    @Override
//    public int createCustomer(Customer customer) throws SQLException {
//        String sql = "INSERT INTO customers (name, mobile, email, password) VALUES (?, ?, ?, ?)";
//        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//            ps.setString(1, customer.getName());
//            ps.setString(2, customer.getMobile());
//            ps.setString(3, customer.getEmail());
//            ps.setString(4, customer.getPassword());
//
//            ps.executeUpdate();
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                return rs.getInt(1);
//            } else {
//                throw new SQLException("Customer ID generation failed.");
//            }
//        }
//    }
//
//    @Override
//    public Customer findById(int id) throws SQLException {
//        String sql = "SELECT * FROM customers WHERE customer_id = ?";
//        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Customer(
//                    rs.getInt("customer_id"),
//                    rs.getString("name"),
//                    rs.getString("mobile"),
//                    rs.getString("email"),
//                    rs.getString("password")
//                );
//            }
//            return null;
//        }
//    }
//
//    @Override
//    public Customer getCustomerByAccountNum(int accountNum) throws SQLException {
//        String sql = """
//            SELECT c.customer_id, c.name, c.email, c.mobile
//            FROM customers c
//            JOIN banking_acc a ON c.id = a.customer_id
//            WHERE a.account_num = ?
//        """;
//
//        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, accountNum);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    int customerId = rs.getInt("id");
//                    String name = rs.getString("name");
//                    String email = rs.getString("email");
//                    String mobile = rs.getString("mobile");
//
//                    return new Customer(customerId, name, email, mobile,password);
//                } else {
//                    throw new SQLException("❌ No customer found for account number: " + accountNum);
//                }
//            }
//        }
//    }
//}
