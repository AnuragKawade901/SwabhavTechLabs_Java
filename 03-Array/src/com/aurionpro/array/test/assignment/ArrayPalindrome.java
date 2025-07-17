package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class ArrayPalindrome {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		int[] array = new int[size];

		System.out.println("Enter " + size + " elements: ");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		boolean isPalindrome = true;
		for (int i = 0; i < size / 2; i++) {
			if (array[i] != array[size - 1 - i]) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			System.out.println("The array is a palindrome.");

		} else {
			System.out.println("The array is not a palindrome.");
		}
		scanner.close();
	}

}
