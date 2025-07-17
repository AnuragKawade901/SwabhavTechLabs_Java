package com.aurionpro.model;

public class AgeEligibility extends RuntimeException {
	public AgeEligibility() {
		System.out.println("Under age");
	}
	
	public AgeEligibility(String message) {
		super(message);
	}
}
