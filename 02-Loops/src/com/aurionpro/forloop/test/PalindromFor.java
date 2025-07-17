package com.aurionpro.forloop.test;

public class PalindromFor {
	public static void main(String[] args) {
		int number = 121;
		int realnumber = number;
		int reverse = 0;
		for(; number != 0; number = number / 10) {
			int digit = number % 10;
			reverse = reverse * 10 + digit;
			}
		if(realnumber == reverse) {
			System.out.println(realnumber + " is Palindrom");
		}
		else {
			System.out.println(realnumber + " is not Palindrom");
		}
	}
}
