package com.aurionpro.oops.model;

public class BalanceChecker {
	
	private int accountNumber;
	private String accountHolder;
	private double accountBalance;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double checkBalance() {
		return accountBalance;
	}
	public void display() {
		System.out.println("Account Number: "+accountNumber+" Account Holder: "+accountHolder+" Balance: "+checkBalance());
	}
}
