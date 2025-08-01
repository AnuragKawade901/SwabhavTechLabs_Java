package com.aurionpro.BankMP.model;

import java.util.Scanner;

public class CustomerService {
    private Scanner sc = new Scanner(System.in);
    private CustomerDAO customerDAO = new CustomerDAO();

    public void startMenu(AccountService accountService, TransactionService transactionService) {
        while (true) {
            System.out.println("\n\uD83C\uDFE6 Welcome to SBJ Bank");
            System.out.println("1. Create Account\n2. Login\n3. Exit");
            System.out.println("Enter :-");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> customerDAO.createCustomer(accountService);
                case 2 -> customerDAO.login(accountService, transactionService);
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid Option");
            }
        }
    }
}