package org.anonbnr.design_patterns.oop.creational.factory.enemies_game;

// Concrete water enemy
public class WaterEnemy implements Enemy {

    @Override
    public void attack() {
        System.out.println("Water enemy attacks with water-based attacks.");
    }

    @Override
    public void move() {
        System.out.println("Water enemy moves in water.");
    }
}
