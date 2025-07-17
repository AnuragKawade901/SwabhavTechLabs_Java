package com.aurionpro.forloop.test;

public class SumOfDigitsOfNumberFor {
	public static void main(String[] args) {
		int number = 1234;
		int sum = 0;
		for(; number !=0; number = number /10) {
			int digit = number % 10;
			sum = sum + digit;
		}
		System.out.println("Sum of the digits = " + sum);
	}
}
