package com.aurionpro.strings.test;

import java.util.Scanner;

public class RemoveSpaces {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter input as sentence: ");
		String input = scanner.nextLine();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if (character != ' ') {
				stringBuilder.append(character);
			}
		}
		System.out.println("Original: " + input);
		System.out.println("After removing spaces: " + stringBuilder.toString());
		
		scanner.close();
	}
}
