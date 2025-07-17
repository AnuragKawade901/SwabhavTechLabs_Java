package com.aurionpro.test;

import java.util.Scanner;

public class CalculatorSwitch {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number 1: ");
		int number1 = scanner.nextInt();

		System.out.println("Enter number 2: ");
		int number2 = scanner.nextInt();

		System.out.println("Enter choice: 1 to 4");
		int symbol = scanner.nextInt();

		switch (symbol) {
		case 1:
			System.out.println("Addition: " + (number1 + number2));
			break;

		case 2:
			int subtract = number1 - number2;
			System.out.println("Subtraction: " + subtract);
			break;

		case 3:
			System.out.println("Multiplication: " + number1 * number2);
			break;

		case 4:
			System.out.println("Division: " + number1 / number2);
			break;

		default:
			System.out.println("Enter right choice");
			break;
		}
		scanner.close();

	}
}
