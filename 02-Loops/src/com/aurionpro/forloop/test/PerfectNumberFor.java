package com.aurionpro.forloop.test;

public class PerfectNumberFor {
public static void main(String[] args) {
	 
	int number = 28;
	int sum = 0;
	
	//find all divisors and sum them
	for(int i = 1;i<number;i++) {
		if(number %i == 0) {
			sum += i;
		}
	}
	//check if sum equals the number
	if(sum ==  number) {
		System.out.println(number + " is a perfect number.");
	}
	else {
		System.out.println(number + " is not a perfect number");
	}
}
}
