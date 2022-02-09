package com.revature.bankofandrew.menus;

import java.io.BufferedReader;

import com.revature.bankofandrew.models.Customer;
import com.revature.bankofandrew.services.CustomerService;
import com.revature.bankofandrew.util.MenuRouter;

public class DashboardMenu extends Menu {

	private final CustomerService customerService;

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Dashboard", "/dashboard", consoleReader, router);
		this.customerService = customerService;
	}

	@Override
	public void render() throws Exception {

		Customer sessionCustomer = customerService.getSessionCustomer();

		if (sessionCustomer == null) {
			System.out.println("You are not logged in! Returning to login screen...");
			router.transfer("/login");
			return;
		}

		while (customerService.isSessionActive()) {
			System.out.println("Welcome " + sessionCustomer.getUsername());
			String menu = "1) create a bank account\n" + 
					"2) view balance\n" +
					"3) make a deposit/withdrawal\n" + 
					"4) Logout\n" + 
					 "> ";

			System.out.print(menu);

			String userSelection = consoleReader.readLine();

			switch (userSelection) {
			case "1":
				System.out.println("Create Bank name and make initial deposit");
				router.transfer("/account-creation");
				break;
			case "2":
				System.out.println("view balance");
				router.transfer("/view-balance");
				break;
			case "3":
				System.out.println("make a deposit/withdrawal");
				router.transfer("/transactions");
				break;
			case "4":
				customerService.logout();
				break;
			default:
				System.out.println("The user made an invalid selection");
			}
		}
	}

}