package com.aurionpro.model.student;

import java.util.ArrayList;
import java.util.List;

public class Proffesor extends Person {
	private int id;
	private List<String> assignedSubjects;
	private double salary;

	public Proffesor(String name, Department department, int id) {
		super(name, department);
		this.id = id;
		this.assignedSubjects = new ArrayList<>();
	}

	public void assignSubjects(String subjectName, CourseType type) {
		assignedSubjects.add(subjectName + " (" + type + ") ");
	}

	public int getId() {
		return id;
	}

	public List<String> getAssignedSubjects() {
		return assignedSubjects;
	}

	public double getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAssignedSubjects(List<String> assignedSubjects) {
		this.assignedSubjects = assignedSubjects;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public void getDetails() {
		super.getDetails();
		System.out.println("Proffessor ID: " + id);
		System.out.println("Assigned Subjects: " + assignedSubjects);

	}

}
