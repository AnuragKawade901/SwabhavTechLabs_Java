package com.aurionpro.forloop.test;

public class PrimeNumber {
	public static void main(String[] args) {
		int number = 0;
		boolean prime = true;
		if(number <= 1) {
			prime = false;
		}
		else {
			for(int i = 2; i<= number/2; i++) {
				if(number%i == 0) {
					prime = false;
					break;
				}
			}
		}
		if(prime) {
			System.out.println(number + " Is prime");
		}
		else {
			System.out.println(number + " Not prime");
		}
	}

}
