package org.anonbnr.design_patterns.oop.others.dependency_injection;

public class Client {
	/* ATTRIBUTES */
	protected IDependency dependency;
	
	/* CONSTRUCTORS */
	public Client() { 
		dependency = new Dependency();
	}
	
	// Interface for Dependency Injection by Constructor
	public Client(IDependency dependency) {
		System.out.println("Constructor Dependency Injection: ");
		this.dependency = dependency;
	}
	
	/* METHODS */
	public String getCustomerName(int id) {
		return dependency.getCustomerName(id);
	}
	
	// Interface for Dependency Injection by Setter Method
	public void setCustomerDataAccess(IDependency dependency) {
		System.out.println("Setter Dependency Injection: ");
		this.dependency = dependency;
	}
}
