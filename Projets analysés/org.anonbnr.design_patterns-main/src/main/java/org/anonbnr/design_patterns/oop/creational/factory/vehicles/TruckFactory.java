package org.anonbnr.design_patterns.oop.creational.factory.vehicles;

// Concrete Creator
public class TruckFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(){
        return new Truck();
    }
}