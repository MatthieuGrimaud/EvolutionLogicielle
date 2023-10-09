package org.anonbnr.design_patterns.oop.creational.abstract_factory.shapes_factory;

/**
 * a RoundedTriangle concrete class that plays the role of a specific 
 * ConcreteProduct in the Abstract Factory design pattern.
 * It defines the class of rounded triangle shapes.
 * @author anonbnr
 */
public class RoundedTriangle implements Shape {

	
	public void draw() {
		System.out.println("Drawing a rounded triangle");
	}
}
