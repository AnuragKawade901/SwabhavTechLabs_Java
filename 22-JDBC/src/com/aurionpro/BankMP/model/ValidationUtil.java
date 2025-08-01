package com.aurionpro.BankMP.model;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static boolean isValidMobile(String mobile) {
        return mobile.matches("\\d{10}");
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
        return Pattern.matches(regex, email);
    }

    public static boolean isValidPin(int pin) {
        return String.valueOf(pin).matches("\\d{4}");
    }

    public static boolean isPositiveAmount(double amount) {
        return amount > 0;
    }
}
