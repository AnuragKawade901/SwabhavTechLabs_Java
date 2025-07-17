package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Student> students = new ArrayList<>();
	System.out.println("Enter 5 students name, roll no, cgpa");

	for(int i = 1; i<=2;i++) {
		//Input of 5 students
		System.out.println("Student "+(i));
		System.out.println("Enter name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter roll no.: ");
		int roll = scanner.nextInt();
		System.out.println("Enter CGPA: ");
		double cgpa = scanner.nextDouble();
		scanner.nextLine();

		students.add(new Student(name, roll, cgpa));
	}
//	System.out.println("Ascending via Name");
//	students.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
//	System.out.println("Ascending via Roll number");
//	students.stream().sorted(Comparator.comparing(Student::getRollNo)).forEach(System.out::println);
//	System.out.println("Ascending via CGPA");
//	students.stream().sorted(Comparator.comparing(Student::getCgpa)).forEach(System.out::println);
//	
//	System.out.println("Descending via Name");
//	students.stream().sorted(Comparator.comparing(Student::getName).reversed()).forEach(System.out::println);
//	System.out.println("Descending via Roll Number");
//	students.stream().sorted(Comparator.comparing(Student::getRollNo).reversed()).forEach(System.out::println);
//	System.out.println("Descending via CGPA");
//	students.stream().sorted(Comparator.comparing(Student::getName).reversed()).forEach(System.out::println);


	students.stream().sorted((Comparator.comparingDouble(s -> s.cgpa))).forEach(System.out::println);
	students.stream().sorted((Comparator.comparing(s -> s.name))).forEach(System.out::println);
	//descending
	students.stream().sorted((Comparator.comparing((Student s) -> s.name).reversed())).forEach(System.out::println);


	
	
	
	scanner.close();
}
}
