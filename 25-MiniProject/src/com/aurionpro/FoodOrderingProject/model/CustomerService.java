package com.aurionpro.FoodOrderingProject.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerService {
	private final Scanner scanner = new Scanner(System.in);
	private final Map<String, String> customers = new HashMap<>();
	private final String FILE_PATH = "customers.txt";

	public CustomerService() {
		loadCustomersFromFile();
	}

	public void register() {
		try {
			System.out.print("Username: ");
			String username = scanner.nextLine().trim();

			if (username.isBlank()) {
				System.out.println("Username cannot be empty.");
				return;
			}
			if (customers.containsKey(username)) {
				System.out.println("Username already exists.");
				return;
			}

			System.out.print("Password: ");
			String password = scanner.nextLine().trim();

			if (password.isBlank()) {
				System.out.println("Password cannot be empty.");
				return;
			}

			customers.put(username, password);
			saveCustomerToFile(username, password);
			System.out.println("Registered successfully!");
		} catch (Exception e) {
			System.out.println("Error during registration: " + e.getMessage());
		}
	}

	public String login() {
		try {
			System.out.print("Username: ");
			String username = scanner.nextLine().trim();
			System.out.print("Password: ");
			String password = scanner.nextLine().trim();

			if (customers.containsKey(username) && customers.get(username).equals(password)) {
				System.out.println("Login successful!");
				return username;
			}

			System.out.println("Invalid credentials.");
		} catch (Exception e) {
			System.out.println("Login error: " + e.getMessage());
		}
		return null;
	}

	private void loadCustomersFromFile() {
		File file = new File(FILE_PATH);
		if (!file.exists()) {
			return;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",", 2);
				if (parts.length == 2) {
					customers.put(parts[0], parts[1]);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading customer data: " + e.getMessage());
		}
	}

	private void saveCustomerToFile(String username, String password) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			bw.write(username + "," + password);
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error saving customer: " + e.getMessage());
		}
	}
}