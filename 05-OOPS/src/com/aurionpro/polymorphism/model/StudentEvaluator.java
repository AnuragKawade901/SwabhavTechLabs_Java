package com.aurionpro.polymorphism.model;

public class StudentEvaluator {
	int marks;

	public void evaluate(int marks) {
		if (marks >= 90) {
			System.out.println("Excellent");
		} else {
			System.out.println("Keep Improving");
		}
	}

	public String evaluate(int marks, int totalMarks) {
		double percentage = (marks * 100.0) / totalMarks;
		String grade;
		if (percentage >= 90)
			return "A";
		else if (percentage >= 75)
			return "B";
		else return "C";
	}
	public String evaluate(String grade) {
		switch(grade.toUpperCase()) {
		case "A":
			return "Very Good";
		case "B":
			return "Good";
		case "C":
			return "Need to improve";
		}
		return grade;
	}
}
