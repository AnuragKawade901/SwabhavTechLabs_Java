package com.aurionpro.Calculator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.aurionpro.Calculator.model.Calculator;

public class CalculatorTest {
	Calculator cal = new Calculator();

	@Test
	public void testAddtion() {
		int sum = cal.add(2, 3);
		assertEquals(5, sum);
	}

	@Test
	public void testSubtraction() {
		int diff = cal.sub(10, 5);
		assertEquals(5, diff);
	}
	@Test
	public void testDivision() {
		assertEquals(2, cal.division(4, 2));
	}
	@Test
	public void testDivisionByzero() {
		assertThrows(ArithmeticException.class, () -> cal.division(10,0));
	}
	@Test
	public void testTrue()
	{
		int age=20;
		assertTrue(age>18);
	}
	@DisplayName(value = "Anurag")
	@Test
	public void testString()
	{
		String name = "Anurag";
		assertTrue(name.length() > 3);
	}
	@RepeatedTest(5)
	public void randomNumberTest() {
	Random random = new Random();
	int count = random.nextInt(100);
	assertTrue(count >= 0 && count < 100);

	}
	@Test
	@Disabled("Under Development")
	public void testString1() {
	String name = "Amit";
	assertTrue(name.length() > 5);

	}
	
	
	
}
