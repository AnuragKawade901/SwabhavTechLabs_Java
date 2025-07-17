package com.aurionpro.abstraction.model;

public abstract class Shape {
    protected String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public abstract void draw();
}
