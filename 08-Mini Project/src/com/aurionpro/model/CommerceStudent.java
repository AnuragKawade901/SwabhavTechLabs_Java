package com.aurionpro.model;

public class CommerceStudent extends Student {
	private int accounts, business, economics;
	
	public CommerceStudent(String name, int rollNumber, int accounts, int business, int economics) {
		super(name, rollNumber, Stream.COMMERCE);
		this.accounts = accounts;
		this.business = business;
		this.economics = economics;
	}
	
	@Override
	public double calculatePerformance() {
		return (business + economics + business) / 3.0;
	}
	
	@Override
	public String getGrade() {
		double average = calculatePerformance();
		if(average >= 85) return "A";
		else if(average >=70) return "B";
		else if(average >=50) return "C";
		else return "D";
	}
	
	@Override
	protected void displaySubjects() {
		System.out.println("Subjects: Accounts: "+accounts+", Economics: "+economics+", Business Studies: "+business);
		System.out.println("Average: "+((business + economics + business) / 3.0));
	}
}
