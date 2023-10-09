package org.anonbnr.design_patterns.oop.creational.factory.enemies_game;

// Concrete flying enemy creator
public class FlyingEnemyFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new FlyingEnemy();
    }
}
