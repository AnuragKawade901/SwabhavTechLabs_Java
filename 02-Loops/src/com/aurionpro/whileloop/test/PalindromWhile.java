package com.aurionpro.whileloop.test;

public class PalindromWhile {
	public static void main(String[] args) {
		int number = 212;
		int reverse = 0;
		int realnumber = number;
		while(number!=0) {
			int digit = number % 10;
			reverse = reverse*10+digit;
			number = number / 10;
		}
		if(realnumber == reverse) {
			System.out.println(realnumber + " is Palindrom");
		}
		else {
			System.out.println(realnumber + " is not Palindrom");
		}
	}

}
