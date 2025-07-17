package com.aurionpro.enumeration.model;

public enum TIcketType {
    REGULAR(100),
    VIP(200),
    PREMIUM(300);

    private final int price;

    TIcketType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

