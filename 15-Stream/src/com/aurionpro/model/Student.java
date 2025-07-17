package com.aurionpro.model;

public class Student {
	public String name;
	public int rollNo;
	public double cgpa;
	
	public Student(String name, int rollNo, double cgpa) {
		this.name = name;
		this.rollNo = rollNo;
		this.cgpa = cgpa;
	}
	public String getName() {
		return name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public double getCgpa() {
		return cgpa;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", cgpa=" + cgpa + "]";
	}
	
}
