package com.revature.bankofandrew.models;




public class Account {

	
	// attributes/variables

	private Customer owner;
	private String AccountName;
	private Double Balance;

	// constructor

	public Account() {
		super();
	}


	
	public Account(String accountName, Double balance, Customer owner) {
		super();
		 AccountName = accountName;
		Balance = balance;
		this.owner = owner;

	}
	public Account(String accountName, Double balance) {
		super();
		AccountName = accountName;
		this.Balance = balance;

	}

	// getters and setters

	public Account(String accountName, String balance) {
		// TODO Auto-generated constructor stub
	}





	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		this.Balance = balance;
	}


	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Customer getOwner() {
		return owner;

	}


	public String getAccountName() {
		return AccountName;
	}


	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
}
