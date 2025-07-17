package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class Marks3Subject {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] marks = new int[3];
		
		System.out.println("Enter marks of 3 subjects");
		for(int i = 0 ; i<3; i++) {
			System.out.println("Subject "+(i+1)+" :");
			marks[i] = scanner.nextInt();
		}
		System.out.println("\nMarks entered: ");
		for(int i = 0; i <3;i++) {
			System.out.println("Subject "+(i+1)+ ": "+marks[i]);
		}
		scanner.close();
	}
	
}
