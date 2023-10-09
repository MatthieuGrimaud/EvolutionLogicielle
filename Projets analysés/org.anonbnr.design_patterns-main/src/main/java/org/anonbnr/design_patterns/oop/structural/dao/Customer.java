package org.anonbnr.design_patterns.oop.structural.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
	/* ATTRIBUTES */
	private int id;
	private static int idCounter = 1;
	private String number;
	private String firstName;
	private String lastName;
	private List<BankAccount> accounts;
	
	/* CONSTRUCTORS */
	public Customer() {
		id = idCounter++;
		accounts = new ArrayList<>();
	}

	public Customer(String number, String firstName, String lastName) {
		this();
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/* METHODS */
	// Getters & Setters
	public int getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<BankAccount> getBankAccounts(){
		return accounts;
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(accounts, firstName, id, lastName, number);
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accounts, other.accounts) 
				&& Objects.equals(firstName, other.firstName) 
				&& id == other.id
				&& Objects.equals(lastName, other.lastName) 
				&& Objects.equals(number, other.number);
	}

	// toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [number=")
				.append(number)
				.append(", firstName=")
				.append(firstName)
				.append(", lastName=")
				.append(lastName)
				.append("]");
		
		if (!accounts.isEmpty()) {
			builder.append("\nAccounts:\n");
			accounts.forEach(account -> builder.append(account+"\n"));
		}
		
		return builder.toString();
	}
	
	// business logic
	public boolean addBankAccount(BankAccount account) {
		return accounts.add(account);
	}
	
	public double totalCredit() {
		return accounts.stream()
				.mapToDouble(BankAccount::getCredit)
				.sum();
	}
}
