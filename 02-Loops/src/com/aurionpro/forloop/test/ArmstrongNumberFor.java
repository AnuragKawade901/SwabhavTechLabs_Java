package com.aurionpro.forloop.test;

public class ArmstrongNumberFor {
	public static void main(String[] args) {

		int number = 153;
		int original = number;
		int sum = 0;

		for (; number != 0; number = number / 10) {
			int digit = number % 10;
			sum = sum + (digit * digit * digit);
		}
		if (sum == original) {
			System.out.println(original + " is an Armstrong Number");
		}
		else {
			System.out.println(number + " is not an armstrong number");
		}
	}
}
