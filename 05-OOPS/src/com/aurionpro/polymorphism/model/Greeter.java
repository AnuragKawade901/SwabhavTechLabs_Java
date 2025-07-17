package com.aurionpro.polymorphism.model;

public class Greeter {
	String name;
	
	public void greet() {
		System.out.println("Hello!");
	}
	public void greet(String name) {
		System.err.println("Hello, "+name+" !");
	}
}
