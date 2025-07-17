package com.aurionpro.banking.model;

public interface IAccountOperation{
	void deposit(double amount);
	void withdraw(double amount);
	void checkBalance();
}
