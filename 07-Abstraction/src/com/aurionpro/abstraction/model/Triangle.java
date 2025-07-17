package com.aurionpro.abstraction.model;

public class Triangle extends Shape {
    public Triangle() {
        super("Triangle");
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle...");
    }
}
