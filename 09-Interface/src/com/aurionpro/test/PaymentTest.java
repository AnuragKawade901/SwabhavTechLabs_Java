package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.IPaymentGateway;
import com.aurionpro.model.PayPal;
import com.aurionpro.model.RazorPay;
import com.aurionpro.model.Stripe;

public class PaymentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IPaymentGateway gateway = null;

		System.out.println("Select payment method");
		System.out.println("1. Paypal");
		System.out.println("2. Razor Pay");
		System.out.println("3. Stripe");
		System.out.println("Enter choice");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			gateway = new PayPal();
			break;

		case 2:
			gateway = new RazorPay();
			break;

		case 3:
			gateway = new Stripe();
			break;

		default:
			System.out.println("Wrong input");
		}
        // ✅ Null check before calling
        if (gateway != null) {
            gateway.processPayment();
		}
		scanner.close();
	}
}
