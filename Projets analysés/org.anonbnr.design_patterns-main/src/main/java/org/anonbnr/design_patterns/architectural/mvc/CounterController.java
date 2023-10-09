package org.anonbnr.design_patterns.architectural.mvc;

import java.awt.event.ActionEvent;

/**
 * a concrete class that plays the role of a concrete Controller
 * in the MVC architectural design pattern.<br><br>
 * It controls a corresponding Counter model. When its action command is "increment"
 * ("decrement" respectively), it increments (decrements respectively)
 * the counter's value.
 * @author anonbnr
 * @see Counter
 * @see CounterView
 */
public class CounterController extends Controller {

	/* CONSTRUCTORS */
	public CounterController(Counter model) {
		super(model);
	}

	/* METHODS */
	// implementation of ActionEvent
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("increment"))
			((Counter) model).increment();
		else if (e.getActionCommand().equals("decrement"))
			((Counter) model).decrement();
	}
}