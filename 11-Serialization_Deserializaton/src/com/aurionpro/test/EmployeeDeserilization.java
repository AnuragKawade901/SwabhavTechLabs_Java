package com.aurionpro.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.aurionpro.model.Employee;

public class EmployeeDeserilization {
public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"));
	Employee employee2 = (Employee) in.readObject();
	in.close();
	System.out.println("Employee object restore");
	employee2.display();
}
}
