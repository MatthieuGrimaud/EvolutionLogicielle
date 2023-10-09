package org.anonbnr.design_patterns.oop.creational.builder.motorcycles;

// Concrete builder class that implements the builder interface and sets the attributes of the Motorcycle class.
public class MotorcycleBuilderImpl implements MotorcycleBuilder {

    private Motorcycle motorcycle;

    public MotorcycleBuilderImpl(){
        motorcycle = new Motorcycle();
    }

    @Override
    public MotorcycleBuilder setModel(String model) {
        motorcycle.setModel(model);
        return this;
    }

    @Override
    public MotorcycleBuilder setColor(String color) {
        motorcycle.setColor(color);
        return this;
    }

    @Override
    public MotorcycleBuilder setEngine(String engine) {
        motorcycle.setEngine(engine);
        return this;
    }

    @Override
    public MotorcycleBuilder setTransmission(String transmission) {
        motorcycle.setTransmission(transmission);
        return this;
    }

    @Override
    public Motorcycle build() {
        return motorcycle;
    }
}
