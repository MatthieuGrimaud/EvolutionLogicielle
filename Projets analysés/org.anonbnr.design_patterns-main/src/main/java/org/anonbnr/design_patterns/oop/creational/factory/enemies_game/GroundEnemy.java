package org.anonbnr.design_patterns.oop.creational.factory.enemies_game;

// Concrete ground enemy
public class GroundEnemy implements Enemy{

    @Override
    public void attack() {
        System.out.println("Ground enemy attacks with melee attacks.");
    }

    @Override
    public void move() {
        System.out.println("Ground enemy moves on the ground.");
    }
}