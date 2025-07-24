package com.aurionpro.Calculator.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Demo {
@Nested
class Group1{
	@Test
	public void method() {
		System.out.println("Testing method 1");
	}
}
@Nested
class Group2{
	@Test
	public void method() {
		System.out.println("Testing method 2");
	}
}
}

//1. Setup:
//Use @BeforeEach to create a new BankAccount object with an initial balance of 100.0 before each test.
//2. Deposit Tests (@Nested)
//testValidDeposit()
//
//→ Deposit 50.0, verify the balance becomes 150.0.
//testInvalidDeposit()
//
//→ Try depositing 0, expect IllegalArgumentException.
//3. Withdraw Tests (@Nested)
//testValidWithdrawal()
//
//→ Withdraw 40.0, verify the balance becomes 60.0.
//testOverdraft()
//
//→ Try withdrawing 200.0, expect IllegalArgumentException.
//4. Use of Annotations:
//@DisplayName to label test groups for better readability in test reports.
//@Nested to logically group related tests (Deposit and Withdraw).
// 
//Functional Requirements:
//1. Class Design – BankAccount
//Implement a class named BankAccount with the following features:
//Attributes:
//balance (private double) – maintains the current account balance.
//Constructor:
//Accepts an initialBalance and initializes the balance.
//Methods:
//void deposit(double amount)
//Adds the amount to the account balance.
//Throws IllegalArgumentException if amount <= 0.
//void withdraw(double amount)
//Subtracts the amount from the account balance.
//Throws IllegalArgumentException if amount > balance (i.e., insufficient funds).
//double getBalance()
//Returns the current balance.
