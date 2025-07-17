package com.aurionpro.model;

public class RazorPay implements IPaymentGateway {
	@Override
	public void processPayment() {
		System.out.println("Processing payment via RazorPay");
	}

}
