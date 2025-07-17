package com.aurionpro.abstraction.model;

public class Circle extends Shape {
    public Circle() {
        super("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle...");
    }
}
