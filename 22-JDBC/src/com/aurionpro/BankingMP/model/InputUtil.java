package com.aurionpro.BankingMP.model;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);
    public static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }
    public static int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }
    public static int getValidPin(String prompt) {
        int pin;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            try {
                pin = Integer.parseInt(sc.nextLine());
                if (String.valueOf(pin).length() == 4) {
                    return pin;
                } else {
                    System.out.println("❌ PIN must be exactly 4 digits.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a 4-digit number.");
            }
        }
    }
    public static double getValidDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = Double.parseDouble(scanner.nextLine().trim());
                if (val >= 0) return val;
                System.out.println("Amount cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    public static String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ Input cannot be empty.");
            } else if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("Name must contain only alphabets and spaces.");
            } else {
                return input;
            }
        }
    }
    public static String getValidPassword(String msg) {
        String pass;
        do {
            pass = getString(msg);
            if (pass.length() < 4) {
                System.out.println("❌ Password must be at least 4 characters.");
            }
        } while (pass.length() < 4);
        return pass;
    }

    public static String getValidMobile(String msg) {
        String mobile;
        do {
            mobile = getString(msg);
            if (!mobile.matches("\\d{10}")) {
                System.out.println("❌ Mobile number must be 10 digits.");
            }
        } while (!mobile.matches("\\d{10}"));
        return mobile;
    }

    public static String getValidEmail(String msg) {
        String email;
        do {
            email = getString(msg);
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
                System.out.println("❌ Invalid email format. Add @ or .com");
            }
        } while (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"));
        return email;
    }
}
