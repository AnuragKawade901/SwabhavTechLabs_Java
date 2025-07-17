package com.aurionpro.forloop.test;

public class EvenOddForLoop {
	public static void main(String[] args) {

		for (int i = 0; i < 11; i++) {
			if (i % 2 == 0) {
				System.out.println(i + " Even Number");
			} else {
				System.out.println(i + " Odd Number");
			}
		}
	}

}
