package com.aurionpro.oops.test;

import java.util.Scanner;

import com.aurionpro.oops.model.Student;

public class StudentClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number students: ");
		int number = scanner.nextInt();
		scanner.nextLine();
		Student[] students = new Student[number];
		for (int i = 0; i < number; i++) {
			System.out.println("Enter details about the students");
			System.out.println("Name of Student");
			String studentName = scanner.nextLine();
			
			System.out.println("Enter roll number: ");
			int studentRollNo = scanner.nextInt();
			
			System.err.println("Enter course: ");
			String studentCourse = scanner.nextLine();
			scanner.nextLine();
			students[i] = new Student();
			students[i].setName(studentName);
			students[i].setRoll(studentRollNo);
			students[i].setCourse(studentCourse);
		}
		for(Student result: students) {
			result.display();
		}
		scanner.close();

	}
}
