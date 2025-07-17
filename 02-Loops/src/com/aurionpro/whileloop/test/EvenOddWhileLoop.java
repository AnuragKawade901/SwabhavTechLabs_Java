package com.aurionpro.whileloop.test;

public class EvenOddWhileLoop {
	public static void main(String[] args) {
		int i = 0;
		while (i < 11) {
			if (i % 2 == 0) {
				System.out.println(i + " Even Number");
			} else {
				System.out.println(i + " Odd Number");
			}
			i++;
		}
	}
}
