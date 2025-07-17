package com.aurionpro.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<Double> random = () -> Math.random() * 3;
		System.out.println(random.get());

		Supplier<LocalDate> currentDate = () -> LocalDate.now();
		System.out.println(currentDate.get());

		Supplier<LocalTime> currentTime = () -> LocalTime.now();
		System.out.println(currentTime.get());

		Supplier<List<String>> print = () -> Arrays.asList("User", "admin");
		System.out.println(print.get());
	}
}
