package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.Attendance;

public class AttendanceTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Attendance attend = new Attendance();
		System.out.println("Choose option: \n1. General Attendance\n2.One student\n3.Multiple students");
		int choice = scanner.nextInt();
		scanner.hasNextLine();

		switch (choice) {
		case 1:
			attend.markAttendance();
			break;

		case 2:
			System.out.println("Enter student name: ");
			String name = scanner.nextLine();
			attend.markAttendance(name);
			break;
			
		case 3:
			System.out.println("Enter number of students: ");
			int number = scanner.nextInt();
			String[] names = new String[number];
			for(int i = 0; i<number;i++) {
				System.out.println("Enter name "+(i+1)+": ");
				names[i] = scanner.nextLine();
			}
			attend.markAttendance(names);
			break;
			
		default:
			System.out.println("Invalid choice.");
		}
		attend.showAttendance();
		scanner.close();
	}

}
