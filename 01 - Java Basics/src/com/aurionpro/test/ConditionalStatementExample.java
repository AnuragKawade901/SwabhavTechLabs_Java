package com.aurionpro.test;

public class ConditionalStatementExample {
	public static void main(String[] args) {

		int number1 = 5;
		int number2 = 6;
		int number3 = 7;
		if (number1 > number2 && number1 > number3) {
			System.out.println("Number 1 is greater");
		} else if (number2 > number3 && number2 > number3) {
			System.out.println("Number 2 is greater");
		} else {
			System.out.println("Number 3 is greater");
		}
	}
}
