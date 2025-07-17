package com.aurionpro.abstraction.test;

import java.util.Scanner;

import com.aurionpro.abstraction.model.CommerceStudent;
import com.aurionpro.abstraction.model.ScienceStudent;
import com.aurionpro.abstraction.model.Student;

public class ExamGradingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter student type (science/commerce): ");
            String type = scanner.nextLine().trim().toLowerCase();

            System.out.print("Roll No: ");
            int roll = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (type.equals("science")) {
                System.out.print("Physics marks: ");
                int phy = scanner.nextInt();
                System.out.print("Chemistry marks: ");
                int chem = scanner.nextInt();
                System.out.print("Maths marks: ");
                int math = scanner.nextInt();
                scanner.nextLine(); // consume newline
                students[i] = new ScienceStudent(roll, name, phy, chem, math);

            } else if (type.equals("commerce")) {
                System.out.print("Accounts marks: ");
                int acc = scanner.nextInt();
                System.out.print("Economics marks: ");
                int eco = scanner.nextInt();
                System.out.print("Business marks: ");
                int bus = scanner.nextInt();
                scanner.nextLine(); // consume newline
                students[i] = new CommerceStudent(roll, name, acc, eco, bus);

            } else {
                System.out.println("Invalid type. Skipping this student.");
                i--; // retry this index
            }
        }

        System.out.println("\n=== STUDENT RESULTS ===");
        for (Student student : students) {
            if (student != null) {
                student.displayResult();
            }
        }

        scanner.close();
    }
}
