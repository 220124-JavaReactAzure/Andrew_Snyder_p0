package com.revature.bankDriver.menus;

import java.io.BufferedReader;
import com.revature.bankDriver.exceptions.InvalidRequestException;
import com.revature.bankDriver.models.Customer;
import com.revature.bankDriver.services.CustomerService;
import com.revature.bankDriver.util.MenuRouter;

public class RegisterMenu extends Menu {

	CustomerService customerService;


		public RegisterMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Register", "/register", consoleReader, router);
		this.customerService = customerService;
	}


	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("The User selected Register");

		// Things to obtain from user: first name, last name, email, username, password

		System.out.println("Please provided us with some basic information");
		
		
		System.out.print("First Name: ");
		String firstName = consoleReader.readLine();

		System.out.print("Last Name: ");
		String lastName = consoleReader.readLine();

		System.out.print("Email: ");
		String email = consoleReader.readLine();

		System.out.print("Username: ");
		String username = consoleReader.readLine();

		System.out.print("Password: ");
		String password = consoleReader.readLine();

//		System.out.printf("Provided by user: firstName: %s, lastName: %s, email: %s, username: %s, password: %s", firstName, lastName, email, username, password).println();

		Customer customer = new Customer(firstName, lastName, email, username, password);

		System.out.printf("Provided by user: %s\n", customer.toString()).println();

		try {
			customerService.registerNewCustomer(customer);
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 
			System.out.println("YOU HAVE PROVIDED INVALID DATA PLEASE TRY AGAIN\n\n\n");

			router.transfer("/welcome");
		}
	}

}