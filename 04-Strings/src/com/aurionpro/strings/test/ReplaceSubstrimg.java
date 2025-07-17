package com.aurionpro.strings.test;

import java.util.Scanner;

public class ReplaceSubstrimg {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter sentence: ");
		String sentence = scanner.nextLine();
		
		StringBuilder stringBuilder = new StringBuilder(sentence);
		int indexOf = stringBuilder.indexOf("bad");
		stringBuilder.replace(indexOf, indexOf+3, "good");
		System.out.println(stringBuilder);
		
		
		scanner.close();
	}
}
