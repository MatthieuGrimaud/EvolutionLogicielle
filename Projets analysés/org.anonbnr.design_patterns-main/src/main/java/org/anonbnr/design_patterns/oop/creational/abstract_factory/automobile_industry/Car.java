package org.anonbnr.design_patterns.oop.creational.abstract_factory.automobile_industry;

// Concrete Class
public class Car {
    private Engine engine;
    private Body body;
    private Wheels wheels;

    public Car(Engine engine, Body body, Wheels wheels){
        this.engine = engine;
        this.body = body;
        this.wheels = wheels;
    }

    public void start(){
        engine.start();
    }

    public void shape(){
        body.shape();
    }

    public void roll(){
        wheels.roll();
    }
}
