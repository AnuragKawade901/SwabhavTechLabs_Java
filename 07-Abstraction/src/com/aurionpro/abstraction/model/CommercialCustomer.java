package com.aurionpro.abstraction.model;

public class CommercialCustomer extends Customer {
	private static final double RATE_PER_UNIT = 8.0;

	public CommercialCustomer(String name, int unitsConsumed) {
		super(name, unitsConsumed);
	}

	@Override
	public double calculateBill() {
		return unitsConsumed * RATE_PER_UNIT;
	}
}
