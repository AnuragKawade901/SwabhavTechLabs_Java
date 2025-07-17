package com.aurionpro.array.test;

import java.util.Scanner;

public class MaximumInArray {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int number = scanner.nextInt();
		
		int[] array = new int[number];
		
		System.out.println("Enter " + number + " element");
		
		for(int i = 0; i<number; i++) {
			array[i] = scanner.nextInt();
		}
		int maximum = array[0];
		for(int i = 1; i<number; i++) {
			if(array[i]> maximum) {
				maximum = array[i];
			}
		}
		System.out.println("Max value in the array is: "+maximum);
		scanner.close();
	}

}
 