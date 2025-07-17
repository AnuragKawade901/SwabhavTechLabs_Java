package com.aurionpro.SOLIDS.Order.model;

public class PayPalProcessor extends PaymentProcessor{

	@Override
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using PayPal");		
	}

}
