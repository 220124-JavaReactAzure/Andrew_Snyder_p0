package com.revature.bankofandrew.menus;

import java.io.BufferedReader;

import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.services.AccountService;
import com.revature.bankofandrew.util.MenuRouter;
import com.revature.bankofandrew.util.collections.List;

public class TransactionsMenu extends Menu{
	
	private final AccountService accountService;
	public TransactionsMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("Account", "/account", consoleReader, router);
		this.accountService = accountService;
		
	}

	@Override
	public void render() throws Exception {
		
		
		List<Account> userList;	
		userList = AccountService.findAllAccounts();
		if(userList.size() == 0) {
			System.out.println("You don't have an account!");
			 router.transfer("/dashboard");
		}

		System.out.println("Are you making a deposit or withdrawal?");
		String menu = "1) Deposit\n" +
					  "2) Withdrawal\n" +
				      "3) Check Balance\n";
		
		System.out.println(menu);
		
		String userSelection = consoleReader.readLine();

		switch (userSelection) {
		case "1":
			System.out.println("Make a deposit...");
			router.transfer("/deposit");
			break;
		case "2":
			System.out.println("Make a withdrawal...");
			router.transfer("/withdrawal");
			break;
		case "3":
			System.out.println("Check your Balance...");
			router.transfer("/balance");
			break;
		default:
			System.out.println("invalid selection, please choose 1, 2, or 3");
		}
		
	}

}