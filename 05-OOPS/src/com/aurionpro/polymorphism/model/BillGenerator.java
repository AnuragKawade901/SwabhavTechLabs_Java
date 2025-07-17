package com.aurionpro.polymorphism.model;

public class BillGenerator {
	String item;
	int quantity;
	double discount;
	double tax;

	public void generateBill(String item, int quantity) {
		System.out.println("---Iteam name---");
		System.out.println(item + "------------" + quantity);
	}

	public void generateBill(String item, int quantity, double discount) {
		System.out.println("Discount on " + item + " with " + quantity + " of quanity");
		System.out.println(discount);
	}

	public void generateBill(String item, int quantity, double discount, double tax) {
		System.out.println("Paid tax" + tax);
	}

}
