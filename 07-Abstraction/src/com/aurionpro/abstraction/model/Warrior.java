package com.aurionpro.abstraction.model;

public class Warrior extends GameCharacter {

    public Warrior(String name, int powerLevel) {
        super(name, powerLevel);
    }

    @Override
    public void attack() {
        powerLevel -= 10;
        if (powerLevel < 0) powerLevel = 0;
        System.out.println(name + " attacks with a sword! (-10 power)");
    }
}
