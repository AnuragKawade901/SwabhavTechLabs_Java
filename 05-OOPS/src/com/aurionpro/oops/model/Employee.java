package com.aurionpro.oops.model;

public class Employee {
	private String name;
	private int id;
	private double salary;
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public double salary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double hra() {
		return 0.20*salary;
	}
	public double da() {
		return 0.10*salary;
	}
	public void display() {
		System.out.println("Employee name: "+name+" ID: "+id+" Total salary: "+(salary+hra()+da()));
	}
}
