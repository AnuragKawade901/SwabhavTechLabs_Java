package com.aurionpro.test.assignment;

import java.util.Scanner;

public class TreasureIslandGame {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Teasure Island Game");
		System.out.println("Enter your name: ");
		String playername = scanner.nextLine();

		System.out.println("Find the teasure by using the following instructions.");
		System.out.println("Left or Right? ");
		String choice1 = scanner.nextLine();
		if(choice1.equals("left")) {
			System.out.println("Swim or wait? ");
			
			String choice2 = scanner.nextLine();
			
			if(choice2.equals("wait")) {
				System.out.println("Which door? (Red/Blue/Yellow): ");
				
				String choice3 = scanner.nextLine();
				if(choice3.equals("red")) {
					System.out.println("Burned by fire. GAME OVER");
				}
				else if(choice3.equals("blue")) {
					System.out.println("Eaten by Beast. GAME OVER");
				}
				else if(choice3.equals("yellow")) {
					System.out.println("You win!!");
				}
				else {
					System.out.println("Game Over");
				}
			}
			else {
				System.out.println("Attacked by trout. GAME OVER");
			}
		}
		else {
			System.out.println("Fall into a hole. GAME OVER");
		}
		scanner.close();
	}
}
