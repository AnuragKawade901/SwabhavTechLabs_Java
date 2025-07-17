package com.aurionpro.ecommerce.model;

public class UPI implements IPaymentGateway{
	private String upiId;
	private static final double PAYMENT_LIMIT = 20000;

	public UPI(String upiId) {
		this.upiId = upiId;
	}

	private boolean isValidUPI() {
		return upiId != null && upiId.matches("^[\\w.]+@[\\w]+$");
	}

	@Override
	public void pay(double amount) {
		if (!isValidUPI()) {
			System.out.println("❌ Invalid UPI ID format. Example: user@bank");
			return;
		}
		if (amount <= 0 || amount > PAYMENT_LIMIT) {
			System.out.println("❌ Payment must be between ₹1 and ₹" + PAYMENT_LIMIT);
			return;
		}
		System.out.println("✅ UPI payment successful: ₹" + amount);
	}

	@Override
	public void refund(double amount) {
		System.out.println("✅ Refunded ₹" + amount + " to UPI ID: " + upiId);
	}
}
