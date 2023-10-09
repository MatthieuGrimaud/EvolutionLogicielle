package org.anonbnr.design_patterns.oop.creational.factory.vehicles;

// Concrete Product
public class Truck implements Vehicle{
    @Override
    public void startEngine(){
        System.out.println("Truck engine started.");
    }
}