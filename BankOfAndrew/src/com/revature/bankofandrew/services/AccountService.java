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
	
	// TODO: Account Creation implementation
	public void createAccount(Account newAccount) {
		if(!isAccountValid(newAccount)) {
			throw new InvalidRequestException("invalid information");
		}
		
		newAccount.setOwner(customerService.getSessionCustomer());
		Account createdAccount = accountDAO.create(newAccount);
		
		if(createdAccount == null) {
			throw new ResourcePersistenceException("could not be persisted");
		}
	}
		
	
		
	public boolean updateBalance(double updatedBalance) {
		return AccountDAO.update(updatedBalance);
	}

	
	private boolean isAccountValid(Account newAccount) {
		if(newAccount == null) return false;
		return (newAccount.getBalance()!=null && newAccount.getBalance() > 0);
	}
	
		public List<Account> findMyAccount(){
			return null;
		}
		
		public List<Account> findAllAccount(){
			return null;
		}

	}