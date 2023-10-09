package org.anonbnr.design_patterns.architectural.mvc;

/**
 * an abstract class that plays the role of View in
 * the MVC architectural design pattern.<br><br>
 * It provides a constructor to indicate which model it is representing,
 * and which controller is being used to interact with its model.
 * It provides an interface for the self-updating behavior,
 * and the self-displaying behavior.
 * @author anonbnr
 */
public abstract class View {

	/* ATTRIBUTES */
	protected Controller controller;
	protected Model model;

	/* CONSTRUCTOR */
	public View() {}

	public View(Model model, Controller controller) {		
		this.controller = controller;
		this.model = model;
		MVAssociation.add(model, this);
	}

	/* METHODS */
	public abstract void update(Object how);
	public abstract void open();
}