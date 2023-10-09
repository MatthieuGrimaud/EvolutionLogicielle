package org.anonbnr.design_patterns.oop.others.dependency_injection;

public class Dependency implements IDependency {
	
	/* CONSTRUCTOR */
	public Dependency() {
		
	}

	/* METHODS */
	@Override
	public String getCustomerName(int id) {
		return String.format("Name of customer with ID %d", id);
	}
}
