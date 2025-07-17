package com.aurionpro.model.student;

public class Person {
	public String name;
	public Department department;

	public Person(String name, Department department) {
	 this.name = name;
	 this.department = department;
 }

	public String getName() {
		return name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void getDetails() {
		System.out.println("Name: "+name);
		System.out.println("Department: "+department);
	}
}
