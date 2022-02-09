package com.revature.bankofandrew.services;

import com.revature.bankofandrew.models.Customer;
import com.revature.bankofandrew.util.collections.List;

import com.revature.bankofandrew.exceptions.AuthenticationException;

import com.revature.bankofandrew.daos.CustomerDAO;
import com.revature.bankofandrew.exceptions.InvalidRequestException;
import com.revature.bankofandrew.exceptions.ResourcePersistenceException;

public class CustomerService {

	private final CustomerDAO customerDao;
	private Customer sessionCustomer;
	
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDao = customerDAO;
		this.sessionCustomer = null;
	}
	

	public Customer getSessionCustomer() {
		return sessionCustomer;
	}
	
	public Customer registerNewCustomer(Customer newCustomer) {
		if(!isCustomerValid(newCustomer)) {
			throw new InvalidRequestException("Invalid user data provided");
		}

		boolean usernameAvailable = customerDao.findByUsername(newCustomer.getUsername()) == null;
		boolean emailAvailable = customerDao.findByEmail(newCustomer.getEmail()) == null;
		
		if(!usernameAvailable || !emailAvailable) {
			if(!usernameAvailable && emailAvailable) {
				throw new ResourcePersistenceException("The provided username was already taken in the database");
			} else if(usernameAvailable) {
				throw new ResourcePersistenceException("The provided email was already taken in the database");
			} else {
				throw new ResourcePersistenceException("The provided username and email were already taken in the database");
			}
		}
		
		Customer persistedCustomer = customerDao.create(newCustomer);
		
		if(persistedCustomer == null) {
			throw new ResourcePersistenceException("The customer could not be persisted");
		}
		
		return persistedCustomer;
	}
	
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();	
	}
	
	//TODO: Implement authentication
	public void authenticateCustomer(String username, String password) {
		
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
		}
		
		Customer authenticatedCustomer = customerDao.findByUsernameAndPassword(username, password);
		
		if(authenticatedCustomer == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found in our database.");
		}
		sessionCustomer = authenticatedCustomer;
	}

	public boolean isCustomerValid(Customer newCustomer) {
		if(newCustomer == null) return false;
		if(newCustomer.getFirstName() == null || newCustomer.getFirstName().trim().equals("")) return false;
		if(newCustomer.getLastName() == null || newCustomer.getLastName().trim().equals("")) return false;
		if(newCustomer.getEmail() == null || newCustomer.getEmail().trim().equals("")) return false;
		if(newCustomer.getUsername() == null || newCustomer.getUsername().trim().equals("")) return false;
		return newCustomer.getPassword() != null || !newCustomer.getPassword().trim().equals("");


	}
	
	public void logout() {
		sessionCustomer = null;
	}
	
	public boolean isSessionActive() {
		return sessionCustomer != null;
	}


	

	}
