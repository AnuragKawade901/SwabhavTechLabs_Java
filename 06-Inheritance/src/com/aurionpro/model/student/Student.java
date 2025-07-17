package com.aurionpro.model.student;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	public static int totalStudents = 0;
	public static int totalCourses = 0;

	private int rollNumber;
	private List<String> enrolledCourses;
	private double feePaid;
	private double totalFee;

	public Student(String name, Department department, int rollNumber, double totalFee) {
		super(name, department);
		this.rollNumber = rollNumber;
		this.enrolledCourses = new ArrayList<>();
		this.totalFee = totalFee;
		this.feePaid = 0;
		totalStudents++;
	}

	public void enrollCourses(String courseName, CourseType type) {
		enrolledCourses.add(courseName + " (" + type + ") ");
		totalCourses++;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public List<String> getEnrolledCourses() {
		return enrolledCourses;
	}

	public double getFeePaid() {
		return feePaid;
	}

	public void payFee(double amount) {
		this.feePaid += amount;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setEnrolledCourses(List<String> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	@Override
	public void getDetails() {
		super.getDetails();
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Enrolled courses: " + enrolledCourses);
	}

}
