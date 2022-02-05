package com.revature.bankofandrew.menus;

import java.io.BufferedReader;

import com.revature.bankofandrew.services.CustomerService;
import com.revature.bankofandrew.util.MenuRouter;
import com.revature.bankofandrew.menus.Menu;

public class LoginMenu extends Menu {



	public LoginMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Login", "/login", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
System.out.println("Welcome to The Bank of Andrew! Please login");
		
		System.out.print("Email: ");
		String email = consoleReader.readLine();
		
		System.out.print("Password: ");
		String password = consoleReader.readLine();
		
		String userInput = "Submitted Email: " + email + "\nSubmitted Password: " + password;
		
		System.out.println(userInput);
	}

}