package com.aurionpro.test.student;

import java.util.Scanner;

import com.aurionpro.model.student.CourseType;
import com.aurionpro.model.student.Department;
import com.aurionpro.model.student.Proffesor;
import com.aurionpro.model.student.Student;

public class CourseManagementSystem {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter student name: ");
		String studentName = scanner.nextLine();
		
		System.out.println("Enter Roll Number: ");
		int roll = scanner.nextInt();
		
        System.out.println("Enter Department (COMPUTER_SCIENCE, MECHANICAL, INFORMATION_TECHNOLOGY, CIVIL, ELECTRICAL):");
        Department studentDept = Department.valueOf(scanner.nextLine().toUpperCase());
		
		System.out.println("Enter Total Fee:");
		double totalFee = scanner.nextDouble();
		scanner.nextLine();
		
		Student student = new Student(studentName, studentDept, roll, totalFee);
		
		System.out.println("Enter course to enroll: ");
		String courseName = scanner.nextLine();
		
		System.out.println("Enter course type (CORE/ELECTIVE): ");
		CourseType course = CourseType.valueOf(scanner.nextLine().toUpperCase());
		
		student.enrollCourses(courseName, course);
		
		System.out.println("\n---------------Student Details---------------------");
		student.getDetails();
		
		//professor name
		System.out.println("\nEnter Proffesor Name");
		String professorName = scanner.nextLine();
		
		System.out.println("\n Enter Professor ID: ");
		int professorId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter Department (Options: COMPUTER_SCIENCE, MECHANICAL, INFORMATION_TECHNOLOGY, CIVIL, ELECTRICAL): ");
		Department professorDepartment = Department.valueOf(scanner.nextLine().toUpperCase());
		
		Proffesor professor = new Proffesor(professorName, professorDepartment, professorId );
		
		System.out.println("Enter subject to assign: ");
		String subject = scanner.nextLine();
		
		System.out.println("Enter subject type (CORE/ELECTIVE): ");
		CourseType subjectType = CourseType.valueOf(scanner.nextLine().toUpperCase());
		
		professor.assignSubjects(subject, subjectType);
		
		System.out.println("\n----Professor Details-----------");
		professor.getDetails();
		
		System.out.println("\nTotal Students: "+Student.totalStudents);
		System.out.println("Total Courses Enrolled: "+Student.totalCourses);

		scanner.close();
		
	}
	
}
