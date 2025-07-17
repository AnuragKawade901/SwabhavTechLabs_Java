package com.aurionpro.polymorphism.model;

public class SafeCalculator {
public int  divide(int a , int b) {
	if(b == 0) {
		System.out.println("Invalid: division by zero");
		return -1;
	}
	return a/b;
}
public double divide(double a, double b) {
	if(b == 0.0) {
		System.out.println("Invlid: division by zero");
		return -1.0;
	}
	return a/b;
	
}
}
