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
		Double balance = Double.parseDouble(consoleReader.readLine());
		Account newAccount = new Account(balance);

		if (balance <= 0) {
			System.out.println("insufficient balance. Please try again");
			router.transfer("/account-creation");
		}

		AccountService.createdAccount(newAccount);
		System.out.println("Redirecting to Dashboard");
		router.transfer("/dashboard");
	}
}
