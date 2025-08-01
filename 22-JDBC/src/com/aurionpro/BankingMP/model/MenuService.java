package com.aurionpro.BankingMP.model;

public class MenuService {
    public static void showMainMenu() {
        System.out.println("\n------- Welcome to SBJ Bank --------");
        System.out.println("1. Create Account");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. Exit");
    }
    public static void showUserMenu() {
        System.out.println("\n------ Account Menu ------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. Mini Statement (Top 5)");
        System.out.println("7. Edit Account Details");
        System.out.println("8. Delete Account");
        System.out.println("9. Logout");
       
    }
}