package org.anonbnr.design_patterns.oop.creational.abstract_factory.shapes_factory;

/**
 * a RoundedShapeFactory concrete class that plays the role of a specific 
 * ConcreteFactory in the Abstract Factory design pattern.
 * It defines a factory for the creation of rounded shapes.
 * @author anonbnr
 */
public class RoundedShapeFactory extends AbstractShapeFactory {

	
	public Shape createShape(ShapeType shapeType) {
		
		if (shapeType == RoundedShapeType.ROUNDED_RECTANGLE)
			return new RoundedRectangle();
		
		else if (shapeType == RoundedShapeType.ROUNDED_TRIANGLE)
			return new RoundedTriangle();
		
		return null;
	}
}
