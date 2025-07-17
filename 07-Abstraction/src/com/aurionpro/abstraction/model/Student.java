package com.aurionpro.abstraction.model;

public abstract class Student {
	protected int rollNumber;
	protected String name;

	public Student(int rollNumber, String name) {
		this.rollNumber = rollNumber;
		this.name = name;
	}

	public abstract double calculateAverage();

	public abstract String calculateGrade();

	public void displayResult() {
		System.out.println("Roll No: " + rollNumber);
		System.out.println("Name   : " + name);
		System.out.println("Average: " + calculateAverage());
		System.out.println("Grade  : " + calculateGrade());
		System.out.println("-----------------------------");
	}
}
