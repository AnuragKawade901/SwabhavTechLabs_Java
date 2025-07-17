package com.aurionpro.model;

public abstract class Student {
	protected String name;
	protected int rollNumber;
	protected Stream stream;
	
	public Student(String name, int rollNumber, Stream stream) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.stream = stream;
	}
	
	public abstract double calculatePerformance();
	
	public abstract String getGrade();
	
	public void displayInfo() {
		System.out.println("Name "+name+" | Stream: "+stream+" | Roll Number: "+rollNumber);
	}
	  public void displayPerformance() {
	        System.out.println("Performance: " + calculatePerformance() + "% | Grade: " + getGrade());
	    }
	public void displayPerformance(boolean detailed) {
		if(detailed) {
			displaySubjects();
		}
		displayPerformance();
	}
	
	public void displayPerformance(String format) {
		if(format.equalsIgnoreCase("percentage")) {
			System.out.println("Performance: "+calculatePerformance()+"%");
			
		}else if(format.equalsIgnoreCase("grade")) {
			System.out.println("Grade: "+getGrade());
		}else {
			displayPerformance();
		}
	}
	protected abstract void displaySubjects();
}


