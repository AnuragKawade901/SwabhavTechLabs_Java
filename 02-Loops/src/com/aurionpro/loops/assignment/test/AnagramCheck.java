package com.aurionpro.loops.assignment.test;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first string: ");
		String string1 = scanner.nextLine().toLowerCase();

		System.out.println("Enter second String:");
		String string2 = scanner.nextLine().toLowerCase();

		string1 = string1.replaceAll("\\s", "");
		string2 = string2.replaceAll("\\s", "");

		if (string1.length() != string2.length()) {
			System.out.println("No, the strings are not anagrams.");

		} else {
			char[] array1 = string1.toCharArray();
			char[] array2 = string2.toCharArray();

			Arrays.sort(array1);
			Arrays.sort(array2);

			boolean result = true;
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] != array2[i]) {
					result = false;
					break;
				}
			}
			if (result) {
				System.out.println("yes, the strings are anagrams");

			} else {
				System.out.println("no, the strings are not anagrams");

			}

		}
		scanner.close();
	}
}
