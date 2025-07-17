package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.Adder;

public class AdderTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Addition");
		System.out.println("Enter number 1");
		int number1 = scanner.nextInt();
		
		System.out.println("Enter number 2");
		int number2 = scanner.nextInt();
		
		System.out.println("Enter number 3");
		int number3 = scanner.nextInt();
		
		System.out.println("Enter number 4");
		double number4 = scanner.nextInt();
		
		System.out.println("Enter number 5");
		double number5 = scanner.nextInt();
		
		Adder adder = new Adder();
		adder.add(number1, number2);
		adder.add(number4, number5);
		adder.add(number1, number2, number3);
	}
}
