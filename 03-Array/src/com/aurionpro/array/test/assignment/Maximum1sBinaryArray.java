package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class Maximum1sBinaryArray {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the size of the binary array: ");
		int number = scanner.nextInt();
		
		int[] array = new int[number];
		
		System.out.println("Enter binary array elements ie (0 or 1) only: ");
		
		for(int i = 0; i < number; i++) {
		array[i] = scanner.nextInt();
		}
		
		int maxCount = 0;
		int currentCount = 0;
		
		for(int i = 0; i<number;i++) {
			if(array[i] ==1) {
				currentCount++;
				if(currentCount > maxCount) {
					maxCount = currentCount;
				}
			}
				else {
					currentCount = 0;
				}
			}
		System.out.println("Maximum consecutive 1s: "+maxCount);
		scanner.close();
	}
}
