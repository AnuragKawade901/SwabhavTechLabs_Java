package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class FindingPeakArray {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter number of elements: ");
	        int number = scanner.nextInt();
	        int[] array = new int[number];

	        System.out.println("Enter " + number + " elements:");
	        for (int i = 0; i < number; i++) {
	        	array[i] = scanner.nextInt();
	        }

	        for (int i = 0; i < number; i++) {
	            boolean isLeftSmaller = (i == 0) || (array[i] >= array[i - 1]);
	            boolean isRightSmaller = (i == number - 1) || (array[i] >= array[i + 1]);

	            if (isLeftSmaller && isRightSmaller) {
	                System.out.println("Peak element found: " + array[i]);
	                break; // stop after finding one peak
	            }
	        }

	        scanner.close();
	    }
}

