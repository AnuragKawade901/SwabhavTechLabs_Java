package com.aurionpro.array.test.assignment;

public class SortingArrayWithoutFunction {
public static void main(String[] args) {
	int[] array = {5,2,9,1,3};
	
	for(int i = 0; i<array.length - 1; i++) {
		for(int j = 0; j<array.length - 1 - i;j++) {
			if(array[j] > array[j+1]){
				int temporary = array[j];
				array[j] = array[j+1];
				array[j+1] = temporary;
			}
		}
	}
	System.out.println("Sorted array: ");
	for(int number : array) {
		System.out.println(number + " ");
	}
}
}
