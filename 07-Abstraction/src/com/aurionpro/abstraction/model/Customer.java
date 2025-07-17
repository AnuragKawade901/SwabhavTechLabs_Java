package com.aurionpro.abstraction.model;

public abstract class Customer {
	public String name;
	public int unitsConsumed;
	
	public Customer(String name, int unitsConsumed) {
		this.name = name;
		this.unitsConsumed = unitsConsumed;
	}
	public abstract double calculateBill();
	
	public void displayBill() {
        System.out.println("Customer Name: " + name);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill: ₹" + calculateBill());
        System.out.println("----------------------------");
    }
	
}
