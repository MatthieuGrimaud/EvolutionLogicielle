package org.anonbnr.design_patterns.oop.structural.dao;

import java.util.List;
import java.util.Optional;

public class Test {

	public static void main(String[] args) {
		// seeing all bank accounts and all customers
		DAO<BankAccount> bankDAO = DAOFactory.createBankAccountDAODefault();
		List<BankAccount> accounts = bankDAO.findAll();
		displayAllBankAccounts(accounts);
		
		DAO<Customer> customerDAO = DAOFactory.createCustomerDAODefault();
		List<Customer> customers = customerDAO.findAll();
		displayAllCustomers(customers);
		
		// get a customer by id
		System.out.println("Getting customer having ID 1");
		Optional<Customer> customer = customerDAO.findById(1);
		if (customer.isPresent()) {
			System.out.println(customer.get());
			System.out.println();
		}
		
		// get a bank account by id
		System.out.println("Getting bank having Number 3");
		Optional<BankAccount> bankAccount = 
				((BankAccountDAODefaultImpl) bankDAO).findByNumber("3");
		
		if (bankAccount.isPresent()) {
			System.out.println(bankAccount.get());
			System.out.println();
		}
		
		// add bank account to customer's accounts
		
		if (customer.isPresent() && bankAccount.isPresent()) {
			customer.get().addBankAccount(bankAccount.get());
			
			// update customer via DAO
			customerDAO.update(customer.get().getId(), customer.get());
			System.out.println();
		}
		
		// create new customer
		Customer travolta = new Customer("11", "John", "Travolta");
		
		// create new bank account
		BankAccount account = new BankAccount("11", 1200);
		
		// add bank account to customer
		travolta.addBankAccount(account);
		
		// insert bank account via DAO
		bankDAO.create(account);
		System.out.println();
		
		// insert customer via DAO
		customerDAO.create(travolta);
		System.out.println();
		
		// all bank accounts and all customers
		accounts = bankDAO.findAll();
		displayAllBankAccounts(accounts);
		
		customers = customerDAO.findAll();
		displayAllCustomers(customers);
		
		// delete customer and his bank accounts
		travolta.getBankAccounts().forEach(acc -> bankDAO.delete(acc.getId()));
		customerDAO.delete(travolta.getId());
		System.out.println();
		
		// all bank accounts and all customers
		accounts = bankDAO.findAll();
		displayAllBankAccounts(accounts);
		
		customers = customerDAO.findAll();
		displayAllCustomers(customers);
		
	}
	
	private static void displayAllBankAccounts(List<BankAccount> accounts) {
		System.out.println("Bank Accounts");
		System.out.println("=============");
		accounts.forEach(System.out::println);
		System.out.println();
	}
	
	private static void displayAllCustomers(List<Customer> customers) {
		System.out.println("Customers");
		System.out.println("=========");
		customers.forEach(System.out::println);
		System.out.println();
	}
}
