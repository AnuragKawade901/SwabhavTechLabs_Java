package com.aurionpro.whileloop.test;

public class PrimeNumberWhile {
 public static void main(String[] args) {
	 
	 int number = 4;
	 boolean prime = true;
	 if(number <=1) {
		 prime = false;
	 }
	 else {
		 int i = 2;
		 while(i<= number/2) {
			 if(number % 1 == 0) {
				 prime = false;
				 break;
				 
			 }
			 i++;
		 }
	 }
	 if(prime) {
		 System.out.println(number + " Is Prime");
	 }
	 else {
		 System.out.println(number + " Not prime");
	 }
}
}
