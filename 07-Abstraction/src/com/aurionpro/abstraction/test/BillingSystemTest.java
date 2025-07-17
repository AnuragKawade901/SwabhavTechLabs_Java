package com.aurionpro.abstraction.test;

import java.util.Scanner;

import com.aurionpro.abstraction.model.CommercialCustomer;
import com.aurionpro.abstraction.model.Customer;
import com.aurionpro.abstraction.model.ResidentialCustomer;

public class BillingSystemTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer[] customers = new Customer[3];

        for (int i = 0; i < customers.length; i++) {
            System.out.println("Enter details for customer " + (i + 1));
            
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter units consumed: ");
            int units = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter type (residential/commercial): ");
            String type = scanner.nextLine().trim().toLowerCase();

            if (type.equals("residential")) {
                customers[i] = new ResidentialCustomer(name, units);
            } else if (type.equals("commercial")) {
                customers[i] = new CommercialCustomer(name, units);
            } else {
                System.out.println("Invalid type, defaulting to residential.");
                customers[i] = new ResidentialCustomer(name, units);
            }

            System.out.println();
        }

        System.out.println("---- BILL SUMMARY ----");
        for (Customer customer : customers) {
            customer.displayBill();
        }

        scanner.close();
    }
}
