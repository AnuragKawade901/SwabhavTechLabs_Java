package com.aurionpro.oops.test;

import java.util.Scanner;

import com.aurionpro.oops.model.EmployeeBonusValidator;

public class EmployeeBonusTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of employees");
		int number = scanner.nextInt();
		scanner.nextLine();
		
		EmployeeBonusValidator[] employee = new EmployeeBonusValidator[number];
		for(int i = 0; i < number; i++) {
			System.out.println("Enter the details of employee");
			System.out.println("Enter the name of the employee: ");
			String employeeName = scanner.nextLine();
			
			System.out.println("Enter salary");
			double employeeSalary = scanner.nextDouble();
			
			System.out.println("Enter bonus");
			double employeeBonus = scanner.nextDouble();
			scanner.nextLine();
			
			employee[i] = new EmployeeBonusValidator();
			employee[i].setName(employeeName);
			employee[i].setSalary(employeeSalary);
			employee[i].setBonus(employeeBonus);
		}
		for(EmployeeBonusValidator result : employee) {
			result.display();
		}
		scanner.close();
	}
}
