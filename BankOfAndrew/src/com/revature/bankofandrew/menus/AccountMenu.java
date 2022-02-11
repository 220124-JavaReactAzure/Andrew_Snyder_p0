package com.revature.bankofandrew.menus;

import java.io.BufferedReader;
import com.revature.bankofandrew.util.MenuRouter;

import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.services.AccountService;
import com.revature.bankofandrew.util.collections.List;

public class AccountMenu extends Menu {
	

		private final AccountService accountService;

		public AccountMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
			super("AccountMenu", "/balance", consoleReader, router);
			this.accountService = accountService;
		}

		
		    public void render() throws Exception {
		    	
		    	List<Account> userList;
		    	userList = accountService.findAllAccount();
		    	if(userList.size() == 0) {
		    		System.out.println("you don't have an account yet!");
		    		router.transfer("/dashboard");
		    	}
		    
		    	double balance = 0;
		    	String id = null;
		    	for (int i = 0; i < userList.size(); i++) {
		    		balance = userList.get(i).getBalance();
		    		id = userList.get(i).getAccountName();
		    	}
		    		System.out.println("Account ID:" + id + "\n");
		    		System.out.println("balance:" + balance + "\n");
		    		router.transfer("/dashboard");
		    	}
		}

