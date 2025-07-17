package com.aurionpro.test.assignment;

import java.util.Scanner;

public class WaterBillGenerator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of units consumed: ");
		int units = scanner.nextInt();

		int meterCharge = 75;
		int charge = 0;

		if (units <= 100) {
			charge = units * 5;
		} else if (units <= 250) {
			charge = units * 10;
		} else {
			charge = units * 20;
		}

		int totalWaterbill = charge + meterCharge;
		System.out.println("Total water bill is: " + totalWaterbill);

		scanner.close();
	}

}
