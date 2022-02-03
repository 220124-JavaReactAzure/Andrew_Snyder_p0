package com.revature.bankDriver.services;

import com.revature.bankDriver.models.Customer;
import com.revature.bankDriver.daos.CustomerDAO;
import com.revature.bankDriver.exceptions.InvalidRequestException;

public class CustomerService {
	
	public boolean registerNewCustomer(Customer newCustomer) {
		if( !isCustomerValid(newCustomer)) {
			throw new RuntimeException("Invalid user data provider");
			throw new InvalidRequestException("Invalid user data provider");
		}

		// TODO: Write logic that verifies the new users information isn't duplicated int he system
		customerDAO.create(newCustomer);


		return true;
	}

	//TODO: Implement authentication
	public Customer autenticateCustomer(String username, String password) {
		return null;
	}

	public boolean isCustomerValid(Customer newCustomer) {
		if(newCustomer == null) return false;
		if(newCustomer.getFirstName() == null || newCustomer.getFirstName().trim().equals("")) return false;
		if(newCustomer.getLastName() == null || newCustomer.getLastName().trim().equals("")) return false;
		if(newCustomer.getEmail() == null || newCustomer.getEmail().trim().equals("")) return false;
		if(newCustomer.getUsername() == null || newCustomer.getUsername().trim().equals("")) return false;
		return newCustomer.getPassword() != null || !newCustomer.getPassword().trim().equals("");


	}

}