package com.aurionpro.student.test;

import java.util.Scanner;

import com.aurionpro.student.model.StudentManager;

public class StudentTest {
		public static void main(String[] args) {
			StudentManager manager = new StudentManager();
			Scanner sc = new Scanner(System.in);
			int choice = 0;

			do {
				System.out.println("\n--- Student Record System ---");
				System.out.println("1. Add Student");
				System.out.println("2. View All Students");
				System.out.println("3. Search Student by Roll");
				System.out.println("4. Delete Student by Roll");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");
				try {
					choice = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number.");
					continue;
				}

				switch (choice) {
				case 1:
					manager.addStudent();
					break;
				case 2:
					manager.viewAllStudents();
					break;
				case 3:
					manager.searchStudentByRoll();
					break;
				case 4:
					manager.deleteStudentByRoll();
					break;
				case 5:
					System.out.println("Exiting system...");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 1–5.");
				}

			} while (choice != 5);

			sc.close();
		}
	}
