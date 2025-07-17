package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.AreaCalculator;

public class AreaCalculatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter side, length, breadth, radius to get the area of square, rectangle, circle");
		System.out.println("Enter side: ");
		int side = scanner.nextInt();

		System.out.println("Enter length: ");
		int length = scanner.nextInt();
		
		System.out.println("Enter breadth");
		int breadth = scanner.nextInt();
		
		System.out.println("Enter radius");
		double radius = scanner.nextDouble();
		
		AreaCalculator areaCalulator = new AreaCalculator();
		areaCalulator.area(side);
		areaCalulator.area(length, breadth);
		areaCalulator.area(radius);
		
		scanner.close();
	}
}
