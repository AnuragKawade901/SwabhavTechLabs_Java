package com.aurionpro.abstraction.test;

import java.util.Scanner;

import com.aurionpro.abstraction.model.Developer;
import com.aurionpro.abstraction.model.Intern;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Developer[] developer = new Developer[2];

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter developer name: ");
			String developerName = scanner.nextLine();
			System.out.println("Enter developer ID: ");
			int developerId = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter Base Salary: ");
			double baseSalary = scanner.nextDouble();

			System.out.println("Enter Bonus: ");
			double bonus = scanner.nextDouble();
			scanner.nextLine();

			developer[i] = new Developer(developerName, developerId, baseSalary, bonus);

		}
		for (Developer result : developer) {
			result.display();
		}
		Intern[] intern = new Intern[2];

		for (int i = 2; i < 4; i++) {
			System.out.println("Enter intern name");
			String internName = scanner.nextLine();
			System.out.println("Enter intern ID");
			int internId = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter Stripend");
			double stripend = scanner.nextDouble();
			scanner.nextLine();

			intern[i] = new Intern(internName, internId, stripend);

		}
		for (Intern result : intern) {
			result.display();
		}
	}
}
