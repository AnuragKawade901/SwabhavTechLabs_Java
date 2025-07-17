package com.aurionpro.enumeration.model;

import java.util.Scanner;

public class GradeTest {

    public static void grade(Grade marks) {
        switch (marks) {
            case A:
                System.out.println("Excellent");
                break;
            case B:
                System.out.println("Good");
                break;
            case C:
                System.out.println("Average");
                break;
            case D:
                System.out.println("Below Average");
                break;
            case F:
                System.out.println("Fail");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grade (A, B, C, D, F):");
        String input = scanner.nextLine().toUpperCase();

        // Manual validation without try-catch
        if (input.equals("A") || input.equals("B") || input.equals("C") || input.equals("D") || input.equals("F")) {
            Grade grade = Grade.valueOf(input);
            grade(grade);
        } else {
            System.out.println("Invalid grade entered.");
        }

        scanner.close();
    }
}
