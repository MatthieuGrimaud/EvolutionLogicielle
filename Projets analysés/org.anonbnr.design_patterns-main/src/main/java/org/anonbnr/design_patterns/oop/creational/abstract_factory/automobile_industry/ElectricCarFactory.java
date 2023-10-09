package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Factory 2
public class ElectricCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }

    @Override
    public Wheels createWheels() {
        return new ElectricWheels();
    }

    @Override
    public Body createBody() {
        return new ElectricBody();
    }
}