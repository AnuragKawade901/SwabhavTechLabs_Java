package com.aurionpro.FoodOrderingProject.model;

import java.util.Scanner;

public class AdminService {
	private final Scanner scanner = new Scanner(System.in);
	private final String USERNAME = "admin";
	private final String PASSWORD = "admin123";

	public boolean login() {
		System.out.print("Admin Username: ");
		String u = scanner.nextLine();
		System.out.print("Admin Password: ");
		String p = scanner.nextLine();

		if (USERNAME.equals(u) && PASSWORD.equals(p))
			return true;
		System.out.println("Invalid credentials.");
		return false;
	}

	public void adminMenu(OrderService orderService) {
		while (true) {
			try {
				System.out.println("\n--- Admin Menu ---");
				System.out.println("1. View Menu");
				System.out.println("2. Add Menu Item");
				System.out.println("3. Remove Menu Item");
				System.out.println("4. Set Discount Rules");
				System.out.println("5. Manage Delivery Partners");
				System.out.println("6. Logout");
				System.out.print("Choice: ");
				int ch = Integer.parseInt(scanner.nextLine().trim());

				switch (ch) {
				case 1 -> orderService.showMenu();
				case 2 -> orderService.addMenuItem();
				case 3 -> orderService.removeMenuItem();
				case 4 -> orderService.setDiscountRules();
				case 5 -> orderService.manageDeliveryPartners();
				case 6 -> {
					System.out.println("Admin logged out.");
					return;
				}
				default -> System.out.println("Invalid option.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}
	}
}