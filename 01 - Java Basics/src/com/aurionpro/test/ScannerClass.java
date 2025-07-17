package com.aurionpro.test;

import java.util.Scanner;

public class ScannerClass {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String username = scanner.nextLine();

		System.out.println("Enter age: ");
		int age = scanner.nextInt();

		System.out.println("Your name is " + username + ", your age is " + age);
	
		scanner.close();
	}

}