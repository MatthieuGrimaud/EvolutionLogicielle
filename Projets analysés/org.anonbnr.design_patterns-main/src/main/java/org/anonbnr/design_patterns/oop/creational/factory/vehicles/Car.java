package org.anonbnr.design_patterns.oop.creational.factory.vehicles;

// Concrete Product
public class Car implements Vehicle {
    @Override
    public void startEngine(){
        System.out.println("Car engine started.");
    }
}