package com.aurionpro.array.test.assignment;

import java.util.Scanner;

public class SumOfRowAndColumn2Darray {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 
		 int[][] matrix = new int[3][3];
		 
		 System.out.println("Enter inputs for the matrix"); //taking input
		 for(int i = 0; i<3;i++) {
			 for(int j = 0;j<3;j++) {
				 matrix[i][j] = scanner.nextInt();
			 }
		 }
		 System.out.println("The Matrix is: "); //print of the matrix
		 for(int i = 0; i<3;i++) {
			 for(int j = 0; j<3;j++) {
				 System.out.print(matrix[i][j] + " ");
			 }
			 System.out.println(" ");
		 }
		 System.out.println("Addition of row is: "); // addition of row
		 for(int i = 0;i<3;i++) {
			 int rowSum = 0;
			 
			 for(int j = 0; j<3;j++) {
				 rowSum += matrix[i][j];
			 }
			 System.out.println("Sum of row is "+ (i+1) + ": " + rowSum);
		 }
//		 System.out.println("/nAddition of column is: ");
//		 int columnSum = 0;
//		 for(int column = 0;column<3;column++) {
//			 colSum += matrix[]
		 
		 System.out.println("Addition of column is: ");
		 for(int j = 0;j<3;j++) {
			 int columnSum = 0;
			 
			 for(int i = 0; i<3;i++) {
				 columnSum+= matrix[i][j];
			 }
			 System.out.println("Sum of column is "+(j+1)+ ": "+columnSum);
			 
		 }
			scanner.close();

	}

}
