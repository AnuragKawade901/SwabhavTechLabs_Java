package com.aurionpro.array.product.test;

import java.util.Scanner;

import com.aurionpro.array.test.assignment.Product;

public class ProductTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter number of products: ");
	int number = scanner.nextInt();
	scanner.nextLine();
	
	Product[] products = new Product[number];
	
	for(int i = 0; i<number; i++) {
		System.out.println("\nEnter details for product "+(i+1)+": ");
		System.out.println("Product Name: ");
		String name = scanner.nextLine();
		
		System.out.println("Price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();
		
		products[i] = new Product(name, price);
		
	}
	System.out.println("\nProducts with price less than $1000: ");
	boolean found = false;
	for(Product iteam: products) {
		if(iteam.price < 1000) {
			System.out.println("-"+iteam.name);
			found = true;
		}
	}
	if(!found) {
		System.out.println("No products found under $1000");
	}
	scanner.close();
}
}
