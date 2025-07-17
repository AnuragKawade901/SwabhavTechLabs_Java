package com.aurionpro.array.test;

public class Student {

	String name;
	int rollNumber;
	double cgpa;

	public Student(String name, int rollNumber, double cgpa)  // public is done so that it can be used in other classes
	{ 
		this.name = name;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
	}
	public void display() {
		System.out.println("Name: "+name+" Roll Number: "+rollNumber+" CGPA: "+cgpa);
		System.out.println("--------------------------------------------------------");
	}

}
