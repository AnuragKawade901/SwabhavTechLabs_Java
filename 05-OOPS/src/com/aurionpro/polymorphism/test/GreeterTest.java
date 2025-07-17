package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.Greeter;

public class GreeterTest {
public static void main(String[] args) {
	Scanner scanner =  new Scanner(System.in);
	System.out.println("Enter your name: ");
	String userName = scanner.nextLine();
	
	Greeter greeter = new Greeter();
	greeter.greet();
	greeter.greet(userName);
	
	
	scanner.close();
}
}
