package com.aurionpro.oops.test;

import java.util.Scanner;

import com.aurionpro.oops.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of products: ");
		int number = scanner.nextInt();
		scanner.nextLine();
		Product[] products = new Product[number];

		for (int i = 0; i < number; i++) {
			System.out.println("Enter the details for product:");
			System.out.println("Enter product name");
			
			String name = scanner.nextLine();
			System.out.println("Enter price: ");
			double productPrice = scanner.nextDouble();
			
			System.out.println("Enter quantity: ");
			int productQuantity = scanner.nextInt();
			scanner.nextLine();
			
			products[i] = new Product();
			products[i].setProductName(name);
			products[i].setPrice(productPrice);
			products[i].setQuantity(productQuantity);
		}
		for(Product result:products) {
			result.display();			
		}
		scanner.close();
	}
}
