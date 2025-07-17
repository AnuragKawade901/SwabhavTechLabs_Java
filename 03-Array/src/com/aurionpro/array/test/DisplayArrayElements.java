package com.aurionpro.array.test;

import java.util.Scanner;

public class DisplayArrayElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size of the array");
		int size = scanner.nextInt();

		int[] numbers = new int[size];

		System.out.println("Enter the number: ");

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt(); // store
		}
		System.out.println("You have entered: "); // fetch
		for (int result : numbers) {
			System.out.println(result); // for each loop

		}

	scanner.close();}
}
