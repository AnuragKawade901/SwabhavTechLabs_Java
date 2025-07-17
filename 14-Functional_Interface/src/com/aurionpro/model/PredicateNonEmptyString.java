package com.aurionpro.model;

import java.util.function.Predicate;

public class PredicateNonEmptyString {
public static void main(String[] args) {
	String[] list = {"", "Java", null, " "};
    Predicate<String> predicate = string -> string != null && !string.trim().isEmpty();
	
	for(String string : list) {
		System.out.println(predicate.test(string));
	}
}
}
