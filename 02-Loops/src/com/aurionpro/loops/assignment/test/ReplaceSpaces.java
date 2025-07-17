package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class ReplaceSpaces {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a sentece: ");
	String sentence = scanner.nextLine();
	
	char[] characters = sentence.toCharArray();
	
	for(int i = 0; i< characters.length; i++) {
		if(characters[i] == ' ') {
			characters[i] = '-';
		}
	}
	String result = "";
	for(char character : characters) {
		result += character;
	}
	System.out.println("Modified string: "+result);
	
	scanner.close();

}
}
