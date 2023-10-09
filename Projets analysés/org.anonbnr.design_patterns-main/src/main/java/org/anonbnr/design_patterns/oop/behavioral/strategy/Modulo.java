package org.anonbnr.design_patterns.oop.behavioral.strategy;

/**
 * a Modulo class that plays the role of ConcreteStrategy in the Strategy design pattern.
 * it implements the arithmetic operation of modulo.
 * @author anonbnr
 */
public class Modulo implements ArithmeticOperation {

	/**
	 * Returns x % y.
	 */
	
	public int execute(int x, int y) {
		
		return x % y;
	}
}
