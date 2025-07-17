package com.aurionpro.enumeration.model;

import java.util.Scanner;

public class TicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Ticket Booking System ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("\nChoose Ticket Type:");
        System.out.println("1. REGULAR ($100)");
        System.out.println("2. VIP ($200)");
        System.out.println("3. PREMIUM ($300)");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();

        TIcketType ticketType;
        switch (choice) {
            case 1:
                ticketType = TIcketType.REGULAR;
                break;
            case 2:
                ticketType = TIcketType.VIP;
                break;
            case 3:
                ticketType = TIcketType.PREMIUM;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to REGULAR.");
                ticketType = TIcketType.REGULAR;
        }

        Ticket ticket = new Ticket(name, ticketType);
        ticket.displayTicketInfo();

        System.out.println("\nConfirm your booking?");
        System.out.println("1. Confirm");
        System.out.println("2. Cancel");
        System.out.print("Enter choice (1-2): ");
        int confirmChoice = scanner.nextInt();

        switch (confirmChoice) {
            case 1:
                ticket.confirmBooking();
                break;
            case 2:
                ticket.cancelBooking();
                break;
            default:
                System.out.println("Invalid input. Booking remains pending.");
        }

        ticket.displayTicketInfo();
        scanner.close();
    }
}

