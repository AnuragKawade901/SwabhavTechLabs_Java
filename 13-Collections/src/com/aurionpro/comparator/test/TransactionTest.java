package com.aurionpro.comparator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.comparator.model.Transaction;
import com.aurionpro.comparator.model.TransactionComparator;

public class TransactionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();

        System.out.print("Enter number of transactions: ");
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) throw new IllegalArgumentException("Number must be positive.");
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Try again: ");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for transaction " + (i + 1) + ":");

            int id;
            while (true) {
                System.out.print("Transaction ID: ");
                try {
                    id = Integer.parseInt(scanner.nextLine());
                    if (id < 0) throw new IllegalArgumentException("ID must be non-negative.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a valid integer.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            double amount;
            while (true) {
                System.out.print("Amount: ");
                try {
                    amount = Double.parseDouble(scanner.nextLine());
                    if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative.");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a valid number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            transactions.add(new Transaction(id, amount));
        }

        // Sort transactions by amount descending, fallback to ID ascending
        transactions.sort(new TransactionComparator());

        System.out.println("\n--- Sorted Transaction List ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        scanner.close();
    }
}
