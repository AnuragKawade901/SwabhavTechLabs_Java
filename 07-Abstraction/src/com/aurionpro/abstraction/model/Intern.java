package com.aurionpro.abstraction.model;

public  class Intern extends Employee {
	public double stripend;
	
	public Intern(String name, int id, double stripend) {
		super(name,id);
		this.stripend = stripend;
	}
	@Override
	public double calculateSalary() {
		return stripend;
	}
	@Override
	public void display() {
		System.out.println("Stripend"+stripend);
		
	}
}
