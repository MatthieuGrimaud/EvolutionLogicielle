package org.anonbnr.design_patterns.oop.creational.factory.enemies_game;

// Concrete water enemy creator
public class WaterEnemyFactory extends EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new WaterEnemy();
    }
}
