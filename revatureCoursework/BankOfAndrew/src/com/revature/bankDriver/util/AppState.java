package com.revature.bankDriver.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.bankDriver.daos.CustomerDAO;
import com.revature.bankDriver.menus.RegisterMenu;
import com.revature.bankDriver.menus.WelcomeMenu;
import com.revature.bankDriver.menus.DashboardMenu;
import com.revature.bankDriver.menus.LoginMenu;
import com.revature.bankDriver.services.CustomerService;

public class AppState {
	
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		CustomerDAO customerDAO = new CustomerDAO();
		CustomerService customerService = new CustomerService(customerDAO);
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router));
		router.addMenu(new LoginMenu(consoleReader, router, customerService));
		router.addMenu(new DashboardMenu(consoleReader, router, customerService));
	
	}
	
public void startup() {
	try {
	while(isRunning) {
		router.transfer("/welcome");
	}
} catch (Exception e) {
	e.printStackTrace();
}
}

public static void shutdown() {
	isRunning = false;
}
}
