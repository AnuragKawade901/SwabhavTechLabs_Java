package com.aurionpro.BankMP.model;

public class Account {
    private long accountNumber;
    private String customerId;
    private double balance;
    private String upi;
    private String status;

    public Account(long accountNumber, String customerId, double balance, String upi, String status) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.upi = upi;
        this.status = status;
    }
    // Getters & Setters

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public double getBalance() {
		return balance;
	}

	public String getUpi() {
		return upi;
	}

	public String getStatus() {
		return status;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}