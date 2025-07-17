package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.BillGenerator;

public class BillGeneratorTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter Item name: ");
	String item = scanner.nextLine();
	
	System.out.println("Enter Quantity: ");
	int quantity = scanner.nextInt();
	
	System.out.println("Enter discount: ");
	double discount = scanner.nextDouble();
	
	System.out.println("Enter tax: ");
	double tax = scanner.nextDouble();
	
	BillGenerator bill = new BillGenerator();
	bill.generateBill(item, quantity);
	bill.generateBill(item, quantity, discount);
	bill.generateBill(item, quantity, discount, tax);
	
	scanner.close();
}
}
