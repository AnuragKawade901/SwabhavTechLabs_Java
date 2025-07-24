package com.aurionpro.Junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.aurionpro.Junit.model.GradeValidator;

public class GradeValiidatorTest {
	 GradeValidator validator;

	    @BeforeEach
	    void setUp() {
	        validator = new GradeValidator();
	    }

	    @Nested
	    @DisplayName("Tests for isGradeValid()")
	    class IsGradeValidTests {

	        @ParameterizedTest(name = "Grade {0} should be valid")
	        @ValueSource(ints = {0, 50, 100})
	        @DisplayName("Valid grades")
	        void testValidGrades(int grade) {
	            assertTrue(validator.isGradeValid(grade), grade + " should be valid");
	        }

	        @ParameterizedTest(name = "Grade {0} should be invalid")
	        @ValueSource(ints = {-10, -1, 101, 150})
	        @DisplayName("Invalid grades")
	        void testInvalidGrades(int grade) {
	            assertFalse(validator.isGradeValid(grade), grade + " should be invalid");
	        }
	    }

	    @Nested
	    @DisplayName("Tests for getGradeCategory()")
	    class GetGradeCategoryTests {

	        @ParameterizedTest(name = "Grade {0} should be '{1}'")
	        @CsvSource({
	            "0, Fail",
	            "39, Fail",
	            "40, Pass",
	            "60, Pass",
	            "74, Pass",
	            "75, Distinction",
	            "90, Distinction",
	            "100, Distinction"
	        })
	        @DisplayName("Grade category classification")
	        void testGradeCategory(int grade, String expectedCategory) {
	            assertEquals(expectedCategory, validator.getGradeCategory(grade));
	        }

	        @ParameterizedTest(name = "Grade {0} should throw IllegalArgumentException")
	        @ValueSource(ints = {-5, 101, 200})
	        @DisplayName("Invalid grades throw exception")
	        void testInvalidGradeCategory_throwsException(int grade) {
	            assertThrows(IllegalArgumentException.class, () -> validator.getGradeCategory(grade));
	        }
	    }
}

