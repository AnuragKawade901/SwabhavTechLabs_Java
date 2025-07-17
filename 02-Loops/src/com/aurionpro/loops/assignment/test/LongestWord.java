package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class LongestWord {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a sentence: ");
	String sentence = scanner.nextLine();
	
	String[] words = sentence.split(" ");
	
	String longest = "";
	for(int i = 0; i<words.length; i++) {
		if(words[i].length()>longest.length()) {
			longest = words[i];
		}
	}
	System.out.println("Longest word is: "+longest);
	
	scanner.close();
}
}
