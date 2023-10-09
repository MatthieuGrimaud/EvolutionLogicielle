package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Product A1
public class GasEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Gas Engine started.");
    }
}
