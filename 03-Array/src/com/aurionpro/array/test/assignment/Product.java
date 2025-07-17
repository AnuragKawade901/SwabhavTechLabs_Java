package com.aurionpro.array.test.assignment;

public class Product {
	
	public String name;
	public double price;
	
	Product(String name, double price){
		this.name = name;
		this.price = price;
	}
	public void display() {
		System.out.println("Name: "+name+" Price"+price);
	}
}
