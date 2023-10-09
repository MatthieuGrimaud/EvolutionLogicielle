package org.anonbnr.design_patterns.oop.creational.abstract_factory.shapes_factory;

/**
 * a RoundedRectangle concrete class that plays the role of a specific 
 * ConcreteProduct in the Abstract Factory design pattern.
 * It defines the class of rounded rectangle shapes.
 * @author anonbnr
 */
public class RoundedRectangle implements Shape {

	
	public void draw() {
		System.out.println("Drawing a rounded rectangle");
	}
}
