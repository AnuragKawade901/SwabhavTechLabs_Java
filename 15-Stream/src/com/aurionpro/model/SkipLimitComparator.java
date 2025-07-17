package com.aurionpro.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SkipLimitComparator {
	public static void main(String[] args) {
//		List<String> names = Arrays.asList("Anurag","Messi","Leo");
//		names.stream().sorted(Comparator.comparing(String::length).reversed()).limit(1).forEach(System.out::println);
		
		
//		4. Given a list of products, skip the first 2 products priced above ₹500 and print the rest.
//        List<String> products = Arrays.asList("Laptop", "Mouse", "Book", "Keyboard", "Phone", "Pen", "Charger");
//        List<Integer> prices = Arrays.asList(75000, 700, 450, 900, 25000, 40, 600);
//        prices.stream().filter(p -> p > 500).skip(2).forEach(System.out::println);
        
//        From a list of words, filter words longer than 3 letters and skip the first 3 of them.
        List<String> words = Arrays.asList("Java", "is", "awesome", "fun", "Stream", "API", "powerful", "cool");
        words.stream().filter(w -> w.length()>3).skip(3).forEach(System.out::println);
        
        
//        From a list of integers, filter even numbers, limit to the first 4 even numbers, and calculate their total.
	}
}
