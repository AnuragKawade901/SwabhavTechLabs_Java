package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class CountVowels {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String userInput = scanner.nextLine().toLowerCase();

		int vowelCount = 0;

		for (int i = 0; i < userInput.length(); i++) {
			char character = userInput.charAt(i);

			if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
				vowelCount++;

			}
		}
		System.out.println("Number of vowels: "+vowelCount);
		
		scanner.close();
	}
}
