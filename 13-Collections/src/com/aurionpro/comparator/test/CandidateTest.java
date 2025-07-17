package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.comparator.model.CandidateComparator;
import com.aurionpro.comparator.model.CandidateNameAge;

public class CandidateTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CandidateNameAge> candidates = new ArrayList<>();

        System.out.print("Enter number of candidates: ");
        int n = 0;

        // Validate number of candidates
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) throw new IllegalArgumentException("Number must be positive.");
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a valid integer: ");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Try again: ");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for candidate " + (i + 1) + ":");

            // Name input with validation
            String name;
            while (true) {
                System.out.print("Name: ");
                name = scanner.nextLine().trim();
                if (!name.isEmpty() && name.matches("^[A-Za-z ]+$")) {
                    break;
                } else {
                    System.out.println("Invalid name. Only alphabets and spaces are allowed. Please try again.");
                }
            }

            // Age input with validation
            int age;
            while (true) {
                System.out.print("Age: ");
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    if (age < 0) throw new IllegalArgumentException("Age must be non-negative.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a valid integer.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            candidates.add(new CandidateNameAge(name, age));
        }

        // Sorting
        candidates.sort(new CandidateComparator());

        System.out.println("\n--- Sorted Candidate List ---");
        for (CandidateNameAge c : candidates) {
            System.out.println(c);
        }

        scanner.close();
    }
}

