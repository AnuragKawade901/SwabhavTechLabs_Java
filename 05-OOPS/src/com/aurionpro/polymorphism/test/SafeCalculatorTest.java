package com.aurionpro.polymorphism.test;



import com.aurionpro.polymorphism.model.SafeCalculator;

public class SafeCalculatorTest {
	public static void main(String[] args) {
		//intger
		SafeCalculator calculate = new SafeCalculator();
		System.out.println("10/2 = "+calculate.divide(10, 2));
		
		System.out.println("10/0 = "+calculate.divide(10, 0));
		
		//double
		System.out.println("10.2/2.2 = "+calculate.divide(10.2, 2.2));
		
		System.out.println("10.2/0 = "+calculate.divide(10.2, 0));
	}
}
