package com.aurionpro.OCP.ClaimProcessor.model;

public class Health implements ClaimProcessor {

	@Override
	public void claim() {
		System.out.println("Health Claim");
	}

}
