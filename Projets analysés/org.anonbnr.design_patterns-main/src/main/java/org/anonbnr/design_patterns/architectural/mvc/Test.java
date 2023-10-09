package org.anonbnr.design_patterns.architectural.mvc;

/**
 * a test class for the MVC architectural design pattern
 * @author anonbnr
 */
public class Test {

	public static void main(String[] args) {
		Counter counter = new Counter();
		CounterView counterView = new CounterView(counter,
				new CounterController(counter));

		counterView.open();
	}
}