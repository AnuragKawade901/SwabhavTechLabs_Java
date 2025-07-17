package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.DiscountCalculator;

public class DiscountTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	DiscountCalculator calculator = new DiscountCalculator();
	
	System.out.println("Enter product price: $");
	double price = scanner.nextDouble();
	
	double finalPrice1 = calculator.calculateDiscount(price);
	System.out.println("Final price (no coupn, non member): $"+finalPrice1);
	
	System.out.println("Enter coupn code: ");
	String coupon = scanner.nextLine();
	double finalPrice2 = calculator.calculateDiscount(price, coupon);
	System.out.println("Final Price (with coupon): $"+finalPrice2);
	
	System.out.println("Are you a member? (true/false): ");
	boolean isMember = scanner.nextBoolean();
	double finalPrice3 = calculator.calculateDiscount(price, coupon, isMember);
	System.out.println("Final Price (with coupon and member): $"+finalPrice3);
	
	scanner.close();
}
}
