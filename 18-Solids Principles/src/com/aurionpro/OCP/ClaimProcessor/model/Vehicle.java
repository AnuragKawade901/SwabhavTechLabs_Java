package com.aurionpro.OCP.ClaimProcessor.model;

public class Vehicle implements ClaimProcessor {

	@Override
	public void claim() {
		System.out.println("Vehicle Claim");
		
	}

}
