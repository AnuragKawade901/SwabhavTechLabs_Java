package com.aurionpro.loops.assignment.test;

import java.util.Scanner;

public class WordCount {
public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 
	 System.out.println("Enter a sentence: ");
	 String userInput = scanner.nextLine();
	 
	 String[] words = userInput.trim().split("\\s+");
	 
	 int wordCount = userInput.trim().isEmpty() ? 0:
		 words.length;
	 
	 System.out.println("Number of words: "+wordCount);
	 
	 scanner.close();
}
}
