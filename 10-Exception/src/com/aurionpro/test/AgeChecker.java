package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.AgeEligibility;

public class AgeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        
        try {
            int age = scanner.nextInt();
            if (age < 18) {
                throw new AgeEligibility("Not eligible to vote");
            } else {
                System.out.println("Eligible to vote");
            }
        } catch (AgeEligibility e) {
            System.out.println(e.getMessage());
        }
    }
}