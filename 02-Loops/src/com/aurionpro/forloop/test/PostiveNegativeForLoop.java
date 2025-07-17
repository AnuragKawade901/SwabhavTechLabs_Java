package com.aurionpro.forloop.test;

public class PostiveNegativeForLoop {
	public static void main(String[] args) {
		
		for(int i = -5; i<6;i++) {
			if (i > 0) {
				System.out.println(i + " is postive");
			} else if (i == 0) {
				System.out.println(i + " not positive or negative");
			} else {
				System.out.println(i + " is negative");
			}
		}
	}

}
