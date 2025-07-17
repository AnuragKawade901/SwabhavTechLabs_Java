package com.aurionpro.array.test;

import java.util.Scanner;

public class SumOfElementsArray {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		int sum = 0;
		int[] array = new int[size];

		System.out.println("Enter " + size + " elements");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
			sum = sum + array[i];
		}
		System.out.println("Sum of the all elements in the array: " + sum);
		scanner.close();
	}
}
