package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.comparator.model.Movie;
import com.aurionpro.comparator.model.MovieComparator;

public class MovieTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        System.out.print("Enter number of movies: ");
        int n = 0;

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
            System.out.println("\nEnter details for movie " + (i + 1) + ":");

            String title;
            while (true) {
                System.out.print("Title: ");
                title = scanner.nextLine().trim();
                if (!title.isEmpty() && title.matches("^[A-Za-z0-9 ,.:'\"!?()-]+$")) {
                    break;
                } else {
                    System.out.println("Invalid title. Use letters, numbers, spaces and basic punctuation.");
                }
            }

            int year;
            while (true) {
                System.out.print("Year: ");
                try {
                    year = Integer.parseInt(scanner.nextLine());
                    if (year < 1888 || year > 2100)
                        throw new IllegalArgumentException("Enter a realistic movie year (1888–2100).");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a valid year.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            movies.add(new Movie(title, year));
        }

        // Ask user for sort order
        boolean ascending = false;
        while (true) {
            System.out.print("\nSort by year:\n1. Ascending\n2. Descending\nEnter choice (1 or 2): ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                ascending = true;
                break;
            } else if (choice.equals("2")) {
                ascending = false;
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        // Sort and display
        movies.sort(new MovieComparator(ascending));

        System.out.println("\n--- Sorted Movie List ---");
        for (Movie m : movies) {
            System.out.println(m);
        }

        scanner.close();
    }
}
