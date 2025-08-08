package com.aurionpro.FoodOrderingProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class OrderService {
	static class MenuItem {
		int id;
		String name;
		double price;

		public MenuItem(int id, String name, double price) {
			this.id = id;
			this.name = name;
			this.price = price;
		}
	}

	static class OrderItem {
		MenuItem item;
		int qty;

		public OrderItem(MenuItem item, int qty) {
			this.item = item;
			this.qty = qty;
		}

		public double getTotal() {
			return item.price * qty;
		}
	}

	private final Scanner scanner = new Scanner(System.in);
	private final List<MenuItem> menu = new ArrayList<>();
	private final List<String> deliveryPartners = new ArrayList<>(List.of("Swiggy Guy", "Zomato Lady"));
	private double discountThreshold = 500;
	private double flatDiscount = 100;

	public OrderService() {
		menu.add(new MenuItem(1, "Paneer Butter Masala", 200));
		menu.add(new MenuItem(2, "Chicken Biryani", 250));
		menu.add(new MenuItem(3, "Tandoori Roti", 20));
		menu.add(new MenuItem(4, "Gulab Jamun", 50));
	}

	public void showMenu() {
		System.out.println("\n---- MENU ----");
		for (MenuItem m : menu) {
			System.out.printf("%d. %-25s ₹%.2f%n", m.id, m.name, m.price);
		}
	}

	public void addMenuItem() {
		try {
			System.out.print("Item name: ");
			String name = scanner.nextLine().trim();
			if (name.isEmpty())
				throw new IllegalArgumentException("Item name cannot be empty.");

			System.out.print("Price: ");
			double price = Double.parseDouble(scanner.nextLine());
			if (price <= 0)
				throw new IllegalArgumentException("Price must be greater than 0.");

			int id = menu.size() + 1;
			menu.add(new MenuItem(id, name, price));
			System.out.println("Item added successfully.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid price input. Try again.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeMenuItem() {
		try {
			showMenu();
			System.out.print("Enter item ID to remove: ");
			int id = Integer.parseInt(scanner.nextLine());

			boolean removed = menu.removeIf(m -> m.id == id);
			System.out.println(removed ? "Item removed." : "Item not found.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Enter a valid item ID.");
		}
	}

	public void setDiscountRules() {
		try {
			System.out.print("New discount threshold: ");
			discountThreshold = Double.parseDouble(scanner.nextLine());

			System.out.print("New flat discount: ");
			flatDiscount = Double.parseDouble(scanner.nextLine());

			if (discountThreshold < 0 || flatDiscount < 0)
				throw new IllegalArgumentException("Values must be positive.");

			System.out.println("Discount rules updated.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid number input.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void manageDeliveryPartners() {
		while (true) {
			try {
				System.out.println("\nCurrent Delivery Partners: " + deliveryPartners);
				System.out.print("1. Add  2. Remove  0. Back: ");
				int op = Integer.parseInt(scanner.nextLine());

				if (op == 1) {
					System.out.print("Enter name to add: ");
					String name = scanner.nextLine().trim();
					if (name.isEmpty())
						throw new IllegalArgumentException("Name cannot be empty.");
					if (deliveryPartners.contains(name)) {
						System.out.println("Partner already exists.");
					} else {
						deliveryPartners.add(name);
						System.out.println("Partner added.");
					}
				} else if (op == 2) {
					System.out.print("Enter name to remove: ");
					String name = scanner.nextLine().trim();
					if (deliveryPartners.remove(name)) {
						System.out.println("Partner removed.");
					} else {
						System.out.println("Partner not found.");
					}
				} else if (op == 0) {
					break;
				} else {
					System.out.println("Invalid choice.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void placeOrder(String customerName) {
		List<OrderItem> cart = new ArrayList<>();
		showMenu();

		while (true) {
			try {
				System.out.print("Item ID (0 to finish): ");
				int id = Integer.parseInt(scanner.nextLine());
				if (id == 0)
					break;

				Optional<MenuItem> item = menu.stream().filter(m -> m.id == id).findFirst();
				if (item.isPresent()) {
					System.out.print("Quantity: ");
					int qty = Integer.parseInt(scanner.nextLine());
					if (qty > 0)
						cart.add(new OrderItem(item.get(), qty));
					else
						System.out.println("Quantity must be > 0.");
				} else {
					System.out.println("Invalid item ID.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.");
			}
		}

		if (cart.isEmpty()) {
			System.out.println("No items selected.");
			return;
		}

		double total = cart.stream().mapToDouble(OrderItem::getTotal).sum();
		double discount = total > discountThreshold ? flatDiscount : 0;
		double finalAmount = total - discount;

		String payment = "";
		while (true) {
			System.out.print("Payment mode (1. Cash  2. UPI): ");
			String choice = scanner.nextLine().trim();
			if (choice.equals("1")) {
				payment = "Cash";
				break;
			} else if (choice.equals("2")) {
				payment = "UPI";
				break;
			} else {
				System.out.println("Invalid choice.");
			}
		}

		String delivery = deliveryPartners.get(new Random().nextInt(deliveryPartners.size()));
		printInvoice(cart, total, discount, finalAmount, payment, delivery, customerName);
	}

	private void printInvoice(List<OrderItem> cart, double total, double discount, double finalAmount, String payment,
			String delivery, String customer) {
		System.out.println("\n----- INVOICE -----");
		System.out.println("Customer: " + customer);
		for (OrderItem oi : cart) {
			System.out.printf("%-25s x%-3d = ₹%.2f%n", oi.item.name, oi.qty, oi.getTotal());
		}
		System.out.println("----------------------------");
		System.out.printf("Total: ₹%.2f\nDiscount: ₹%.2f\nFinal: ₹%.2f\n", total, discount, finalAmount);
		System.out.println("Payment Mode: " + payment);
		System.out.println("Delivery by: " + delivery);
		System.out.println("Thank you for ordering!\n");
	}
}
