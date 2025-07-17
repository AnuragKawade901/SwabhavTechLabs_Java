package com.aurionpro.abstraction.model;

public class CommerceStudent extends Student {
    private int accounts, economics, business;

    public CommerceStudent(int rollNumber, String name, int accounts, int economics, int business) {
        super(rollNumber, name);
        this.accounts = accounts;
        this.economics = economics;
        this.business = business;
    }

    @Override
    public double calculateAverage() {
        return (accounts + economics + business) / 3.0;
    }

    @Override
    public String calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else return "D";
    }
}
