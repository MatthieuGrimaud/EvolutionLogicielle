package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Product B1
public class GasWheels implements Wheels{
    @Override
    public void roll() {
        System.out.println("Gas Wheels rolling.");
    }
}
