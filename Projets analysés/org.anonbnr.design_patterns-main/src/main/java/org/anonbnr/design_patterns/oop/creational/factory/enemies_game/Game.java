package org.anonbnr.design_patterns.oop.creational.factory.enemies_game;

public class Game {
    public static void main(String[] args) {
        // Create an instance of the FlyingEnemyFactory
        EnemyFactory enemyFactory = new FlyingEnemyFactory();

        // Use the factory to create a FlyingEnemy object
        Enemy flyingEnemy = enemyFactory.createEnemy();

        // Call the attack and move methods of the FlyingEnemy object
        flyingEnemy.attack();
        flyingEnemy.move();

        // Create an instance of the GroundEnemyFactory
        enemyFactory = new GroundEnemyFactory();

        // Use the factory to create a GroundEnemy object
        Enemy groundEnemy = enemyFactory.createEnemy();

        // Call the attack and move methods of the GroundEnemy object
        groundEnemy.attack();
        groundEnemy.move();

        // Create an instance of the WaterEnemyFactory
        enemyFactory = new WaterEnemyFactory();

        // Use the factory to create a WaterEnemy object
        Enemy waterEnemy = enemyFactory.createEnemy();

        // Call the attack and move methods of the WaterEnemy object
        waterEnemy.attack();
        waterEnemy.move();
    }
}
