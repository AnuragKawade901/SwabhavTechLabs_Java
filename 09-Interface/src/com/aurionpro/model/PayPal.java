package com.aurionpro.model;

public class PayPal implements IPaymentGateway {
	
	@Override
	public void processPayment() {
		System.out.println("Processing payment via PayPal");
	}

}
