package com.revature.bankDriver.models;

public class Customer {
	
	// attributes/variables
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	// constructor
	public Customer(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	
// getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//custom methods
	public String toFileString() {
		StringBuilder buildFileString = new StringBuilder();
		
		buildFileString.append(firstName).append(":")
		               .append(lastName).append(":")
		               .append(email).append(":")
		               .append(username).append(":")
		               .append(password);
		return buildFileString.toString();
	}

	

	public void printFromFile(String[] arr) {
		for(String arrV:arr) {
			System.out.println(arrV);
		}
		
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}

	
 }
