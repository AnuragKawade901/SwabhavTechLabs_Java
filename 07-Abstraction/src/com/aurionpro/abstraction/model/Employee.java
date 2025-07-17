package com.aurionpro.abstraction.model;

public abstract class Employee {

	public String name;
	public int id;
	public Employee(String name, int id) {
		this.id = id;
		this.name = name;
	}

	public abstract double calculateSalary();

	public void display() {
		System.out.println("Name"+name);
		System.out.println("Id"+id);
	}

}
