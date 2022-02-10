package com.revature.bankofandrew.menus;

import java.io.BufferedReader;
import com.revature.bankofandrew.util.MenuRouter;

import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.services.AccountService;
import com.revature.bankofandrew.util.collections.List;

public class AccountMenu extends Menu {
	

		private final AccountService accountService;

		public AccountBalanceMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
			super("Account", "/balance", consoleReader, router);
			this.accountService = accountService;
		}

		
		    public void render() throws Exception {
		    	
		    	List<Account> userList;
		    	userList = accountService.findAllAccounts();
		    	if(userList.size() == 0) {
		    		System.out.println("you don't have an account yet!");
		    		router.transfer("/dashboard");
		    	}
		    
		    	String userSelection = consoleReader.readLine();
		    	switch(userSelection) {
		    	case "1":
		    		System.out.println(
		    	}
		    	
		    	System.out.println("Your balance is:");
		    	for (int i = 0; i < userList.size(); i++) {
		    		System.out.println(userList.get(i).getAccountName() + "\n" + userList.get(i).getBalance());
		    	}
		}
}
