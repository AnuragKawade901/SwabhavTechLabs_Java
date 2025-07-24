package com.aurionpro.Junit.model;

public class StringProcessor {
	public boolean isPalindrome(String str) {
		if (str == null)
			return false;
		String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
	}
	public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

}