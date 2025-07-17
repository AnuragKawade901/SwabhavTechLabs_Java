package com.aurionpro.test;

import java.util.Scanner;

public class SimpleInterestUsingMethod {
	public static float simpleinterest(float principal, float rate, float time) {
		
		return (principal * rate * time)/100;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter principal: ");
		float principal = scanner.nextFloat();
		
		System.out.println("Enter rate: ");
		float rate = scanner.nextFloat();
		
		System.out.println("Entet time: ");
		float time = scanner.nextFloat();
		
		System.out.println("The simple interest as per your given data is: "+simpleinterest(principal, rate, time));
		
		scanner.close();
	}
}
