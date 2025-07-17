package com.aurionpro.exam.test;

import java.util.Scanner;

import com.aurionpro.exam.model.IExamEvaluator;
import com.aurionpro.exam.model.OnlineQuiz;
import com.aurionpro.exam.model.PracticalExam;
import com.aurionpro.exam.model.TheoryExam;

public class ExamTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IExamEvaluator[] exams = {
			new TheoryExam(), new PracticalExam(), new OnlineQuiz()
		};
		String[] names = { "Theory Exam", "Practical Exam", "Online Quiz" };

		while (true) {
			System.out.println("\n===== Exam Evaluation System =====");
			for (int i = 0; i < names.length; i++) {
				System.out.println((i + 1) + ". " + names[i]);
			}
			System.out.println("4. Exit");
			System.out.print("Select Exam Type (1-4): ");

			try {
				int choice = Integer.parseInt(scanner.nextLine());

				if (choice == 4) {
					System.out.println("📘 Exiting Exam System.");
					break;
				}

				if (choice < 1 || choice > 4) {
					System.out.println("❌ Invalid option. Try again.");
					continue;
				}

				IExamEvaluator evaluator = exams[choice - 1];
				String examName = names[choice - 1];

				System.out.print("Enter marks for " + examName + ": ");
				double marks = Double.parseDouble(scanner.nextLine());

				evaluator.evaluateMarks(marks);
				evaluator.calculateGrade();

			} catch (NumberFormatException e) {
				System.out.println("❌ Please enter numeric input only.");
			} catch (Exception e) {
				System.out.println("❌ Unexpected error: " + e.getMessage());
			}
		}
		scanner.close();
	}
}
