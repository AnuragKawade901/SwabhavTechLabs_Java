package com.aurionpro.student.model;

public class Student {
	private int roll;
    private String name;
    private int marks;

    public Student(int roll, String name, int marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return roll + "," + name + "," + marks;
    }

    public String display() {
        return "Roll: " + roll + ", Name: " + name + ", Marks: " + marks;
    }
}
