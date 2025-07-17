package com.aurionpro.array.employee.test;

import java.util.Scanner;

import com.aurionpro.array.test.assignment.EmployeeId;

public class EmployeeIdTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeId[] employees = new EmployeeId[2];

		System.out.println("Enter details for 5 employees: ");
		for (int i = 0; i < 2; i++) {
			System.out.println("\nEmployee " + (i + 1));
			System.out.println("ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();
		
			System.out.println("Name: ");
			String name = scanner.nextLine();
			
			System.out.println("Department: ");
			String department = scanner.nextLine();
			
			System.out.println("Salary: ");
			double salary = scanner.nextDouble();
			
			employees[i] = new EmployeeId(id,name,department,salary);
		}
		
		//Employee with lowest salary:
		double minimumSalary = employees[0].salary;
		String minimumName = employees[0].name;
		
		for(int i = 0; i < 2; i++) {
			if(employees[i].salary < minimumSalary) {
				minimumSalary = employees[i].salary;
				minimumName = employees[i].name;
			}
		}
		System.out.println("\nEmployee with lowest salary is: "+minimumName);
		
		//Searching department of employee
		scanner.nextLine();
		System.out.println("\nEnter department to search(eg IT): ");
		String searchDepartment = scanner.nextLine();
		
		System.out.println("Employees in department "+searchDepartment+": ");
		boolean found = false;
		for(int i = 0;i<2;i++) {
			if(employees[i].department.equalsIgnoreCase(searchDepartment)) {
				System.out.println(employees[i].name);
				found = true;
			}
		}
		if(!found) {
			System.out.println("No employees found in this department.");
		}
		
		//total salary expense
		double totalSalary = 0;
		for(int i = 0; i< 2;i++) {
			totalSalary += employees[i].salary;
		}
		System.out.println("\nTotal salary expense for the company: $"+totalSalary);
		scanner.close();
	}
}
