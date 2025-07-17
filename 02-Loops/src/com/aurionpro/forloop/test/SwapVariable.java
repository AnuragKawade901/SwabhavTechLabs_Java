package com.aurionpro.forloop.test;

public class SwapVariable {
	public static void main(String[] args) {

		int variable1 = 3;
		int variable2 = 6;
		System.out.println("Before swaping: " + variable1 + " , " + variable2);

		int temporary = variable1;
		variable1 = variable2;
		variable2 = temporary;

		System.out.println("After Swaping: " + variable1 + " , " + variable2);
	}
}
