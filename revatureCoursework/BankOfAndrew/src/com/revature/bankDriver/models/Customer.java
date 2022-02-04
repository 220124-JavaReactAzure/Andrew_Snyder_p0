package com.revature.bankDriver.models;
import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// attributes/variables
	private String customerId;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, customerId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(customerId, other.customerId) && Objects.equals(username, other.username);
	}
	
	
}
