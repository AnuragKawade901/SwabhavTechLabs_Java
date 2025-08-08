package com.aurionpro.FoodOrderingProject.model;

import java.util.Scanner;

public class FoodOrderingFacade {
	private final AdminService adminService = new AdminService();
	private final CustomerService customerService = new CustomerService();
	private final OrderService orderService = new OrderService();

	private final Scanner scanner = new Scanner(System.in);

	public void startApp() {
		while (true) {
			try {
				System.out.println("\n===== Mini Food Ordering System =====");
				System.out.println("1. Admin Login");
				System.out.println("2. Customer Login");
				System.out.println("3. Register as Customer");
				System.out.println("4. Exit");
				System.out.print("Choice: ");
				int choice = Integer.parseInt(scanner.nextLine().trim());

				switch (choice) {
				case 1 -> {
					if (adminService.login())
						adminService.adminMenu(orderService);
				}
				case 2 -> {
					String customer = customerService.login();
					if (customer != null)
						orderService.placeOrder(customer);
				}
				case 3 -> customerService.register();
				case 4 -> {
					System.out.println("Goodbye!");
					return;
				}
				default -> System.out.println("Invalid choice.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid numeric choice.");
			}
		}
	}
}