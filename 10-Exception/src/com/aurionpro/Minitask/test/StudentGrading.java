package com.aurionpro.Minitask.test;

import java.util.Scanner;

import com.aurionpro.Minitask.model.InvalidMarksException;

public class StudentGrading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input student name
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();

            if (studentName == null || studentName.trim().isEmpty()) {
                throw new NullPointerException("Student name cannot be empty.");
            }

            // Input marks
            System.out.print("Enter marks (0 to 100): ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                throw new InvalidMarksException("Marks must be between 0 and 100.");
            }

            // Display valid result
            System.out.println("Student: " + studentName);
            System.out.println("Marks: " + marks);

        } catch (InvalidMarksException e) {
            System.out.println("Invalid Marks: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Invalid Name: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());

        } finally {
            System.out.println("Grading process completed.");
            scanner.close();
        }
    }
}