package com.aurionpro.abstraction.test;

import com.aurionpro.abstraction.model.Archer;
import com.aurionpro.abstraction.model.GameCharacter;
import com.aurionpro.abstraction.model.Warrior;

public class GameSimulationTest {
    public static void main(String[] args) {
        GameCharacter[] characters = new GameCharacter[2];
        characters[0] = new Warrior("Thor", 100);
        characters[1] = new Archer("Legolas", 80);

        System.out.println("--- Initial Power Levels ---");
        for (GameCharacter c : characters) {
            c.displayStatus();
        }

        // Simulate 2 rounds of attack
        for (int round = 1; round <= 2; round++) {
            System.out.println("\n--- Round " + round + " ---");
            for (GameCharacter c : characters) {
                c.attack();
                c.displayStatus();
            }
        }
    }
}
