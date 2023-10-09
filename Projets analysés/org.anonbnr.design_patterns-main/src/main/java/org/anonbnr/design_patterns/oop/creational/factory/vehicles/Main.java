package org.anonbnr.design_patterns.oop.creational.factory.vehicles;

public class Main{
    public static void main(String[] args) {
        VehicleFactory factory = new CarFactory();
        Vehicle car = factory.createVehicle();
        car.startEngine(); // Output: Car engine started.

        factory = new TruckFactory();
        Vehicle truck = factory.createVehicle();
        truck.startEngine(); // Output: Truck engine started.
    }
}