package org.anonbnr.design_patterns.oop.creational.builder.pizzas;

import java.util.Arrays;

// Concrete builder
public class MargheritaPizzaBuilder implements PizzaBuilder {
	
	private Pizza pizza = new Pizza();

	@Override
	public PizzaBuilder buildCrust() {
		pizza.setCrust("Thin");
		return this;
	}

	@Override
	public PizzaBuilder addSauce() {
		pizza.setSauce("Tomato");
		return this;
	}

	@Override
	public PizzaBuilder addCheese() {
		pizza.setCheese("Mozzarella");
		return this;
	}

	@Override
	public PizzaBuilder addToppings() {
		pizza.setToppings(Arrays.asList("Basil", "Black Olives"));
		return this;
	}

	@Override
	public Pizza build() {
		return pizza;
	}
}
