package org.anonbnr.design_patterns.oop.structural.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAODefaultImpl implements DAO<Customer> {
	/* ATTRIBUTES */
	private List<Customer> customers;
	
	/* CONSTRUCTORS */
	public CustomerDAODefaultImpl() {
		customers = new ArrayList<>();
		customers.add(new Customer("1", "John", "Doe"));
		customers.add(new Customer("2", "Jane", "Doe"));
		customers.add(new Customer("3", "Tom", "Cruise"));
		customers.add(new Customer("4", "John", "Cena"));
		customers.add(new Customer("5", "Keanu", "Reeves"));
		customers.add(new Customer("6", "Angelina", "Jolie"));
		customers.add(new Customer("7", "Keira", "Knightley"));
		customers.add(new Customer("8", "Johnny", "Depp"));
		customers.add(new Customer("9", "Brad", "Pit"));
		customers.add(new Customer("10", "Jessica", "Alba"));
	}

	/* METHODS */
	@Override
	public Customer create(Customer model) {
		if (customers.add(model))
			System.out.println("Successfully created " + model);
		else
			System.err.println("Error: couldn't create " + model);
		
		return model;
	}

	@Override
	public Optional<Customer> findById(int id) {
		return customers.stream()
				.filter(customer -> customer.getId() == id)
				.findFirst();
	}
	
	public Optional<Customer> findByNumber(String number) {
		return customers.stream()
				.filter(customer -> customer.getNumber().equals(number))
				.findFirst(); 
	}

	@Override
	public List<Customer> findAll() {
		return customers;
	}

	@Override
	public Optional<Customer> update(int id, Customer newModel) {
		Optional<Customer> target = customers.stream()
				.filter(customer -> customer.getId() == id)
				.findFirst();
		if (target.isPresent()) {
			target.get().setFirstName(newModel.getFirstName());
			target.get().setLastName(newModel.getLastName());
			target.get().setNumber(newModel.getNumber());
			System.out.println("Successfully updated customer with ID: " 
					+ id);
			System.out.println(newModel);
			return target;
		}
		else {
			System.err.println("Error: couldn't find customer with ID: " 
					+ id);
			return Optional.empty();
		}
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		Optional<Customer> target = customers.stream()
				.filter(customer -> customer.getId() == id)
				.findFirst();
		if (target.isPresent())
			result = customers.remove(target.get());
		else {
			System.err.println("Error: couldn't find customer with ID: "
					+ id);
			result = false;
		}
		
		if (result)
			System.out.println("Successfully removed customer with ID: " 
					+ id);
		
		return result;
	}
}
