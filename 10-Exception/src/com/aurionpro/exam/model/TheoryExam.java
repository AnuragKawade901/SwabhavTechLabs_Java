package com.aurionpro.exam.model;

public class TheoryExam implements IExamEvaluator{
	private double marks;

	@Override
	public void evaluateMarks(double marks) {
		if (marks < 0 || marks > 100) {
			System.out.println("❌ Invalid marks. Must be between 0 and 100.");
			return;
		}
		this.marks = marks;
		System.out.println("📘 Theory Exam Marks Recorded: " + marks);
	}

	@Override
	public void calculateGrade() {
		if (marks >= 90) System.out.println("🎓 Grade: A+");
		else if (marks >= 75) System.out.println("🎓 Grade: A");
		else if (marks >= 60) System.out.println("🎓 Grade: B");
		else if (marks >= 40) System.out.println("🎓 Grade: C");
		else System.out.println("❌ Grade: F (Fail)");
	}
}
