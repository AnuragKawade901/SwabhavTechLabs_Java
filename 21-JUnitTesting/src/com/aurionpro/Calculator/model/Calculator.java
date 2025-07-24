package com.aurionpro.Calculator.model;

public class Calculator {
    public int add(int number1, int number2) {
        return number1 + number2;
    }
    public int sub(int number1, int number2) {
    	return number1-number2;
    }
    public int division(int number1, int number2) {
    	if(number2==0) throw new ArithmeticException();
    	return number1/number2;
    }
}