package com.aurionpro.banking.model;

public class LoanAccount implements IAccountOperation{
	private double loanAmount;

	public LoanAccount(double initialLoan) {
		this.loanAmount = initialLoan;
	}

	@Override
	public void deposit(double amount) {
		System.out.println("❌ Cannot deposit into a loan account directly. Use repayment.");
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("❌ Invalid repayment amount.");
			return;
		}
		if (amount > loanAmount) {
			System.out.println("❌ You are trying to repay more than loan amount.");
			return;
		}
		loanAmount -= amount;
		System.out.println("✅ Loan repaid: ₹" + amount);
	}

	@Override
	public void checkBalance() {
		System.out.println(" Outstanding Loan Amount: ₹" + loanAmount);
	}
}
