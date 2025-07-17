package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class RepeationInArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of the array: ");
		int size = scanner.nextInt();

		int[] array = new int[size];
		System.out.println("Enter the number: ");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Enter the number to find its repeation: ");
		int target = scanner.nextInt();

		int count = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] == target) { // to find the target
				count++;
			}
		}
		System.out.println("Number " + target + " appears " + count + " times");
		scanner.close();
	}
}
