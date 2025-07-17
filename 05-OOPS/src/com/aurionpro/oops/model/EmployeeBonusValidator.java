package com.aurionpro.oops.model;

public class EmployeeBonusValidator {
	private String name;
	private double salary;
	private double bonus;

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBonus(double bonus) {
		if (bonus <= (salary * 0.20)) {
			this.bonus = bonus;
		}else {
			this.bonus = (0);
		}
	}

	public void display() {
		System.out.println("Name: " + name + " Salary: " + salary + " Final Salary: " + (bonus + salary));
	}
}
