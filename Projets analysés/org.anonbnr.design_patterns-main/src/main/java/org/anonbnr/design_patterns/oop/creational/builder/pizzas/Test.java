package org.anonbnr.design_patterns.oop.creational.builder.pizzas;

public class Test {

	public static void main(String[] args) {
		PizzaBuilder builder = new MargheritaPizzaBuilder();
		PizzaDirector chef = new PizzaDirector(builder);
		Pizza pizza = chef.makePizza();
		System.out.println(pizza);
	}
}
