package org.anonbnr.design_patterns.oop.others.dependency_injection;

public class Injector {
	/* CONSTRUCTORS */
	private Injector() {
		
	}
	
	/* METHODS */
	// Dependency Injection by constructor (default)
	public static Client serveWithConstructorInjection() {
		return new Client(new Dependency());
	}
	
	// Dependency Injection by constructor (parameterized)
	public static Client serveWithConstructorInjection(
			IDependency dependency) {
		return new Client(dependency);
	}
	
	// Dependency Injection by setter (default)
	public static Client serveWithSetterInjection() {
		Client client = new Client();
		client.setCustomerDataAccess(new Dependency());
		return client;
	}
	
	// Dependency Injection by setter (parameterized)
	public static Client serveWithSetterInjection(
			IDependency dependency) {
		Client client = new Client();
		client.setCustomerDataAccess(dependency);
		return client;
	}
	
	// Dependency Injection by injectable interface (default)
	public static Client serveWithInterfaceInjection() {
		InjectableClient client = new InjectableClient();
		client.inject(new Dependency());
		return client;
	}
	
	// Dependency Injection by injectable interface (parameterized)
	public static Client serveWithInterfaceInjection(
			IDependency dependency) {
		InjectableClient client = new InjectableClient();
		client.inject(dependency);
		return client;
	}
}