package com.aurionpro.model;

import java.util.function.Predicate;

public class PredicateOddNumber {
public static void main(String[] args) {
	Integer[] list = {1,2,3,4,5,6,7,8,9,10};
	
	Predicate<Integer> predicate = number -> number %2 != 0;
	for(Integer number : list) {
		System.out.println(predicate.test(number));
	}
}
}
