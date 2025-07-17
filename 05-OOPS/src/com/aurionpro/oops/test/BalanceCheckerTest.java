package com.aurionpro.oops.test;

import java.util.Scanner;

import com.aurionpro.oops.model.BalanceChecker;

public class BalanceCheckerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of accounts needed to be displayed:");
		int number = scanner.nextInt();
		scanner.nextLine();

		BalanceChecker[] account = new BalanceChecker[number];
		for (int i = 0; i < number; i++) {
			System.out.println("Enter details here");
			System.out.println("Enter account number");
			int accNumber = scanner.nextInt();

			System.out.println("Enter account Holder");
			String accName = scanner.nextLine();

			System.out.println("Enter balance");
			double accBalance = scanner.nextDouble();

			account[i] = new BalanceChecker();
			account[i].setAccountNumber(accNumber);
			account[i].setAccountHolder(accName);
			account[i].setAccountBalance(accBalance);
		}
		for (BalanceChecker result : account) {
			result.display();
		}
		scanner.close();
	}
}
