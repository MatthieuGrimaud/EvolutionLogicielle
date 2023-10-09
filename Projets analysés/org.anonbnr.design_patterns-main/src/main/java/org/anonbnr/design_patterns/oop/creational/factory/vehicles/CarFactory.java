package org.anonbnr.design_patterns.oop.creational.factory.vehicles;

// Concrete Creator
public class CarFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(){
        return new Car();
    }
}