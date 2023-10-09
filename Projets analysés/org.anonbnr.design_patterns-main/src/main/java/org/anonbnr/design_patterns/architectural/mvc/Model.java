package org.anonbnr.design_patterns.architectural.mvc;

import java.util.Iterator;

/**
 * an abstract class that plays the role of Model in
 * the MVC architectural design pattern.<br><br>
 * It provides a default notification mechanism for all associated views.
 * It uses MVAssociation for the subscription mechanism
 * @author anonbnr
 * @see MVAssociation
 */
public abstract class Model {

	/* METHODS */
	public void notify(Object how) {
		Iterator<View> it = MVAssociation.getViews(this).iterator();

		while(it.hasNext())
			it.next().update(how);
	}
}