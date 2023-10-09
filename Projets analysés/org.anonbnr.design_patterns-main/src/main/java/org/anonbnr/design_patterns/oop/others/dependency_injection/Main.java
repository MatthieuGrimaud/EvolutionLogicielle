package org.anonbnr.design_patterns.oop.others.dependency_injection;

public class Main {

	public static void main(String[] args) {
		Client client = Injector
				.serveWithConstructorInjection();
		System.out.println(client.getCustomerName(1));
		System.out.println();
		// Constructor Dependency Injection: 
		// Name of customer with ID 1
		
		client = Injector
				.serveWithSetterInjection();
		System.out.println(client.getCustomerName(15));
		System.out.println();
		// Setter Dependency Injection: 
		// Name of customer with ID 1
		
		client = Injector
				.serveWithInterfaceInjection();
		System.out.println(client.getCustomerName(120));
		// Interface Dependency Injection: 
		// Name of customer with ID 1
	}
}