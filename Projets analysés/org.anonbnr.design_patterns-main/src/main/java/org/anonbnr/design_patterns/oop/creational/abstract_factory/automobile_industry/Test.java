package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

public class Test {
    public static void main(String[] args) {
        CarFactory factory = new GasCarFactory();
        Car car = factory.createCar();

        car.shape(); // Output: Gas Body shaped.
        car.start(); // Output: Gas Engine started.
        car.roll(); // Output: Gas Wheels rolling.

        factory = new ElectricCarFactory();
        car = factory.createCar();

        car.shape(); // Output: Electric Body shaped.
        car.start(); // Output: Electric Engine started.
        car.roll(); // Output: Electric Wheels rolling.
    }
}
