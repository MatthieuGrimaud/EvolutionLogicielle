package org.anonbnr.design_patterns.oop.creational.builder.motorcycles;

// Builder interface that specifies the methods for setting the attributes of the Motorcycle class.
public interface MotorcycleBuilder {
    MotorcycleBuilder setModel(String model);
    MotorcycleBuilder setColor(String color);
    MotorcycleBuilder setEngine(String engine);
    MotorcycleBuilder setTransmission(String transmission);
    Motorcycle build();
}
