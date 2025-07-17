package com.aurionpro.array.student.test;

import java.util.Scanner;

import com.aurionpro.array.test.Student;
import com.aurionpro.array.test.StudentMarks;

public class StudentMarksTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of students: ");
		int numberOfStudent = scanner.nextInt();
		scanner.nextLine();

		StudentMarks[] students = new StudentMarks[numberOfStudent];

		for (int i = 0; i < numberOfStudent; i++) {
			System.out.println("Enter number of the student: " + (i + 1));
			System.out.println("Enter name of student: ");
			String name = scanner.nextLine();
			
			System.out.println("Enter roll number of student: ");
			int roll = scanner.nextInt();
			
			System.out.println("Enter marks of 3 subjects");
			int[] subjects = new int[3];
			for(int j = 0; j<3;j++) {
				subjects[j] = scanner.nextInt();

			}
			scanner.nextLine();
			
			students[i] = new StudentMarks(name, roll, subjects);
		}
		for(StudentMarks result: students) {
			result.display();

		}
		scanner.close();
	}
}