package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class Rearrange1Darray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements:  ");
		int number = scanner.nextInt();
		
		int[] array = new int[number];
		
		System.out.println("Enter "+number+" numbers:" );
		for(int i = 0;i<number;i++) {
			array[i] = scanner.nextInt();
		}
		int left = 0;
		int right = number - 1;
		
		while(left<right) {
			if(array[left] % 2 == 0) {
				left++;
			}
			else if(array[right]%2 != 0) {
				right--;
			}
			else {
				int temporary = array[left];
				array[left] = array[right];
				array[right] = temporary;
				left++;
				right--;
			}
		}
		System.out.println("reaarange array (even first): ");
		for(int digit : array) {
			System.out.println(digit+" ");
		}
		
		scanner.close();
	}
}
