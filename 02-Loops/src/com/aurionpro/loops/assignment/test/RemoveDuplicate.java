package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class RemoveDuplicate {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String userInput = scanner.nextLine().toLowerCase();
		
		String result = "";
		
		for(int i = 0; i < userInput.length(); i++) {
			char character = userInput.charAt(i);
			
			boolean isDuplicate = false;
			for(int j = 0; j<result.length(); j++)
			{
				if(result.charAt(j) == character) {
					isDuplicate = true;
					break;
				}
			}
			if(!isDuplicate) {
				result += character;
			}
		}
		System.out.println("String after removing duplicates: "+result);
		scanner.close();
	}
}
