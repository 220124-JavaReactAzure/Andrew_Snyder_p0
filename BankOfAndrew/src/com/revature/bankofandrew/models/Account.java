package com.revature.bankofandrew.models;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	// attributes/variables

	private Customer owner;
	private String accountId;
	private String username;
	private double balance;

	// constructor

	public Account() {
		super();
	}

	public Account(Double balance) {
		super();
		this.balance = balance;

	}

	public Account(String username, String accountId, Double balance) {
		super();
		this.username = username;
		this.accountId = accountId;
		this.balance = balance;

	}

	// getters and setters

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	// custom methods
	public String toFileString() {
		StringBuilder buildFileString = new StringBuilder();

		buildFileString.append(username).append(":").append(accountId).append(":").append(balance);

		return buildFileString.toString();
	}

	public void printFromFile(String[] arr) {
		for (String arrV : arr) {
			System.out.println(arrV);
		}

	}

	@Override
	public String toString() {
		return "Account [username=" + username + ",accountId=" + accountId + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, accountId, balance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(username, other.username) && Objects.equals(accountId, other.accountId)
				&& Objects.equals(balance, other.balance);

	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Customer getOwner() {
		return owner;

	}
}
