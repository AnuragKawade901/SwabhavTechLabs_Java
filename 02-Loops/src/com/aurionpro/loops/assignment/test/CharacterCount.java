package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class CharacterCount {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a string: ");
	String input = scanner.nextLine();
	
	int letter = 0, digits = 0, special = 0;
	
	for(int i = 0; i < input.length(); i++) {
		char character = input.charAt(i);
		if(Character.isLetter(character)) {
			letter++;
		}
		else if(Character.isDigit(character)) {
			digits++;
		}else {
			special++;
		}
	}
	System.out.println("Letter count: "+letter+ " , digit count: "+digits+ " , special count: "+special);
}
}
