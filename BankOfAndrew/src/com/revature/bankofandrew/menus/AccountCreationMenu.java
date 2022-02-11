package com.revature.bankofandrew.menus;

import java.io.BufferedReader;

import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.models.Customer;
import com.revature.bankofandrew.services.AccountService;
import com.revature.bankofandrew.services.CustomerService;
import com.revature.bankofandrew.util.MenuRouter;

public class AccountCreationMenu extends Menu {

	private final AccountService accountService;
    private final CustomerService customerService;
	public AccountCreationMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService, CustomerService customerService) {
		super("AccountCreation", "/account-creation", consoleReader, router);
		this.accountService = accountService;
		this.customerService = customerService;
	
	}

	@Override
	public void render() throws Exception {
		Customer sessionCustomer = customerService.getSessionCustomer();
		System.out.println("Account Creator\n" + "Fill out the info below");

		System.out.println("1 - Account Name");
		String accountName = consoleReader.readLine();
		System.out.println("2 - Starting Balance Deposit");
		String balanceString = consoleReader.readLine();
		double balance = Double.valueOf(balanceString);
		

		while (!(balanceString.matches("[0-9]+") && balanceString.length() >= 1)) {
			System.out.println("invalid entry. Please try again");
			System.out.println("Starting Balance Deposit");
			balanceString = consoleReader.readLine();
			

		}
        System.out.println("Starting balance:" + balance);
        balance = Double.valueOf(balanceString);
		Account newAccount = new Account(accountName, balance, sessionCustomer);
        
        accountService.createAccount(newAccount);
	
		System.out.println("Redirecting to Dashboard");
		router.transfer("/dashboard");
	}
}
