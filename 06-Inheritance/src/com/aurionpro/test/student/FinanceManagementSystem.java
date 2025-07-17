package com.aurionpro.test.student;

import java.util.Scanner;

import com.aurionpro.model.student.Accountant;
import com.aurionpro.model.student.Department;
import com.aurionpro.model.student.PaymentMode;
import com.aurionpro.model.student.Proffesor;
import com.aurionpro.model.student.Student;

public class FinanceManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Student
        System.out.println("Enter Student Name:");
        String studentName = scanner.nextLine();

        System.out.println("Enter Roll Number:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Department (COMPUTER_SCIENCE, MECHANICAL, INFORMATION_TECHNOLOGY, CIVIL, ELECTRICAL):");
        Department studentDept = Department.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Enter Total Fee:");
        double totalFee = scanner.nextDouble();

        Student student = new Student(studentName, studentDept, rollNumber, totalFee);

        System.out.println("Enter Fee Amount to Pay:");
        double feeAmount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Payment Mode (CASH, CARD, ONLINE):");
        PaymentMode studentPaymentMode = PaymentMode.valueOf(scanner.nextLine().toUpperCase());

        // Create Professor
        System.out.println("\nEnter Professor Name:");
        String professorName = scanner.nextLine();

        System.out.println("Enter Professor ID:");
        int professorId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Department:");
        Department professorDept = Department.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Enter Professor Salary:");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Proffesor professor = new Proffesor(professorName, professorDept, professorId);
        professor.setSalary(salary);

        System.out.println("Enter Salary Payment Mode (CASH, CARD, ONLINE):");
        PaymentMode profPaymentMode = PaymentMode.valueOf(scanner.nextLine().toUpperCase());

        // Accountant Processing
        Accountant accountant = new Accountant("Amit_Accountant");
        accountant.processPayment(student, feeAmount, studentPaymentMode);
        accountant.processPayment(professor, profPaymentMode);

        // Summary
        System.out.println("\n--- Finance Summary ---");
        System.out.println("Total Fee Collected: ₹" + Accountant.totalFeeCollected);
        System.out.println("Total Salary Paid: ₹" + Accountant.totalSalaryPaid);

        scanner.close();
    }
}
