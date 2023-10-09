package org.anonbnr.design_patterns.oop.creational.builder.pizzas;

import java.util.ArrayList;
import java.util.List;

// Product
public class Pizza {
	private String crust;
	private String sauce;
	private String cheese;
	private List<String> toppings = new ArrayList<>();
	
	
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	public String getCheese() {
		return cheese;
	}
	public void setCheese(String cheese) {
		this.cheese = cheese;
	}
	public List<String> getToppings() {
		return toppings;
	}
	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}
	@Override
	public String toString() {
		return "Pizza [crust=" + crust + 
				", sauce=" + sauce + 
				", cheese=" + cheese + 
				", toppings=" + toppings + "]";
	}
}
