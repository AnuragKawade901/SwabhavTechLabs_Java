package com.aurionpro.test;

public class CallStack {
	public static void main(String[] args) {
		
		System.out.println("Main method starts");
		method1();
		method2();
		System.out.println("Main ends");
	}
	public static void method1() {
		System.out.println("Method 1 starts");
		method2();
		System.out.println("Method 1 ends");
	}
	public static void method2() {
		System.out.println("Method 2 starts");
		System.out.println("Method 2 ends");
	}

}
