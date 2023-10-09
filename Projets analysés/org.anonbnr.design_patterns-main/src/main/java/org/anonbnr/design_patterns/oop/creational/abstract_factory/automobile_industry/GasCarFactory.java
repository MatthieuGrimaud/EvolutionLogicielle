package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Factory 1
public class GasCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new GasEngine();
    }

    @Override
    public Wheels createWheels() {
        return new GasWheels();
    }

    @Override
    public Body createBody() {
        return new GasBody();
    }
}