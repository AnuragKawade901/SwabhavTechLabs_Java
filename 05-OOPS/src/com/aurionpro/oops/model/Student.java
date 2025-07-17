package com.aurionpro.oops.model;

public class Student {
	private String name;
	private int roll;
	private String course;
	
	public String getName()
	{
		return name;
	}
	public int getRoll()
	{
		return roll;
	}
	public String getCourse()
	{
		return course;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void display() {
		System.out.println("Name: "+name+" Roll No.: "+roll+" Course: "+course);
	}
}
