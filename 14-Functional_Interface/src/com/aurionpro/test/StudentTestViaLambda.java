package com.aurionpro.test;

import com.aurionpro.model.IStudent;
import com.aurionpro.model.IStudent2;
//import com.aurionpro.model.IStudent3;

public class StudentTestViaLambda {
	public static void main(String[] args) {

		IStudent student = () ->  System.out.println("Hello Java");
		student.greet();

		IStudent2 student2 = msg -> msg;
		System.out.println("HI");

//		IStudent3 student3 = (a, b) -> a + b;
	}
}
