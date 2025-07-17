package com.aurionpro.employee.model;

import java.time.LocalDate;

public class Employee {
	public String name;
	public double salary;
	public LocalDate joiningDate;
	public String gender;
	
	public Employee(String name, double salary, LocalDate joiningDate, String gender) {
		this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", joiningDate=" + joiningDate + ", gender=" + gender
				+ "]";
	}
}
