package org.anonbnr.design_patterns.oop.structural.dao;

import java.util.Objects;

public class BankAccount {
	/* ATTRIBUTES */
	private int id;
	private static int idCounter = 1;
	private String number;
	private double credit;
	
	/* CONSTRUCTORS */
	public BankAccount() {
		id = idCounter++;
	}

	public BankAccount(String number, double credit) {
		this();
		this.number = number;
		this.credit = credit;
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

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(credit, id, number);
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
		BankAccount other = (BankAccount) obj;
		return Double.doubleToLongBits(credit) == 
				Double.doubleToLongBits(other.credit) 
				&& id == other.id
				&& Objects.equals(number, other.number);
	}

	// toString
	@Override
	public String toString() {
		return "BankAccount [number=" + number + 
				", credit=" + credit + "]";
	}
	
	// business logic
	public void credit(double amount) {
		if (amount > 0) {
			credit += amount;
			System.out.println("Successfully added funds to account");
			System.out.println("Current credit: " + credit);
		}
		else
			System.err.println("Error: strictly positive amount expected, "
					+ "received " + amount);
	}
	
	public void debit(double amount) {
		if (amount <= credit) {
			credit -= amount;
			System.out.println("Successfully debited funds from account");
			System.out.println("Current credit: " + credit);
		}
		else
			System.err.println("Error: insufficient funds:" +
					"\nCurrent credit: " + credit + 
					", requested amount: " + amount);
	}
}
