package org.anonbnr.design_patterns.oop.creational.factory.enemies_game;

// Concrete ground enemy creator
public class GroundEnemyFactory extends EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new GroundEnemy();
    }    
}
