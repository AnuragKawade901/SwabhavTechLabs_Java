package com.aurionpro.Junit.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.aurionpro.Junit.model.Calculator;



public class CalculatorTest {
	Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name = "Check if {0} is prime")
    @ValueSource(ints = {2, 3, 5, 7, 11, 13})
    @DisplayName("Prime number tests")
    void test_isPrime_with_prime_numbers(int number) {
        assertTrue(calculator.isPrime(number), number + " should be prime");
    }

    @ParameterizedTest(name = "Check if {0} is NOT prime")
    @ValueSource(ints = {0, 1, 4, 6, 8, 9, 10, 12})
    @DisplayName("Non-prime number tests")
    void test_isPrime_with_non_prime_numbers(int number) {
        assertFalse(calculator.isPrime(number), number + " should not be prime");
    }
}
