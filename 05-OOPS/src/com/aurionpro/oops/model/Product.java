package com.aurionpro.oops.model;

public class Product {

	private String productName;
	private double price;
	private int quantity;
	
	public String getProductName(){
		return productName;
	}
	public double getPrice(){
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double calculateTotal() {
		return price*quantity;
	}
	
	public void display() {
		System.out.println("Prodcut Name: "+productName+" Total Cost: "+calculateTotal());
	}
}
 