package com.aurionpro.Junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.aurionpro.Junit.model.MathUtils;

public class MathUtilsTest {
	MathUtils math = new MathUtils();
	
	@BeforeEach
	 void setUp() {
			System.out.println("Start of test");
	}
	@AfterEach
    void tearDown() {
        System.out.println("End of test");
    }
	  @Test
	    @DisplayName("Testing addition of two numbers")
	    void testAdd() {
	        assertEquals(5, math.add(2, 3), "2 + 3 should equal 5");
	    }

	    @Test
	    @DisplayName("Testing multiplication of two numbers")
	    void testMultiply() {
	        assertEquals(6, math.multiply(2, 3), "2 * 3 should equal 6");
	    }

	    @ParameterizedTest
	    @ValueSource(ints = {2, 4, 6, 8, 10, 100})
	    @DisplayName("Testing isEven() with multiple even numbers")
	    void testIsEven(int number) {
	        assertTrue(math.isEven(number), number + " should be even");
	    }

}
