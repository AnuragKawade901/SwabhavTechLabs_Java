package com.aurionpro.ecommerce.model;

public class NetBanking implements IPaymentGateway {
	private String username;
	private static final double PAYMENT_LIMIT = 20000;

	public NetBanking(String username) {
		this.username = username;
	}

	private boolean isValidUser() {
		return username != null && username.length() >= 4;
	}

	@Override
	public void pay(double amount) {
		if (!isValidUser()) {
			System.out.println("❌ Invalid username. Must be at least 4 characters.");
			return;
		}
		if (amount <= 0 || amount > PAYMENT_LIMIT) {
			System.out.println("❌ Payment must be between ₹1 and ₹" + PAYMENT_LIMIT);
			return;
		}
		System.out.println("✅ NetBanking transaction complete: ₹" + amount);
	}

	@Override
	public void refund(double amount) {
		System.out.println("✅ Refunded ₹" + amount + " via NetBanking to " + username);
	}
}
