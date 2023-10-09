package org.anonbnr.design_patterns.oop.creational.abstract_factory.shapes_factory;

/**
 * a Rectangle concrete class that plays the role of a specific 
 * ConcreteProduct in the Abstract Factory design pattern.
 * It defines the class of rectangle shapes.
 * @author anonbnr
 */
public class Rectangle implements Shape {

	
	public void draw() {
		System.out.println("Drawing a rectangle");
	}
}
