package com.aurionpro.ecommerce.model;

public class CreditCard implements IPaymentGateway {
	private String cardNumber;
	private static final double PAYMENT_LIMIT = 20000;

	public CreditCard(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	private boolean isValidCard() {
		return cardNumber != null && cardNumber.matches("\\d{16}");
	}

	@Override
	public void pay(double amount) {
		if (!isValidCard()) {
			System.out.println("❌ Invalid Credit Card number. Must be 16 digits.");
			return;
		}
		if (amount <= 0 || amount > PAYMENT_LIMIT) {
			System.out.println("❌ Payment must be between ₹1 and ₹" + PAYMENT_LIMIT);
			return;
		}
		System.out.println("✅ Credit Card charged: ₹" + amount);
	}

	@Override
	public void refund(double amount) {
		System.out.println("✅ Refunded ₹" + amount + " to Credit Card.");
	}

}
