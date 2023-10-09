package org.anonbnr.design_patterns.oop.creational.builder.motorcycles;

// Motorcycle class with attributes such as model, color, engine, and transmission.
public class Motorcycle {
    private String model;
    private String color;
    private String engine;
    private String transmission;

    public String getModel(){
        return model;    
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Model: " + model
            + "\nColor: " + color
            + "\nEngine: " + engine
            + "\nTransmission: " + transmission;
    }
}