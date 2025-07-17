package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.VolumeCalculator;

public class VolumeCalculatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter side for cube; length, breath adn height for cuboid; radius for spehere");
		System.out.println("Enter side: ");
		int side = scanner.nextInt();
		
		System.out.println("Enter length: ");
		int length = scanner.nextInt();
		System.out.println("Enter breadth: ");
		int breadth = scanner.nextInt();
		System.out.println("Enter height: ");
		int height = scanner.nextInt();
		 
		System.out.println("Enter radius: ");
		double radius = scanner.nextDouble();
		
		VolumeCalculator volumeCalculator = new VolumeCalculator();
		volumeCalculator.volume(side);
		volumeCalculator.volume(length, breadth, height);
		volumeCalculator.volume(radius);
		
		scanner.close();

	}
}
