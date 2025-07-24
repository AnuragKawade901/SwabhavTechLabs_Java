package com.aurionpro.Junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.aurionpro.Junit.model.StringProcessor;

public class StringProcessorTest {
	StringProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new StringProcessor();
    }
    
    @Tag("fast")
    @Test
    @DisplayName("Check if 'madam' is a palindrome")
    void testIsPalindromeTrue() {
        assertTrue(processor.isPalindrome("madam"));
    }
    
    @Tag("fast")
    @Test
    @DisplayName("Check if 'hello' is not a palindrome")
    void testIsPalindromeFalse() {
        assertFalse(processor.isPalindrome("hello"));
    }
    @Nested
    @DisplayName("Tests for reverse() method")
    class ReverseTests {

        @Test
        @DisplayName("Reverse a normal string")
        void testReverseString() {
            assertEquals("dcba", processor.reverse("abcd"));
        }

        @RepeatedTest(3)
        @DisplayName("Repeat reverse test for same input")
        void repeatedReverseTest() {
            assertEquals("4321", processor.reverse("1234"));
        }

        @Disabled("Under development")
        @Test
        @DisplayName("Reverse string with special characters - pending")
        void testReverseWithSpecialChars() {
            // Implementation pending
            assertEquals("!dlroW ,olleH", processor.reverse("Hello, World!"));
        }
    }
}
