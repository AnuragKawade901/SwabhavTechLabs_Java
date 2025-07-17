package com.aurionpro.OCP.ClaimProcessor.model;

public class Travel implements ClaimProcessor {

	@Override
	public void claim() {
		System.out.println("Travel Claim");		
	}
	

}
