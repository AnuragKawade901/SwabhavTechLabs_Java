package com.aurionpro.polymorphism.model;

public class AreaCalculator {
	private int side;
	private int length;
	private int breadth;
	private double radius;
	
	public void area(int side) {
		System.out.println("Area of square: "+(side*side));
	}
	public void area(int length, int breadth) {
		System.out.println("Area of rectangle: "+(length*breadth));
	}
	public void area(double radius) {
		System.out.println("Area of circle: "+(3.14*(radius*radius)));
	}
}
