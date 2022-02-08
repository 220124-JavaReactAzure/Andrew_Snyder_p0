package com.revature.bankofandrew.menus;

import java.io.BufferedReader;
import com.revature.bankofandrew.exceptions.AuthenticationException;
import com.revature.bankofandrew.services.CustomerService;
import com.revature.bankofandrew.util.MenuRouter;
import com.revature.bankofandrew.menus.Menu;
import com.revature.bankofandrew.util.collections.List;
import com.revature.bankofandrew.models.Customer;

public class LoginMenu extends Menu {

    private final CustomerService customerService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Login", "/login", consoleReader, router);
		this.customerService = customerService;
	}

	@Override
	public void render() throws Exception {
System.out.println("Welcome to The Bank of Andrew! Please login");
		
		System.out.print("Username: ");
		String username = consoleReader.readLine();
		
		System.out.print("Password: ");
		String password = consoleReader.readLine();
		
		try {
			customerService.authenticateCustomer(username, password);
			router.transfer("/dashboard");
		} catch (AuthenticationException e) {
			System.out.println("Incorrect login info");
		}
	}

}