package com.aurionpro.test;

public class CommandLineArgument {
	public static void main(String[] args) {
		
		int number1 = Integer.parseInt(args[0]);
		int number2 = Integer.parseInt(args[1]);
		
		String sum = args[0] + args[1];
		System.out.println("Sum: "+ sum);
		System.out.println(number1 + number2);
	}
}
