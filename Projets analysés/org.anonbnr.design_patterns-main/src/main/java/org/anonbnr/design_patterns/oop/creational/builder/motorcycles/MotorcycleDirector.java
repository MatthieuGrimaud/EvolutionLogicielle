package org.anonbnr.design_patterns.oop.creational.builder.motorcycles;

// Director class that uses the builder to build the motorcycle object.
public class MotorcycleDirector {
    private MotorcycleBuilder builder;

    public MotorcycleDirector(MotorcycleBuilder builder) {
        this.builder = builder;
    }

    public Motorcycle build(){
        return builder.setModel("BMW")
                .setColor("Red")
                .setEngine("V8")
                .setTransmission("Automatic")
                .build();
    }
}