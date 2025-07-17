package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;

import com.aurionpro.model.Employee;

public class EmployeeTest {
public static void main(String[] args) {
	ArrayList<Employee> list = new ArrayList<Employee>();
	
	list.add(new Employee(101, "Brad"));
	list.add(new Employee(122, "Andrew"));
	list.add(new Employee(132, "Tobey"));
	list.add(new Employee(100, "Tom"));
	list.add(new Employee(191, "Chris"));
	
	System.out.println(list);
	Collections.sort(list);
	System.out.println(list);
	
}
}
