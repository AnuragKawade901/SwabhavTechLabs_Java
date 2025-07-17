package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class FindDuplicateCharacters {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a string: ");
		String input = scanner.nextLine();

		boolean[] printed = new boolean[256]; // ascii size
		System.out.println("Duplicate characters: ");
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			int count = 0;

			if (printed[character]) {
				continue;
			}
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == character) {
					count++;
				}
			}
			if (count > 1) {
				System.out.println(character + " ");
				printed[character] = true;
			}
		}
		scanner.close();
	}
}
