package com.aurionpro.SOLIDS.Order.model;

public class CreditCardProcessor extends PaymentProcessor {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Paid " + amount + " using Credit Card");
	}

}
