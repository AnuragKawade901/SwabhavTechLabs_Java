package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.Converter;

public class ConverterTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Temperature Convertor");
	System.out.println("Enter value");
	double value = scanner.nextDouble();
	
	scanner.nextLine();
	System.out.println("Enter scale");
	String scale = scanner.nextLine();
//	scanner.nextLine();
	
	Converter converter = new Converter();
	converter.convert(value);
	converter.convert(value, scale);
	
	scanner.close();
	
}
}
