package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.StudentEvaluator;

public class StudentEvaluatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentEvaluator evaluator = new StudentEvaluator();
		
		System.out.println("Enter marks(int): ");
		int marks = scanner.nextInt();
		evaluator.evaluate(marks);
		
		System.out.println("Enter total marks (int): ");
		int total = scanner.nextInt();
		
		String grade = evaluator.evaluate(marks, total);
		System.out.println("Grade: "+grade);
		
		String remark = evaluator.evaluate(grade);
		System.out.println("Performance Remark: "+remark);
		
		scanner.close();
	
	
	
	
	}
}
