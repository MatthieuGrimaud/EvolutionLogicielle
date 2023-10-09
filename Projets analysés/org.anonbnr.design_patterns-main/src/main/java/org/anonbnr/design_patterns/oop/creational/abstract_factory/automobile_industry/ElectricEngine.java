package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Product A2
public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Electric Engine started.");
    }
}