package org.anonbnr.design_patterns.oop.creational.builder.motorcycles;

public class Test {
    public static void main(String[] args) {
        MotorcycleBuilder builder = new MotorcycleBuilderImpl();
        MotorcycleDirector director = new MotorcycleDirector(builder);
        Motorcycle motorcycle = director.build();

        System.out.println(motorcycle);
    }
}
