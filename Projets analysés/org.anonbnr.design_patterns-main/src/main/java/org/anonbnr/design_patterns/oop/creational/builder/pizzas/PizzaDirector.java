package org.anonbnr.design_patterns.oop.creational.builder.pizzas;

// Director
public class PizzaDirector {
	private PizzaBuilder builder;
	
	public PizzaDirector(PizzaBuilder builder) {
		this.builder = builder;
	}
	
	public Pizza makePizza() {
		return builder.buildCrust()
			.addSauce()
			.addCheese()
			.addToppings()
			.build();
	}
}
