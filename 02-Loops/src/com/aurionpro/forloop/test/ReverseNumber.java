package com.aurionpro.forloop.test;

public class ReverseNumber {
	public static void main(String[] args) {
		int number = 1234;
		int reverse = 0;
		for(; number != 0; number = number / 10) {
			int digit = number % 10;
			reverse = reverse*10+digit;
		}
		System.out.println(reverse);
	}

}
