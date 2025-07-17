package com.aurionpro.whileloop.test;

public class PerfectNumberWhile {
	public static void main(String[] args) {
		int number = 28;
		int sum = 0;
		
		int i = 1;
		while(i < number) {
			if(number%i == 0) {
				sum+=1;
			}
			i++;
		}
		if(sum ==  number) {
			System.out.println(number + " is a perfect number.");
		}
		else {
			System.out.println(number + " is not a perfect number");
		}
	}
}
