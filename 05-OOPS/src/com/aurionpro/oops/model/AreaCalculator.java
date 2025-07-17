package com.aurionpro.oops.model;

public class AreaCalculator {
	int radius;
	
	public int getRadius()
	{
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double calculateArea() {
		return 3.141*(radius*radius);
	}
	public void display() {
		System.out.println("Radius: "+radius+" Area: "+calculateArea());
	}
}

