package com.aurionpro.OCP.ClaimProcessor.model;

public class Property implements ClaimProcessor {

	@Override
	public void claim() {
		System.out.println("Property Claim");
	}

}
