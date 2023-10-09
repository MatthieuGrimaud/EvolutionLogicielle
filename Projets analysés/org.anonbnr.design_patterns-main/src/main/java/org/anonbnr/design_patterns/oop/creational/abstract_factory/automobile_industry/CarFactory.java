package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Abstract Factory
public interface CarFactory {
    Engine createEngine();
    Wheels createWheels();
    Body createBody();
    default Car createCar() {
        return new Car(createEngine(), createBody(), createWheels());
    }
}
