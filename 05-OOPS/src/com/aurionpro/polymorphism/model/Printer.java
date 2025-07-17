package com.aurionpro.polymorphism.model;

public class Printer {
	private String message;
	private int number;
	
	public void print() {
		System.out.println("Default message");
	}
	public void print(String message) {
		System.out.println("Message: "+message);
	}
	public void print(int number) {
		System.out.println("Number: "+number);
	}
}
