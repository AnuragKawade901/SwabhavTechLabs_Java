package com.aurionpro.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {

		// registration
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root",
				"Anika@178");
		System.out.println("Connection successfully");
		
		// Insert data into the table
		String insertQuery = "insert into emp(id, name, salary) values(?,?,?)";
		PreparedStatement ps = connection.prepareStatement(insertQuery);
		
		// 1st record
//		ps.setInt(1, 101);
//		ps.setString(2, "Anurag");
//		ps.setDouble(3, 100000.1);
//		int numberOfRowsAffected = ps.executeUpdate();
//
//		// 2nd record
//		ps.setInt(1, 102);
//		ps.setString(2, "Kawade");
//		ps.setDouble(3, 1111111111.11);
//		numberOfRowsAffected += ps.executeUpdate();
		
		
	}
}
