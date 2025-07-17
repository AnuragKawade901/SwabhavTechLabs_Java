package com.aurionpro.abstraction.model;

public class Square extends Shape {
    public Square() {
        super("Square");
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square...");
    }
}
