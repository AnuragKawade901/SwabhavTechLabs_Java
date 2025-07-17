package com.aurionpro.whileloop.test;

public class PostiveNegativeWhileLoop {
	public static void main(String[] args) {
		int i = -5;
		while (i < 6) {
			if (i > 0) {
				System.out.println(i + " is postive");
			} else if (i == 0) {
				System.out.println(i + " not positive or negative");
			} else {
				System.out.println(i + " is negative");
			}
			i++;
		}
	}
}
