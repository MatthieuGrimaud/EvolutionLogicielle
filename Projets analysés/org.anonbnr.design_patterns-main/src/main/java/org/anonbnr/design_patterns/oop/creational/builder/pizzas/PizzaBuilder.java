package org.anonbnr.design_patterns.oop.creational.builder.pizzas;

// Builder interface
public interface PizzaBuilder {
	PizzaBuilder buildCrust();
	PizzaBuilder addSauce();
	PizzaBuilder addCheese();
	PizzaBuilder addToppings();
	Pizza build();
}
