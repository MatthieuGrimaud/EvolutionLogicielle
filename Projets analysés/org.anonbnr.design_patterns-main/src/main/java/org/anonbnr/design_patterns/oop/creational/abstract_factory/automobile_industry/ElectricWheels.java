package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Product B2
public class ElectricWheels implements Wheels{
    @Override
    public void roll() {
        System.out.println("Electric Wheels rolling.");
    }
}
