package com.aurionpro.model;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<Integer> isOddChecker = input -> input % 2 == 1;
		System.out.println(isOddChecker.test(12));

		Predicate<String> isEmpty = str -> str.isEmpty();
		System.out.println(isEmpty.test("A"));
	}
}
