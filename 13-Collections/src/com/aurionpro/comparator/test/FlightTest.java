package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.comparator.model.Flight;
import com.aurionpro.comparator.model.FlightFareDescComparator;

public class FlightTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Flight> flights = new ArrayList<>();

        System.out.print("Enter number of flights: ");
        int n = 0;

        // Flight count validation
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) throw new IllegalArgumentException("Number must be positive.");
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter a valid integer: ");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Try again: ");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for flight " + (i + 1) + ":");

            // Airline name input with validation
            String airline;
            while (true) {
                System.out.print("Airline Name: ");
                airline = scanner.nextLine().trim();
                if (!airline.isEmpty() && airline.matches("^[A-Za-z ]+$")) {
                    break;
                } else {
                    System.out.println("Invalid name. Only alphabets and spaces are allowed.");
                }
            }

            // Fare input with validation
            double fare;
            while (true) {
                System.out.print("Fare: $");
                try {
                    fare = Double.parseDouble(scanner.nextLine());
                    if (fare < 0) throw new IllegalArgumentException("Fare must be non-negative.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a valid number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            flights.add(new Flight(airline, fare));
        }

        // Sort flights by fare descending
        flights.sort(new FlightFareDescComparator());

        // Display
        System.out.println("\n--- Sorted Flight List (by Fare Descending) ---");
        for (Flight f : flights) {
            System.out.println(f);
        }

        scanner.close();
    }
}
