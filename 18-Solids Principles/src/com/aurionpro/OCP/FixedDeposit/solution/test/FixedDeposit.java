package com.aurionpro.OCP.FixedDeposit.solution.test;

import com.aurionpro.OCP.FixedDeposit.violation.model.FestivalType;

public class FixedDeposit {
	private int accountNumber;
    private String name;
    private double principal;
    private int duration;
    private FestivalType festival;

    public FixedDeposit(int accountNumber, String name, double principal, int duration, FestivalType festival) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.principal = principal;
        this.duration = duration;
        this.festival = festival;
    }

    public double calculateSimpleInterest() {
        double rate = 0;

        switch (festival) {
            case NEWYEAR:
                rate = 8.0;
                break;
            case DIWALI:
                rate = 8.5;
                break;
            case HOLI:
                rate = 7.5;
                break;
            case OTHERS:
                rate = 6.5;
                break;
        }

        return (principal * duration * rate) / 100;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getPrincipal() { return principal; }
    public int getDuration() { return duration; }
    public FestivalType getFestival() { return festival; }
}
