package com.aurionpro.polymorphism.model;

public class TravelCost {
	private static final int BASE_RATE_PER_KM = 10;
	
	public int estimate(int distance) {
		return distance * BASE_RATE_PER_KM;
	}
	public int estimate(int distance, int passengers) {
		int cost = distance * BASE_RATE_PER_KM;
		return(passengers>1)? cost*passengers:cost;
	}
	public double estimate(int distance, int passengers, boolean isAC) {
		int cost = estimate(distance, passengers);
		if (isAC) {
			cost += cost * 0.2;
		}
		return cost;
	}
}
