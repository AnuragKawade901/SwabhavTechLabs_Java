package com.aurionpro.exam.model;

public class PracticalExam implements IExamEvaluator{
	private double marks;

	@Override
	public void evaluateMarks(double marks) {
		if (marks < 0 || marks > 50) {
			System.out.println("❌ Invalid marks. Must be between 0 and 50.");
			return;
		}
		this.marks = marks;
		System.out.println("🔬 Practical Exam Marks Recorded: " + marks);
	}

	@Override
	public void calculateGrade() {
		if (marks >= 45) System.out.println("🎓 Grade: A+");
		else if (marks >= 35) System.out.println("🎓 Grade: A");
		else if (marks >= 25) System.out.println("🎓 Grade: B");
		else if (marks >= 15) System.out.println("🎓 Grade: C");
		else System.out.println("❌ Grade: F (Fail)");
	}
}
