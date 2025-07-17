package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.Printer;

public class PrinterTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the message: ");
	String printerMsg = scanner.nextLine();
	
	System.out.println("Enter the number: ");
	int printerNumber = scanner.nextInt();
	
	Printer printer = new Printer();
	printer.print();
	printer.print(printerMsg);
	printer.print(printerNumber);
	
	scanner.close();
}
}
