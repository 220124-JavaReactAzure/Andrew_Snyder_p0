package com.revature.bankofandrew.menus;

import java.io.BufferedReader;

import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.services.AccountService;
import com.revature.bankofandrew.util.MenuRouter;

public class AccountCreationMenu extends Menu {

	private final AccountService accountService;

	public AccountCreationMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("AccountCreation", "/account-creation", consoleReader, router);
		this.accountService = accountService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		System.out.println("Account Creator\n" + "Fill out the info below");

		System.out.println("1 - Account Name");
		String accountName = consoleReader.readLine();
		System.out.println("2 - Starting Balance Deposit");
		double balance = Double.parseDouble(consoleReader.readLine());
		

		while (!(balance.matches("[0-9]+") && balance.length() >= 1)) {
			System.out.println("invalid entry. Please try again");
			System.out.println("Starting Balance Deposit");
			balance = consoleReader.readLine();
			

		}
Account newAccount = new Account(accountName, balance);
	
		System.out.println("Redirecting to Dashboard");
		router.transfer("/dashboard");
	}
}
