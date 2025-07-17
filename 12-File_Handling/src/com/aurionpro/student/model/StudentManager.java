package com.aurionpro.student.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentManager {
	private static final String FILE_NAME = "students.txt";

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Roll Number: ");
            int roll = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = Integer.parseInt(sc.nextLine());

            Student student = new Student(roll, name, marks);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(student.toString());
                writer.newLine();
                System.out.println("Student added successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input. Please try again.");
        }
    }

    public void viewAllStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Student Records ---");
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int roll = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int marks = Integer.parseInt(parts[2]);
                    Student student = new Student(roll, name, marks);
                    System.out.println(student.display());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No student records found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. No students added yet.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void searchStudentByRoll() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter roll number to search: ");
        int searchRoll = Integer.parseInt(sc.nextLine());
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int roll = Integer.parseInt(parts[0]);
                    if (roll == searchRoll) {
                        String name = parts[1];
                        int marks = Integer.parseInt(parts[2]);
                        Student student = new Student(roll, name, marks);
                        System.out.println("Student found: " + student.display());
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("Student not found with roll number: " + searchRoll);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. No students added yet.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void deleteStudentByRoll() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter roll number to delete: ");
        int deleteRoll = Integer.parseInt(sc.nextLine());
        boolean deleted = false;

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int roll = Integer.parseInt(parts[0]);
                    if (roll == deleteRoll) {
                        deleted = true;
                        continue; // skip writing this line
                    }
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error handling files: " + e.getMessage());
            return;
        }

        if (inputFile.delete() && tempFile.renameTo(inputFile)) {
            if (deleted) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Roll number not found. No student deleted.");
            }
        } else {
            System.out.println("Error updating the file.");
        }
    }
}
