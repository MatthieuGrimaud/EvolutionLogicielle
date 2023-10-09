package org.anonbnr.design_patterns.oop.others.dependency_injection;

public class InjectableClient extends Client implements Injectable<IDependency> {
	/* METHODS */
	@Override
	public void inject(IDependency dependency) {
		System.out.println("Interface Dependency Injection: ");
		this.dependency = dependency;
	}
}
