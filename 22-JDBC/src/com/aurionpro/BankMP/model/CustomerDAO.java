package com.aurionpro.BankMP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDAO {
    private Scanner sc = new Scanner(System.in);

    public void createCustomer(AccountService accountService) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter First Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Surname: ");
            String surname = sc.nextLine();
            System.out.print("Enter Mobile (10 digit): ");
            String mobile = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Create 4-digit PIN: ");
            int pin = sc.nextInt();
            sc.nextLine();
            System.out.print("Set Password: ");
            String password = sc.nextLine();

            String customerId = "SBJ" + (int)(Math.random() * 9000 + 1000);
            String upi = mobile + "@oksbj";

            String sql = "INSERT INTO customers(customer_id, name, surname, mobile, email, password, pin) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, mobile);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setInt(7, pin);
            ps.executeUpdate();

            System.out.print("Enter initial deposit: ");
            double initialDeposit = sc.nextDouble();
            long accountNumber = (long)(Math.random() * 90000000L + 10000000L);
            accountService.createAccount(conn, accountNumber, customerId, initialDeposit, upi);

            System.out.println("\nAccount Created Successfully ✅");
            System.out.println("Customer ID: " + customerId);
            System.out.println("Account Number: " + accountNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void login(AccountService accountService, TransactionService transactionService) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter Customer ID: ");
            String customerId = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String sql = "SELECT * FROM customers WHERE customer_id = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int attempts = 0;
                while (attempts < 3) {
                    System.out.print("Enter 4-digit PIN: ");
                    int pin = sc.nextInt();
                    if (pin == rs.getInt("pin")) {
                        System.out.println("\n✅ Login Successful. Welcome " + rs.getString("name") + "!");
                        accountService.accountMenu(customerId, transactionService);
                        return;
                    } else {
                        attempts++;
                        System.out.println("❌ Incorrect PIN. Attempts left: " + (3 - attempts));
                    }
                }
                System.out.println("\nToo many failed attempts. Redirecting to login menu...\n");
            } else {
                System.out.println("\n❌ Invalid Customer ID or Password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
