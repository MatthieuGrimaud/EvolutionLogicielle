package org.anonbnr.design_patterns.oop.others.dependency_injection;

public interface Injectable<T> {
	void inject(T dependency);
}
