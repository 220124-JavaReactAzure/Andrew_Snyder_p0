package com.revature.bankofandrew.menus;

import java.io.BufferedReader;
import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.models.Customer;
import com.revature.bankofandrew.services.AccountService;
import com.revature.bankofandrew.services.CustomerService;
import com.revature.bankofandrew.util.collections.List;
import com.revature.bankofandrew.util.MenuRouter;

public class DepositMenu extends Menu {

	private final AccountService accountService;
	private final CustomerService customerService;

	public DepositMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService,
			CustomerService customerService) {
		super("Deposit", "/deposit", consoleReader, router);
		this.accountService = accountService;
		this.customerService = customerService;
	}

	public void render() throws Exception {

		Customer sessionCustomer = customerService.getSessionCustomer();
		Account currentAccount = null;
		List<Account> userList;
		userList = accountService.findAllAccount();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getOwner().getCustomerId().equals(sessionCustomer.getCustomerId())) {
				currentAccount = userList.get(i);

			}
		}

		if (userList.size() == 0) {
			System.out.println("you don't have an account yet!");
			router.transfer("/dashboard");
		}
		double balance = 0;
		if (currentAccount != null) {
			 balance = currentAccount.getBalance();
		}

		System.out.println("Your balance is " + balance);
		System.out.println("Enter the amount to deposit");

		double addBalance = Double.parseDouble(consoleReader.readLine());
		if (addBalance < 0) {
			System.out.println(" invalid deposit");
			router.transfer("/deposit");

		}
		balance += addBalance;
		currentAccount.setBalance(balance);
		System.out.println("Withdrawing" + addBalance + "from your account");
		System.out.println("Your new balance is:" + balance);

		accountService.updateBalance(currentAccount);
		router.transfer("/dahsboard");
	}
		}

