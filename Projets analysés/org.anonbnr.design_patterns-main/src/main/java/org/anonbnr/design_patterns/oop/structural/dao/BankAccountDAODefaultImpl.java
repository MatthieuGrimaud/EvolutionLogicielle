package org.anonbnr.design_patterns.oop.structural.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankAccountDAODefaultImpl implements DAO<BankAccount> {
	/* ATTRIBUTES */
	private List<BankAccount> accounts;
	
	/* CONSTRUCTORS */
	public BankAccountDAODefaultImpl() {
		accounts = new ArrayList<>();
		accounts.add(new BankAccount("1", 50));
		accounts.add(new BankAccount("2", 100));
		accounts.add(new BankAccount("3", 250));
		accounts.add(new BankAccount("4", 200));
		accounts.add(new BankAccount("5", 500));
		accounts.add(new BankAccount("6", 10));
		accounts.add(new BankAccount("7", 1000));
		accounts.add(new BankAccount("8", 1500));
		accounts.add(new BankAccount("9", 800));
		accounts.add(new BankAccount("10", 700));
	}

	@Override
	public BankAccount create(BankAccount model) {
		if (accounts.add(model))
			System.out.println("Successfully created " + model);
		else
			System.err.println("Error: couldn't create " + model);
		
		return model;
	}

	@Override
	public Optional<BankAccount> findById(int id) {
		return accounts.stream()
				.filter(customer -> customer.getId() == id)
				.findFirst();
	}
	
	public Optional<BankAccount> findByNumber(String number) {
		return accounts.stream()
				.filter(account -> account.getNumber().equals(number))
				.findFirst(); 
	}

	@Override
	public List<BankAccount> findAll() {
		return accounts;
	}

	@Override
	public Optional<BankAccount> update(int id, BankAccount newModel) {
		Optional<BankAccount> target = accounts.stream()
				.filter(account -> account.getId() == id)
				.findFirst();
		if (target.isPresent()) {
			target.get().setNumber(newModel.getNumber());
			target.get().setCredit(newModel.getCredit());
			System.out.println("Successfully updated bank account with ID: " 
					+ id);
			System.out.println(newModel);
			return target;
		}
		else {
			System.err.println("Error: couldn't find bank account with ID: " 
					+ id);
			return Optional.empty();
		}
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		Optional<BankAccount> target = accounts.stream()
				.filter(account -> account.getId() == id)
				.findFirst();
		if (target.isPresent())
			result = accounts.remove(target.get());
		else {
			System.err.println("Error: couldn't find bank account with ID: "
					+ id);
			result = false;
		}
		
		if (result)
			System.out.println("Successfully removed bank account with ID: " 
					+ id);
		
		return result;
	}
}
