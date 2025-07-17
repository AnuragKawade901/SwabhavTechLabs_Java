package com.aurionpro.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
public static void main(String[] args) {
	
	// filter
	
//	List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//	
//	List<Integer> streamObject = list.stream().filter(i -> i %2 == 1).collect(Collectors.toList());
//	System.out.println(streamObject);
//	
//	list.stream().filter(i -> i %2 == 0).collect(Collectors.toList()).forEach(res -> System.out.print(res +" , "));
//list.stream().filter(i -> i %2 == 0).toList();
//	
//	List<String> list2 = Arrays.asList("An", "Bx", "Az","Vc");
//	list2.stream().filter(i -> i.toUpperCase().startsWith("A")).collect(Collectors.toList()).forEach(System.out::println);
	
//	List<String> list3 = Arrays.asList("Anurag", "Av", " ","");
//	list3.stream().filter(s -> s != null && !s.trim().isEmpty()).collect(Collectors.toList()).forEach(System.out::println);
	
//	List<Integer> student =Arrays.asList(40,30,20,10,99);
//	student.stream().filter(i -> i >= 40).collect(Collectors.toList()).forEach(System.out::println);
//	
//	List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
//	list.stream().map(i -> i*2).collect(Collectors.toList()).forEach(System.out::println);
	
	//map
	
//	List<String> list = Arrays.asList("A","B","C","asdsadsad");
//	list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
//	List<Boolean> result = list.stream().map(str -> str.length() > 4).collect(Collectors.toList());
//	System.out.println(result);
	
//	List<Integer> list = Arrays.asList(2,4,3);
//	list.stream().map(i -> i*i).collect(Collectors.toList()).forEach(System.out::println);
	
//	List<String> list = Arrays.asList("Anurag","Juhi","Anika","Sanjay");
//	list.stream().map(i -> "Mr/Ms "+ i).collect(Collectors.toList()).forEach(System.out::println);
	
//	List<Double> list = Arrays.asList(23.1,22.2,11.1);
//	list.stream().map(i -> i*0.90).collect(Collectors.toList()).forEach(System.out::println);
	
	//count
	List<Integer> list =Arrays.asList(40,30,20,10,99);
	long count = list.stream().filter(i -> i>30).distinct().count();
	System.out.println(count);
	
	Integer[] marks = {12,21,23};
	Arrays.stream(marks).filter(i -> i>=40);
	Stream s = Stream.of(1,2,3,"A","asd");
	
	}
}
