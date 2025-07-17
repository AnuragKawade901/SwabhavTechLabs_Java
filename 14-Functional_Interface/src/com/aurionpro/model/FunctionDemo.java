package com.aurionpro.model;

import java.util.function.Function;

public class FunctionDemo {
	public static void main(String[] args) {
		Function<String, Integer> function = i -> i.length();
		System.out.println(function.apply("hi"));

	}
}