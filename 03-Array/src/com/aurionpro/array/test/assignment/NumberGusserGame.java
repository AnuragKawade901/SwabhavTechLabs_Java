package com.aurionpro.array.test.assignment;

import java.util.Random;
import java.util.Scanner;

public class NumberGusserGame {
public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	String playAgain;
	
	do {
		int numberToGuess = random.nextInt(100) + 1;
		int attempts = 0;
		int maxAttempts = 5;
		boolean hasWon = false;
		
		System.out.println("A number between 1 to 100 has been generated.");
		System.out.println("You have a maximum of " + maxAttempts + " attempts to guess it.");
		
		while (attempts < maxAttempts) {
			System.out.println("Guess a number 🤔: ");
			int guess = scanner.nextInt();
			attempts++;
			
			if(guess< numberToGuess) {
				System.out.println("Sorry too low 👇");
		}
			else if(guess> numberToGuess) {
				System.out.println("Sorry too high 👆");
	}
			else {
				System.out.println("Hurray 🥳🥳🎊🎊 You won the game in "+attempts+" attempts");
				hasWon = true;
				break;
			}
		}
		if(!hasWon) {
			System.out.println("You used all your "+maxAttempts+" attempts 😔😔. The number was: "+ numberToGuess);
			
		}
		System.out.println("\nDo you want to play the game 🎮 again?(yes/no): ");
		scanner.nextLine();
		playAgain = scanner.nextLine().toLowerCase();
		
}
	while(playAgain.equals("yes"));
	System.out.println("Thank you for playing the game! 😊😊");

	scanner.close();
}
}
