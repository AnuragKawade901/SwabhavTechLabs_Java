package com.aurionpro.strings.test;

import java.util.Scanner;

public class CheckTwoStringReverse {
public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter string 1:");
		String string1 = scanner.nextLine();
		System.out.println("Enter string 2:");
		String string2 = scanner.nextLine();

		StringBuilder stringBuilder = new StringBuilder(string2);
		stringBuilder.reverse();
		if (string1.equals(stringBuilder.toString())) {
			System.out.println("it is reverse");
		}
		else {
			System.out.println("Not reverse");
		}
	}
}
