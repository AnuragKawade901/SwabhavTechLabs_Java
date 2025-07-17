package com.aurionpro.oops.test;

import java.util.Scanner;

import com.aurionpro.oops.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Number of employee:");
		int number = scanner.nextInt();
		scanner.nextLine();
		Employee[] employee = new Employee[number];

		for (int i = 0; i < number; i++) {
			System.out.println("Enter the deatils about the employee");
			System.out.println("Enter the name: ");
			String employeeName = scanner.nextLine();

			System.out.println("Enter id: ");
			int employeeId = scanner.nextInt();

			System.out.println("Enter basic salary: ");
			double employeeSalary = scanner.nextDouble();
			scanner.nextLine();
			
			employee[i] = new Employee();
			employee[i].setName(employeeName);
			employee[i].setId(employeeId);
			employee[i].setSalary(employeeSalary);
			
		}
		for(Employee result:employee) {
			result.display();
		}
		scanner.close();
	}
}
