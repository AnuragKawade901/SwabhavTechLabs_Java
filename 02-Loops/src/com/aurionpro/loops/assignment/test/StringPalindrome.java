package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class StringPalindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a string to check if its palindrome");

		String userInput = scanner.nextLine().toLowerCase();
		
		userInput = userInput.replace(" ", " ");
		
		boolean isPalindrome = true;
		
		for(int i = 0; i<userInput.length()/2; i++) {
			
			if(userInput.charAt(i) != userInput.charAt(userInput.length()-1-i))
			{
				isPalindrome = false;
				break;
			}
		}
		
		if(isPalindrome) {
			System.out.println("The string is a palindrome");
		}
		else {
			System.out.println("Not a palindrome");
		}
		scanner.close();
	}
}
