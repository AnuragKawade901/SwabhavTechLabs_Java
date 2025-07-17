package com.aurionpro.model;

public class NestedTryCatchExample {
	public static void main(String[] args) {

        try {
            // Outer try block (for ArithmeticException)
            int result = 10 / 0;  // Triggers ArithmeticException

            try {
                // Inner try block (for ArrayIndexOutOfBoundsException)
                int[] arr = new int[2];
                System.out.println("Accessing 5th element: " + arr[4]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: Array index out of bounds.");
            }

        } catch (ArithmeticException e) {
            System.out.println("Outer catch: Cannot divide by zero.");
        }

        System.out.println("Program ended.");
    }
}
