package com.aurionpro.polymorphism.test;

import java.util.Scanner;

import com.aurionpro.polymorphism.model.TravelCost;

public class TravelCostTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TravelCost travelCost = new TravelCost();

        System.out.print("Enter distance (km): ");
        int distance = scanner.nextInt();

        System.out.println("Estimated cost (1 passenger, non-AC): ₹" + travelCost.estimate(distance));

        System.out.print("Enter number of passengers: ");
        int passengers = scanner.nextInt();
        System.out.println("Estimated cost (" + passengers + " passengers, non-AC): ₹" + travelCost.estimate(distance, passengers));

        System.out.print("Is AC required? (true/false): ");
        boolean isAC = scanner.nextBoolean();
        System.out.println("Estimated cost (" + passengers + " passengers, AC=" + isAC + "): ₹" + travelCost.estimate(distance, passengers, isAC));

        scanner.close();
	}

}
