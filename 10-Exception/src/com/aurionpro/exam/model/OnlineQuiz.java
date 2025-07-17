package com.aurionpro.exam.model;

public class OnlineQuiz implements IExamEvaluator{
	private double marks;

	@Override
	public void evaluateMarks(double marks) {
		if (marks < 0 || marks > 25) {
			System.out.println("❌ Invalid marks. Must be between 0 and 25.");
			return;
		}
		this.marks = marks;
		System.out.println("💻 Online Quiz Marks Recorded: " + marks);
	}

	@Override
	public void calculateGrade() {
		if (marks >= 23) System.out.println("🎓 Grade: A+");
		else if (marks >= 20) System.out.println("🎓 Grade: A");
		else if (marks >= 15) System.out.println("🎓 Grade: B");
		else if (marks >= 10) System.out.println("🎓 Grade: C");
		else System.out.println("❌ Grade: F (Fail)");
	}
}
