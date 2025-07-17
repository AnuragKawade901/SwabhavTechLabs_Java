package com.aurionpro.polymorphism.model;

public class Adder {
 int number1;
 int number2;
 int number3;
 double number4;
 double number5;
 
 public void add(int number1, int number2) {
	 System.out.println(number1+number2);
 }
 public void add(double number4, double number5) {
	 System.out.println(number4+number5);
 }
 public void add(int number1, int number2, int number3) {
	 System.out.println(number1+number2+number3);
 }
}
