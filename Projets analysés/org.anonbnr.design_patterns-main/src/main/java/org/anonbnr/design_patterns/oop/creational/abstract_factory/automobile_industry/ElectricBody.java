package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Product C2
public class ElectricBody implements Body{
    @Override
    public void shape() {
        System.out.println("Electric Body shaped.");
    }
}
