package com.aurionpro.abstraction.model;

public abstract class GameCharacter {
    protected String name;
    protected int powerLevel;

    public GameCharacter(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    public abstract void attack();

    public void displayStatus() {
        System.out.println(name + " Power Level: " + powerLevel);
    }
}
