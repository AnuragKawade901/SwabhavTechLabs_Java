package com.aurionpro.enumeration.model;

public class PaymentProcessor {
	public void printMessage(PaymentStatus status) {
        switch (status) {
            case SUCCESS:
                System.out.println("Payment received");
                break;
            case PENDING:
                System.out.println("Payment is pending");
                break;
            case FAILED:
                System.out.println("Payment failed");
                break;
            case CANCELLED:
                System.out.println("Payment was cancelled");
                break;
            default:
                System.out.println("Unknown payment status");
        }
    }
}
