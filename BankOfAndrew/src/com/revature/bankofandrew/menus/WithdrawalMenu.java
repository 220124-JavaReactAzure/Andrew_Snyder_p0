package com.revature.bankofandrew.menus;

import java.io.BufferedReader;
import com.revature.bankofandrew.util.MenuRouter;

import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.services.AccountService;
import com.revature.bankofandrew.util.collections.List;

public class WithdrawalMenu extends Menu {

	private final AccountService accountService;

	public WithdrawalMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("Withdraw", "/withdrawal", consoleReader, router);
		this.accountService = accountService;
	}

	public void render() throws Exception {

		List<Account> userList;
		userList = accountService.findAllAccounts();

		if (userList.size() == 0) {
			System.out.println("you don't have an account yet!");
			router.transfer("/dashboard");
		}
	

	
		String newId;
		double balance;

		for (int i = 0; i < userList.size(); i++)
			balance = userList.get(i).getBalance();
		newId = userList.get(i).getAccountId();

		System.out.println("Your balance is " + String.format("%2f", balance));
		System.out.println("Enter the amount to withdraw");
		String userSelection = consoleReader.readLine();
		while (userSelection.contains("-")) {
			System.out.println("please enter a positive number");
			System.out.println("Enter the amount to withraw");
			userSelection = consoleReader.readLine();
			balance = (balance - Double.parseDouble(userSelection));
		}
		
        balance = balance - Double.parseDouble(userSelection);
		
		System.out.println("Your new balance is " + String.format("%.2f", balance));
		
		accountService.newBalance(newId, balance);
	}
}
