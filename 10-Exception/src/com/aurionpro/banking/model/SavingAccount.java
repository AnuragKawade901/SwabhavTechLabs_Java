package com.aurionpro.banking.model;

public class SavingAccount implements IAccountOperation {
	private double balance;
	private static final double WITHDRAW_LIMIT = 20000;
	private static final double DEPOSIT_LIMIT = 20000;

	public SavingAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	@Override
	public void deposit(double amount) {
		if (amount <= 0 || amount > DEPOSIT_LIMIT) {
			System.out.println("❌ Deposit must be between ₹1 and ₹" + DEPOSIT_LIMIT);
			return;
		}
		balance += amount;
		System.out.println("✅ Deposited ₹" + amount);
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= 0 || amount > WITHDRAW_LIMIT) {
			System.out.println("❌ Withdrawal must be between ₹1 and ₹" + WITHDRAW_LIMIT);
			return;
		}
		if (amount > balance) {
			System.out.println("❌ Insufficient balance.");
			return;
		}
		balance -= amount;
		System.out.println("✅ Withdrawn ₹" + amount);
	}

	@Override
	public void checkBalance() {
		System.out.println(" Savings Account Balance: ₹" + balance);
	}
}
