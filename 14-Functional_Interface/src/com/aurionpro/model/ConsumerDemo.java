package com.aurionpro.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
public static void main(String[] args) {
	Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
	consumer.accept("abcdefghijklmnopqrstuvwxyz");
	
	Consumer<List<Integer>> consumer2 = list -> list.forEach(System.out::println); //lambda method for "for each"
	consumer2.accept(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
	
}
}