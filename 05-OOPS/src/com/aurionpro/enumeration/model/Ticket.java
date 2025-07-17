package com.aurionpro.enumeration.model;

public class Ticket {
    private String customerName;
    private TIcketType ticketType;
    private BookingStatus bookingStatus;

    public Ticket(String customerName, TIcketType ticketType) {
        this.customerName = customerName;
        this.ticketType = ticketType;
        this.bookingStatus = BookingStatus.PENDING;
    }

    public void confirmBooking() {
        bookingStatus = BookingStatus.CONFIRMED;
    }

    public void cancelBooking() {
        bookingStatus = BookingStatus.CANCELLED;
    }

    public void displayTicketInfo() {
        System.out.println("\n----- Ticket Details -----");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Price: $" + ticketType.getPrice());
        System.out.println("Booking Status: " + bookingStatus);
    }
}
