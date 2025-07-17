package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.ArtsStudent;
import com.aurionpro.model.CommerceStudent;
import com.aurionpro.model.ScienceStudent;
import com.aurionpro.model.Stream;
import com.aurionpro.model.Student;

public class StudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student[] students = new Student[number];
        System.out.println("=== Student Performance System ===");

        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for student #" + (i + 1));

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Roll Number: ");
            int roll = Integer.parseInt(scanner.nextLine());

            System.out.print("Stream (SCIENCE / COMMERCE / ARTS): ");
            Stream stream = Stream.valueOf(scanner.nextLine().trim().toUpperCase());

            switch (stream) {
                case SCIENCE:
                    System.out.print("Enter marks for Physics, Chemistry, Math: ");
                    int phy = scanner.nextInt();
                    int chem = scanner.nextInt();
                    int math = scanner.nextInt();
                    students[i] = new ScienceStudent(name, roll, phy, chem, math);
                    break;

                case COMMERCE:
                    System.out.print("Enter marks for Accounts, Business Studies, Economics: ");
                    int acc = scanner.nextInt();
                    int bus = scanner.nextInt();
                    int eco = scanner.nextInt();
                    students[i] = new CommerceStudent(name, roll, acc, bus, eco);
                    break;

                case ARTS:
                    System.out.print("Enter marks for History, Political Science, Sociology: ");
                    int hist = scanner.nextInt();
                    int pol = scanner.nextInt();
                    int soc = scanner.nextInt();
                    students[i] = new ArtsStudent(name, roll, hist, pol, soc);
                    break;
                    
                default:
                	System.out.println("Invalid input");
            }
            scanner.nextLine(); // consume newline
        }

        System.out.print("\nDo you want to display full details? (yes/no): ");
        String userChoice = scanner.nextLine().trim().toLowerCase();
        boolean showDetailed = userChoice.equals("yes");

        System.out.println("\n=== STUDENT PERFORMANCE REPORT ===");
        for (Student student : students) {
            student.displayInfo();
            if (showDetailed) {
                student.displayPerformance(true); // show subject-wise + performance
            } else {
                student.displayPerformance(); // summary only
            }
            System.out.println("-------------------------------");
        }

        scanner.close();
    }
}

