package com.aurionpro.test;

public class WapperClass {
public static void main(String[] args) {
	
	int number1 = 10;
	Integer number2 = new Integer(number1); //boxing
	Integer number3 = number2; //auto boxing
	
	System.out.println("number1 " +number1);
	System.out.println("number2 " +number2);
	System.out.println("number3 " +number3);
	System.out.println(number2 == number3);
	
	char gender = 'a'; // here 'char' is primitive
	Character gen = gender; // here char is converted into Object 
	
	System.out.println(gender == gen);
	
	int number6 = number2.intValue(); //unboxing
	int number5 = number2; //auto-unboxing
	
	System.out.println(number5 == number2);
	System.out.println(number6 == number2);
}
}
