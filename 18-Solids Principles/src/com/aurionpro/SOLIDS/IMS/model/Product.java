package com.aurionpro.SOLIDS.IMS.model;

public class Product {
	private String name;
    private int quantity;
    private int reorderLevel;
    private double pricePerUnit;

    public Product(String name, int quantity, int reorderLevel, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getReorderLevel() { return reorderLevel; }
    public double getPricePerUnit() { return pricePerUnit; }
}
