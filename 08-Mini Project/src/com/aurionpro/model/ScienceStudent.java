package com.aurionpro.model;

public class ScienceStudent extends Student {
	private int physics, maths, chemistry;
	
	public ScienceStudent(String name, int rollNumber, int physics, int maths, int chemistry) {
		super(name, rollNumber, Stream.SCIENCE);
		this.physics = physics;
		this.maths = maths;
		this.chemistry = chemistry;
	}
	
	@Override
	public double calculatePerformance() {
		return (physics + chemistry + maths) / 3.0;
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
		System.out.println("Subjects: Physics: "+physics+", Chemistry: "+chemistry+", Maths: "+maths);
		System.out.println("Average: "+((physics + chemistry + maths) / 3.0));

	}
}
