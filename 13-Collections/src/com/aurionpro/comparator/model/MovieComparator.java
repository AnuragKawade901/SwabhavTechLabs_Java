package com.aurionpro.comparator.model;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie> {
    private boolean ascending;

    public MovieComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Movie m1, Movie m2) {
        int yearCompare = ascending
                ? Integer.compare(m1.getYear(), m2.getYear())
                : Integer.compare(m2.getYear(), m1.getYear());

        if (yearCompare != 0) return yearCompare;

        // If years are equal, sort titles A–Z
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}