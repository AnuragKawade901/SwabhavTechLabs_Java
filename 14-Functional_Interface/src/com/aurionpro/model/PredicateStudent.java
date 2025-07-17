package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateStudent {
public static void main(String[] args) {
	List<Student> students = new ArrayList<>();
	students.add(new Student("Anurag", 75));
    students.add(new Student("rohit", 32));
    students.add(new Student("lewis", 48));
    students.add(new Student("max", 39));
    students.add(new Student("messi", 90));
    
    Predicate<Student> predicate = student -> student.marks >=40;
    
    for(Student student : students) {
    	if(predicate.test(student)) {
    		System.out.println(student);
    	}
    }
}
}
