package org.anonbnr.design_patterns.architectural.mvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

/**
 * a class that associates a collection of views to a model
 * in a dictionary. It, therefore, plays the role of a subscription manager
 * @author anonbnr
 */
public class MVAssociation {

	/* ATTRIBUTES */
	private static Map<Model, Collection<View>> dictionary = new Hashtable<>();

	/* METHODS */
	public static void add(Model m, View v) {
		if (!dictionary.containsKey(m))
			dictionary.put(m, new ArrayList<>());

		if (!dictionary.get(m).contains(v))
			dictionary.get(m).add(v);
	}

	public static boolean remove(Model m, View v) {
		if (dictionary.containsKey(m))
			return dictionary.get(m).remove(v);

		return false;
	}

	public static Collection<View> getViews(Model m) {
		return dictionary.get(m);
	}
}