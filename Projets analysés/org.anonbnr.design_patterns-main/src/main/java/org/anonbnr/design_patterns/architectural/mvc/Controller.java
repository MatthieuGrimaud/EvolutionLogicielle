package org.anonbnr.design_patterns.architectural.mvc;

import java.awt.event.ActionListener;

/**
 * an abstract class that plays the role of Controller
 * in the MVC architectural design pattern.<br><br>
 * It provides a constructor to indicate which model is controlled
 * by it.<br>
 * It implements the ActionListener interface to define the proper
 * controlling behavior of its model upon the triggering of a specific event.
 * @author anonbnr
 */
public abstract class Controller implements ActionListener {

	/* ATTRIBUTES */
	protected Model model;

	/* CONSTRUCTOR */
	public Controller() {}
	public Controller(Model model) {
		this.model = model;
	}
}