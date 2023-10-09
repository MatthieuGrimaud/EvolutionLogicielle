package org.anonbnr.design_patterns.oop.creational.factory.enemies_game;

// Concrete flying enemy
public class FlyingEnemy implements Enemy{
    @Override
    public void attack() {
        System.out.println("Flying enemy attacks with ranged attacks");
    }

    @Override
    public void move() {
        System.out.println("Flying enemy moves in the sky");
    }
}
