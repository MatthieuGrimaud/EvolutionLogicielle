package org.anonbnr.design_patterns.oop.structural.dao;

public class DAOFactory {
	/* METHODS */
	public static BankAccountDAODefaultImpl createBankAccountDAODefault() {
		return new BankAccountDAODefaultImpl();
	}
	
	public static CustomerDAODefaultImpl createCustomerDAODefault() {
		return new CustomerDAODefaultImpl();
	}
}
