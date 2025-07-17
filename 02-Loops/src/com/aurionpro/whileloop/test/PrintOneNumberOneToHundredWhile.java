package com.aurionpro.whileloop.test;

public class PrintOneNumberOneToHundredWhile {
	public static void main(String[] args) {
		int i = 0;
		while(i<101) {
			if(i%2 !=0) {
				System.out.println(i);
			}
			i++;
		}
	}

}
