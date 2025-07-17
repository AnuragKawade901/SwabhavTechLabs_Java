package com.aurionpro.comparator.model;

import java.util.Comparator;

public class FlightFareDescComparator implements Comparator<Flight> {
	@Override
	public int compare(Flight flight1, Flight flight2) {
		return Double.compare(flight2.getFare(), flight1.getFare()); // Descending

	}
}
