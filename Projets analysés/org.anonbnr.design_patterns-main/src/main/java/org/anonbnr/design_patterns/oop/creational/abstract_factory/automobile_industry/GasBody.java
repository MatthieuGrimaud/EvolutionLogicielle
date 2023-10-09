package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Product C1
public class GasBody implements Body{
    @Override
    public void shape() {
        System.out.println("Gas Body shaped.");
    }
}
