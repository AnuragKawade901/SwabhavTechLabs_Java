package com.aurionpro.test.assignment;

import java.util.Scanner;

public class RideBillGenerator {
	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your height: ");
		int height = scanner.nextInt();
		if(height<=120) {
			System.out.println("Can't ride");
		}
		else {
			System.out.println("Hurray! You can ride. Enter your age: ");
			
			int age = scanner.nextInt();
			int bill = 0;
			if(age>=45 && age <= 55) {
				bill = 0;
			}
			else if(age< 12) {
				bill = 5;
			}
			else if(age >=12 && age<=18) {
				bill = 7;
			}
			else {
				bill = 12;
			}
			System.out.println("Do you want photos?(yes/no): ");
			
			String photochoice = scanner.next().toLowerCase();
			
			if(photochoice.equals("yes")) {
				bill += 3;
			}
			System.out.println("The total bill is $" + bill);
			
		}
		scanner.close();
	}
}