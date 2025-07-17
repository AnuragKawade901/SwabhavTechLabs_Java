package com.aurionpro.model;

public class ArtsStudent extends Student{
private int history, politicalScience, sociology;
	
	public ArtsStudent(String name, int rollNumber, int history, int politicalScience, int sociology) {
		super(name, rollNumber, Stream.ARTS);
		this.history = history;
		this.politicalScience = politicalScience;
		this.sociology = sociology;
	}
	
	@Override
	public double calculatePerformance() {
		return (history + sociology + politicalScience) / 3.0;
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
		System.out.println("Subjects: history: "+history+", Sociology: "+sociology+", Political Science: "+politicalScience);
		System.out.println("Average: "+((history + sociology + politicalScience) / 3.0));
	}
}
