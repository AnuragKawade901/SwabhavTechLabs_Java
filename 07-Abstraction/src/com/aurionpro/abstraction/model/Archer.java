package com.aurionpro.abstraction.model;

public class Archer extends GameCharacter {

    public Archer(String name, int powerLevel) {
        super(name, powerLevel);
    }

    @Override
    public void attack() {
        powerLevel -= 5;
        if (powerLevel < 0) powerLevel = 0;
        System.out.println(name + " shoots an arrow! (-5 power)");
    }
}