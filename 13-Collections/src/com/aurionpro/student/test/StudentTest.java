package com.aurionpro.student.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.aurionpro.student.model.IDAscComparator;
import com.aurionpro.student.model.IDDescComparator;
import com.aurionpro.student.model.NameAscComparator;
import com.aurionpro.student.model.NameDescComparator;
import com.aurionpro.student.model.Student;

public class StudentTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Student> students = new ArrayList<>();
	
	students.add(new Student(101, "Amit"));
	students.add(new Student(103, "Raj"));
	students.add(new Student(102, "Zara"));
	
	System.out.println("Choosing Sorting Criteria: ");
	System.out.println("1. Sort by ID");
	System.out.println("2. Sort by Name");
	System.out.println("Enter: ");
    int fieldChoice = scanner.nextInt();
    
    System.out.println("Choose Order:");
    System.out.println("1. Ascending");
    System.out.println("2. Descending");
    System.out.println("Enter: ");
    int orderChoice = scanner.nextInt();
    
    Comparator<Student> comparator = null;
    if(fieldChoice == 1 && orderChoice == 1) {
    	comparator = new IDAscComparator();
    }
    else if(fieldChoice == 1 && orderChoice == 2) {
    	comparator = new IDDescComparator();
    }
    else if(fieldChoice == 2 && orderChoice == 1) {
    	comparator = new NameAscComparator();
    }
    else if(fieldChoice == 2 && orderChoice == 2) {
    	comparator = new NameDescComparator();
    }
    else {
    	System.out.println("invalid choice");
    	return;
    }
    Collections.sort(students, comparator);
    
    System.out.println("Sorted Students");
    for(Student student : students) {
    	System.out.println(student);
    }
    scanner.close();
    

}
}
