package com.aurionpro.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo2 {
public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1,3,4,1,2,5);
	list.stream().sorted().forEach(System.out::println);
	System.out.println("-------------------------------");
	list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
}
}
