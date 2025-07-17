package com.aurionpro.enumeration.model;

public class PaymentTest {
	public static void main(String[] args) {
		PaymentProcessor processor = new PaymentProcessor();

		processor.printMessage(PaymentStatus.SUCCESS);
		processor.printMessage(PaymentStatus.PENDING);
		processor.printMessage(PaymentStatus.FAILED);
		processor.printMessage(PaymentStatus.CANCELLED);
	}
}
