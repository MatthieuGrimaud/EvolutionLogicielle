package org.anonbnr.design_patterns.oop.behavioral.strategy;

/**
 * a Multiply class that plays the role of ConcreteStrategy in the Strategy design pattern.
 * it implements the arithmetic operation of binary integer multiplication.
 * @author anonbnr
 */
public class Multiply implements ArithmeticOperation {
	
	/**
	 * Returns x * y.
	 */
	
	public int execute(int x, int y) {
		return x * y;
	}
}
