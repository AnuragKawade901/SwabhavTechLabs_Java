package com.aurionpro.model;

public class Stripe implements IPaymentGateway{
	@Override
	public void processPayment() {
		System.out.println("Processing payment via Stripe");
	}

}
