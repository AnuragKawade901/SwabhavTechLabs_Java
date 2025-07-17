package com.aurionpro.test.assignment;

import java.util.Scanner;

public class CurrencDenominationApp {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter withdrawal amount: ");
		int amount = scanner.nextInt();
		
		if(amount>50000) {
			System.out.println("Amount exceeds withdrawal limit of 50000");
		}
		else if(amount % 100!=0) {
			System.out.println("Amount should be in multiples of 100");
		}
		else {
			int twothousand = amount/2000;
			amount = amount % 2000; // 2000 note
			System.out.println("Two thousand: "+twothousand);

			int fivehundred = amount/500;
			amount = amount%500; // 500 note
			System.out.println("five hundred : "+fivehundred);

			
			int twohundred = amount/200;
			amount = amount%200;  //200 note
			System.out.println("two hundred: "+twohundred);

			
			int onehundred = amount/100;
			amount = amount%100; // 100 note
			System.out.println("one hundred: "+onehundred);

		}
		scanner.close();
	}
}
