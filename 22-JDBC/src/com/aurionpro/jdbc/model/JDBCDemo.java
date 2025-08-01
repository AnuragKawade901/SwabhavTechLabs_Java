package com.aurionpro.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class JDBCDemo {
	public static void main(String[] args) throws Exception {

		// registration
		Class.forName("com.mysql.cj.jdbc.Driver");

		// create connection

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "Anika@178");
		System.out.println("Connection successfully");
//
//		// Insert data into the table
//		String insertQuery = "insert into employee(id, name, salary) values(?,?,?)";
//		PreparedStatement ps = connection.prepareStatement(insertQuery);
//
//		// 1st record
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
//
//		System.out.println(numberOfRowsAffected + " rows inserted successfully");
//		
		//read table
//		String selectQuery = "select * from employee";
//		
//		Statement st = connection.createStatement();
//		ResultSet rs = st.executeQuery(selectQuery);
//		
//		while(rs.next())
//		{
//			System.out.println(rs.getInt("id") + " - "+rs.getString("name")+" - "+rs.getDouble("Salary") );
//		}
		
//		//update table
//		String updateQuery = "update employee set salary = ? where id = ?";
//		
//		PreparedStatement ps = connection.prepareStatement(updateQuery);
//		   ps.setDouble(1, 150.0);  // New salary
//	        ps.setInt(2, 101);          // Employee ID
//	        
//	        int rowsUpdated = ps.executeUpdate();
//
//	        // Step 7: Result message
//	        System.out.println(rowsUpdated + " row(s) updated successfully.");
	        
	        
	        // delete table
	        String deleteQuery = "delete from employee where id = ?";
	        
			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			ps.setInt(1, 101);
			
			 int rowsUpdated = ps.executeUpdate();

		        // Step 7: Result message
		        System.out.println(rowsUpdated + " row(s) updated successfully.");
			

		
	}
}

