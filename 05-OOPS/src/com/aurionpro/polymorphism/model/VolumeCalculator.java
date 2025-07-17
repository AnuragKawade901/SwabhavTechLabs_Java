package com.aurionpro.polymorphism.model;

public class VolumeCalculator {
	int side;
	int length;
	int breadth;
	int height;
	double radius;
	
	public void volume(int side) {
		System.out.println("Volume of cube: "+(side*side*side));

	}
	public void volume(int length, int breadth, int height) {
		System.out.println("Volume of cuboid: "+(length*breadth*height));
	}
	public void volume(	double radius) {
		System.out.println("Volume of spehere: "+((4/3)*3.14*(radius*radius*radius)));
	}
}
