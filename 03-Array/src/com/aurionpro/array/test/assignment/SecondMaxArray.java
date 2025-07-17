package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class SecondMaxArray {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		
		int[] array = new int[size];
		System.out.println("Enter "+size+" elements");
		
		for(int i = 0; i<size;i++) {
			array[i] = scanner.nextInt(); // display the array
		}
		int maximum = array[0];
		int secondMaximum = array[0];
		for(int i = 1;i<size;i++) {
			if(array[i]>maximum) {
			secondMaximum = maximum;
			maximum = array[i];
		}
			else if(array[i]> secondMaximum && array[i]!=maximum) {
				secondMaximum = array[i];
			}
		
	}
		System.out.println("Second maximum in the array is: "+secondMaximum);
		scanner.close();
}
}