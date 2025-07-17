package com.aurionpro.enumeration.model;

public class ElectricityBill {
    private int apartmentNumber;
    private int unitsConsumed;
    private static double costPerUnit = 7.0; // Default rate

    public ElectricityBill(int apartmentNumber, int unitsConsumed) {
        this.apartmentNumber = apartmentNumber;
        this.unitsConsumed = unitsConsumed;
    }

    public double calculateBill() {
        return unitsConsumed * costPerUnit;
    }

    public static void setCostPerUnit(double newRate) {
        costPerUnit = newRate;
    }

    public static void displayCurrentRate() {
        System.out.println("Current Cost per Unit: ₹" + costPerUnit);
    }

    public void displayBill() {
        System.out.println("Apartment No: " + apartmentNumber);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Bill Amount: ₹" + calculateBill());
        System.out.println("-----------------------------");
    }
}
