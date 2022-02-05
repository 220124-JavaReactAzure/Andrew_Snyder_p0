package com.revature.bankofandrew.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.bankofandrew.daos.CustomerDAO;
import com.revature.bankofandrew.menus.RegisterMenu;
import com.revature.bankofandrew.menus.WelcomeMenu;
import com.revature.bankofandrew.menus.DashboardMenu;
import com.revature.bankofandrew.menus.LoginMenu;
import com.revature.bankofandrew.services.CustomerService;
import com.revature.bankofandrew.util.logging.Logger;

public class AppState {
	
	
	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		
		logger = Logger.getLogger(true);
		logger.log("Application initializing....");
		
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		CustomerDAO customerDAO = new CustomerDAO();
		CustomerService customerService = new CustomerService(customerDAO);
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router, customerService));
		router.addMenu(new LoginMenu(consoleReader, router, customerService));
		router.addMenu(new DashboardMenu(consoleReader, router, customerService));
		
		logger.log("Application initialized!");
	
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
