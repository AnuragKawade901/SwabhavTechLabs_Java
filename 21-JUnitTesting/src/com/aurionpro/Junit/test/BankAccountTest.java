package com.aurionpro.Junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aurionpro.Junit.model.BankAccount;

public class BankAccountTest {
	private BankAccount account;
	
	@BeforeEach
	void setUp() {
		account = new BankAccount(100.0);
	}
	 @Nested
	    @DisplayName("Deposit Tests")
	    class DepositTests {

	        @Test
	        @DisplayName("Valid Deposit")
	        void testValidDeposit() {
	            account.deposit(50.0);
	            assertEquals(150.0, account.getBalance(), 0.001);
	        }

	        @Test
	        @DisplayName("Invalid Deposit (Amount <= 0)")
	        void testInvalidDeposit() {
	            assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
	        }
	    }
	 @Nested
	    @DisplayName("Withdraw Tests")
	    class WithdrawTests {

	        @Test
	        @DisplayName("Valid Withdrawal")
	        void testValidWithdrawal() {
	            account.withdraw(40.0);
	            assertEquals(60.0, account.getBalance(), 0.001);
	        }

	        @Test
	        @DisplayName("Overdraft Attempt")
	        void testOverdraft() {
	            assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
	        }
	    }
	}

