package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.comparator.model.Product;
import com.aurionpro.comparator.model.ProductComparator;

public class ProductTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) throw new IllegalArgumentException("Number must be positive.");
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter a valid integer: ");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Try again: ");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1) + ":");

            // Category input with validation
            String category;
            while (true) {
                System.out.print("Category: ");
                category = scanner.nextLine().trim();
                if (!category.isEmpty() && category.matches("^[A-Za-z ]+$")) {
                    break;
                } else {
                    System.out.println("Invalid category. Use only alphabets and spaces.");
                }
            }

            // Name input with validation
            String name;
            while (true) {
                System.out.print("Name: ");
                name = scanner.nextLine().trim();
                if (!name.isEmpty() && name.matches("^[A-Za-z ,.:'\"!?()-]+$")) {
                    break;
                } else {
                    System.out.println("Invalid name. Use letters, numbers, and basic punctuation.");
                }
            }

            // Price input with validation
            double price;
            while (true) {
                System.out.print("Price $: ");
                try {
                    price = Double.parseDouble(scanner.nextLine());
                    if (price < 0) throw new IllegalArgumentException("Price must be non-negative.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a valid number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            products.add(new Product(category, name, price));
        }

        // Sort and display
        products.sort(new ProductComparator());

        System.out.println("\n--- Sorted Product List (by Category, then Price Ascending) ---");
        for (Product p : products) {
            System.out.println(p);
        }

        scanner.close();
    }
}
