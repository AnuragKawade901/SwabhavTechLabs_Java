package com.aurionpro.Junit.model;

public class BankAccount {
private double balance;

public BankAccount(double balance) {
	this.balance = balance;
}
	public void deposit(double amount) {
		if(amount <=0) {
			throw new IllegalArgumentException("Deposit amount must be greater than zero");
		}
		balance += amount;
}
	public void withdraw(double amount) {
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient funds: Cannot withdraw more than the balance.");
			
		}
		balance -= amount;
	}
	public double getBalance() {
		return balance;
	}
}
