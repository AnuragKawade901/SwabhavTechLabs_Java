package com.aurionpro.array.movie.test;

import java.util.Scanner;

import com.aurionpro.array.test.Movie;

public class MovieTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 5 movie title");
		
		Movie[] movies = new Movie[2];
		for (int i = 0; i < 2; i++) {
			System.out.println("Enter movie title: ");
			String title = scanner.nextLine();

			System.out.println("Enter genre ");
			String genre = scanner.next();
			scanner.nextLine();


			movies[i] = new Movie(title, genre);
		}
		
		for (Movie result : movies) {
			result.display();
		}
		scanner.close();
	}

	}

