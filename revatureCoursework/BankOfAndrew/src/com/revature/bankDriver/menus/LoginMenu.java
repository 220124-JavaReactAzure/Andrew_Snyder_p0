package com.revature.bankDriver.menus;

import java.io.BufferedReader;

import com.revature.bankDriver.services.CustomerService;
import com.revature.bankDriver.util.MenuRouter;

public class LoginMenu extends Menu {



	public LoginMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Login", "/login", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
