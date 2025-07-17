package com.aurionpro.array.student.test;

import java.util.Scanner;

import com.aurionpro.array.test.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of studnts: ");
		int numberOfStudent = scanner.nextInt();
		scanner.nextLine();

		Student[] students = new Student[numberOfStudent];

		for (int i = 0; i < numberOfStudent; i++) {
			System.out.println("Enter details of the student: " + (i + 1));
			System.out.println("Enter name of student: ");
			String name = scanner.nextLine();

			System.out.println("Enter roll number of student: ");
			int roll = scanner.nextInt();

			System.out.println("Enter CGPA of the student: ");
			double cgpa = scanner.nextDouble();
			scanner.nextLine();

			students[i] = new Student(name, roll, cgpa);
		}
		
		for (Student result : students) {
			result.display();
		}
		scanner.close();
	}
}
