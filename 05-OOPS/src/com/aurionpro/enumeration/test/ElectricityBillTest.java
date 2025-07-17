package com.aurionpro.enumeration.test;

import java.util.Scanner;

import com.aurionpro.enumeration.model.ElectricityBill;

public class ElectricityBillTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ElectricityBill.displayCurrentRate();

		System.out.print("Enter apartment number: ");
		int apartmentNo = scanner.nextInt();

		System.out.print("Enter units consumed: ");
		int units = scanner.nextInt();

		ElectricityBill bill = new ElectricityBill(apartmentNo, units);
		bill.displayBill();

		System.out.print("Do you want to change cost per unit? (yes/no): ");
		String change = scanner.next();

		if (change.equalsIgnoreCase("yes")) {
			System.out.print("Enter new cost per unit: ");
			double newRate = scanner.nextDouble();
			ElectricityBill.setCostPerUnit(newRate);
			ElectricityBill.displayCurrentRate();
		}

		System.out.print("Enter apartment number for second bill: ");
		apartmentNo = scanner.nextInt();

		System.out.print("Enter units consumed: ");
		units = scanner.nextInt();

		ElectricityBill anotherBill = new ElectricityBill(apartmentNo, units);
		anotherBill.displayBill();

		scanner.close();
	}
}
