package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class CharacterFrequency {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a string: "); //input from user
	String userInput = scanner.nextLine().toLowerCase();
	
	System.out.println("Enter a character to  find its frequency: ");
	char character = scanner.next().toLowerCase().charAt(0);
	 
	int count = 0;
	
	for(int i = 0; i< userInput.length();i++) {
		if(userInput.charAt(i) == character) {
			count++;
		}
	}
	System.out.println("Frequency of '" +character+"' = "+count);
	scanner.close();
}
}
