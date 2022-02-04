package com.revature.bankDriver.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.bankDriver.exceptions.InvalidRequestException;
import com.revature.bankDriver.models.Customer;



public class CustomerServiceTestSuite {
	
	CustomerService sut;
	
	@Before
	public void testPrep() {
		sut = new CustomerService();
	}
	
	@Test
	public void test_isCustomerValid_returnsTrue_givenValidUser() {
		
		// Arrange
		Customer validCustomer = new Customer("valid","valid","valid","valid","valid");
		
		// Act
		boolean actualResult = sut.isCustomerValid(validCustomer);
		
		// Assert
		Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void test_isCustomerValid_returnsFalse_givenUserWithFirstName() {
		
		// Arrange
		Customer invalidCustomer1 = new Customer("","valid","valid","valid","valid");
		Customer invalidCustomer2 = new Customer(null,"valid","valid","valid","valid");
		Customer invalidCustomer3 = new Customer("         ","valid","valid","valid","valid");
		
		
		//Act
		boolean actualResult1 = sut.isCustomerValid(invalidCustomer1);
		boolean actualResult2 = sut.isCustomerValid(invalidCustomer2);
		boolean actualResult3 = sut.isCustomerValid(invalidCustomer3);
		
		//Assert - everything you assert must pass the condition
		Assert.assertFalse(actualResult1);
		Assert.assertFalse(actualResult2);
		Assert.assertFalse(actualResult3);
		
	}
	
	//TODO: Figure out implementation
	@Test
	public void test_registerCustomer_returnsTrue_givenValidCustomer() {
		
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerCustomer_throwsInvalidRequestException_givenInvalidUser() {
		sut.registerNewCustomer(null);
	}
}