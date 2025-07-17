package com.aurionpro.model;

public class MultipleCatchExample {
    public static void main(String[] args) {
        String[] arr = new String[2];
        String str = null;

        try {
            System.out.println("Accessing 5th element: " + arr[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");
        }

        try {
            System.out.println("Length of string: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Error: Null string used.");
        }

        System.out.println("Program finished.");
    }
}

