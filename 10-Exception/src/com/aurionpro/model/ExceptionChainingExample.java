package com.aurionpro.model;

public class ExceptionChainingExample {
	public static void processPayment() {
        try {
            String paymentMethod = null;
            // This line throws NullPointerException
            System.out.println("Processing with: " + paymentMethod.toUpperCase());

        } catch (NullPointerException e) {
            // Chaining the original cause
            throw new RuntimeException("Payment method was not provided", e);
        }
    }

    public static void main(String[] args) {
        try {
            processPayment();
        } catch (RuntimeException e) {
            System.out.println("Exception caught in main: " + e.getMessage());

            // Print the full cause chain
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println("Caused by: " + cause);
            }
        }
    }
}
