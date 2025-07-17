package com.aurionpro.abstraction.model;

public  class Developer extends Employee {
	public double basicSalary;
	public double bonus;

	public Developer(String name, int id, double basicSalary, double bonus) {
		super(name,id);
		this.basicSalary = basicSalary;
		this.bonus = bonus;
	}

	@Override
	public double calculateSalary() {
		return basicSalary + bonus;
	
	}
	@Override
	public void display() {
		System.out.println("Salary: "+basicSalary);
		System.out.println("Bonus: "+bonus);
		System.out.println("Total Salary: "+(basicSalary+bonus));
	}
}
