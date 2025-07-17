package com.aurionpro.array.test;

public class Movie {

	String movieTitle;
	String movieGenre;
	
	public Movie(String movieTitle, String movieGenre) {
		
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
	}
	public void display() {
		if(movieGenre.equalsIgnoreCase("action")) {
		System.out.println("Movie name: "+movieTitle);
	}
}
}