package com.aurionpro.array.test;

import java.util.Arrays;

public class StudentMarks {

	String studentName;
	int studentRollNumber;
	int[] studentMarks;

	public StudentMarks(String studentName, int studentRollNumber, int[] studentMarks) {

		this.studentName = studentName;
		this.studentRollNumber = studentRollNumber;
		this.studentMarks = studentMarks;
	}

	public void display() {
		System.out.println(
				"Name: " + studentName + " Roll Number: " + studentRollNumber + " Marks of Three Subjects[s1,s2,s3]: " + Arrays.toString(studentMarks));
	}
}
