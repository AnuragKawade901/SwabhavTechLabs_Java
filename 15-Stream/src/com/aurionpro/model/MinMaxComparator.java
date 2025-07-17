package com.aurionpro.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMaxComparator {
public static void main(String[] args) {
	//using compartor to find minimum (min()) and maximum (max())
	
//	List<String> names = Arrays.asList("Anurag","Messi","Max");
	List<Integer> list = Arrays.asList(2, 4, 5, 23, 67, 33, 78, 67, 44, 99);
//	list.stream().min(Comparator.comparing(Integer::intValue)).ifPresent(System.out::println);
//	System.out.println("--------------------------------------------------------------------");
//	list.stream().max(Integer::compareTo).ifPresent(System.out::println);
	
//	names.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
	
//	ArrayList<Student> student = new ArrayList<Student>();
//	student.add("a",34,4);
//	student.add("b",55,2);
//	student.stream().max(Student::compareTo).ifPresent
	
	list.stream().filter(n ->n%2 == 0).max(Comparator.comparing(Integer::intValue)).ifPresent(System.out::println);
	
}
}
 