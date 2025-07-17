package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class SubstringArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter word: ");
		String input = scanner.nextLine();
		
		int length = input.length();
		String[] substrings = new String[length * (length + 1)/2]; //total substring
		
		int index = 0;
		
		for(int i =0; i<length;i++) {
			for(int j=i+1;j<= length;j++) {
				substrings[index++] = input.substring(i,j);
			}
		}
		
		System.out.println("Susbstring are: ");
		for(String s : substrings) {
			System.out.println(s);
		}
				
				
				
				
		scanner.close();
	}
}
