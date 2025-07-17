package com.aurionpro.whileloop.test;

public class FactorialNumberWhile {
	public static void main(String[] args) {
		 int number = 4;
		 long factorial = 1;
		 
		 int i = 1;
		 while(i<=number) {
			 factorial*=i;
			 i++;
		 }
		 System.out.println("Factorial of the number "+number+" is: "+factorial);
	}
}
