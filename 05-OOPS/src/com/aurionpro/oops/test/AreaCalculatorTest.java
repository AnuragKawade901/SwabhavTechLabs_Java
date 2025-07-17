package com.aurionpro.oops.test;

import java.util.Scanner;

import com.aurionpro.oops.model.AreaCalculator;

public class AreaCalculatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter radius of the circle: ");
		int radiusCircle = scanner.nextInt();
		scanner.nextLine();
		AreaCalculator circle = new AreaCalculator();
		circle.setRadius(radiusCircle);
		circle.display();
	}
}
