package com.revature.bankofandrew.services;

import com.revature.bankofandrew.daos.AccountDAO;
import com.revature.bankofandrew.exceptions.InvalidRequestException;
import com.revature.bankofandrew.exceptions.ResourcePersistenceException;
import com.revature.bankofandrew.models.Account;
import com.revature.bankofandrew.util.collections.List;

public class AccountService {
	private AccountDAO accountDAO = new AccountDAO();
	private final CustomerService customerService;

	public AccountService(CustomerService customerService, AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
		this.customerService = customerService;
	}

	public void createAccount(Account newAccount) {
		if (!isAccountValid(newAccount)) {
			throw new InvalidRequestException("invalid information");
		}

		newAccount.setOwner(customerService.getSessionCustomer());
		Account createdAccount = accountDAO.create(newAccount);

		if (createdAccount == null) {
			throw new ResourcePersistenceException("could not be persisted");
		}
	}

	private boolean isAccountValid(Account newAccount) {

		if (newAccount == null)
			return false;
		if (newAccount.getAccountName() == null || newAccount.getAccountName().trim().equals(""))
			return false;
		if (String.valueOf(newAccount.getBalance()) == null || String.valueOf(newAccount.getBalance()).trim().equals("")
				|| newAccount.getBalance() < 0)
			return false;
		return true;
	}

	public boolean newBalance(String updatedAccount, double newBalance) {
		return accountDAO.update(updatedAccount, newBalance);
	}

	public List<Account> findMyAccount() {
		return null;
	}

	public List<Account> findAllAccount() {
		return null;
	}

	public List<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}