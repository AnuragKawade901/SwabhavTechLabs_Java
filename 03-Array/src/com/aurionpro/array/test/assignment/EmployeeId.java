package com.aurionpro.array.test.assignment;

public class EmployeeId {
	
	public int id;
	public String name;
	public String department;
	public double salary;
	
	public EmployeeId(int id, String name, String department, double salary){
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		
	}
	public void display() {
		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Department: "+department);
		System.out.println("Salary: $"+salary);
	}
}
