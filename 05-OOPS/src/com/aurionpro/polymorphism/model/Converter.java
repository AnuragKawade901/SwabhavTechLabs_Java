package com.aurionpro.polymorphism.model;

public class Converter {
	private double celsius;
	private double value;
	private String scale;
	
	public void convert(double celsius) {
		System.out.println("Celsius to fahrenheit: "+((celsius*(9/5))+32)+"F");
	}
	
	public void convert(double value, String scale) {
		if(scale.equalsIgnoreCase("c")) {
			System.out.println("In Fahrenheit"+((value*(9/5))+32)+"F");
		}
		else if(scale.equalsIgnoreCase("f")) {
			System.out.println("In Celsius"+((value - 32)*(5/9))+"C");
		}
		else {
			System.out.println("wrong input, enter c or f");
		}
	}

}
