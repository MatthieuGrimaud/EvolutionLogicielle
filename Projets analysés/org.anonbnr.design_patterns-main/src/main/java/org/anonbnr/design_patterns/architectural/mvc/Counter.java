package org.anonbnr.design_patterns.architectural.mvc;

/**
 * a concrete class that plays the role of a concrete Model
 * in the MVC architectural design pattern.<br><br>
 * It provides methods for incrementing and decrementing the counter value.
 * It notifies all associated counter views upon modification.
 * @author anonbnr
 * @see CounterView
 */
public class Counter extends Model {

	/* ATTRIBUTES */
	private int value = 0;

	/* METHODS */
	public int getValue() {return this.value;}
	public void increment() {this.changeValue(1);}
	public void decrement() {this.changeValue(-1);}

	protected void changeValue(int i) {
		value += i;
		this.notify("value");
	}
}