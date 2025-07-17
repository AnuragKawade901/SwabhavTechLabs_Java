package com.aurionpro.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.aurionpro.model.Employee;

public class EmployeeSerilization {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Employee employee = new Employee("Anurag",123,30000.0);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
		out.writeObject(employee);
		
		out.close();
		System.out.println("Object saved successfully");
	}
}
