package com.revature.bankDriver.daos;




import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankDriver.models.Customer;
import com.revature.bankDriver.util.collections.List;

	public Customer findByUsernameAndPassword(String username, String password) {
	
	public class CustomerDAO implements CrudDAO<Customer> {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from customers where username = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));

				return customer;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public Customer findByUsername(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from customers where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));

				return customer;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Customer create(Customer newCustomer) {
		
	}
	try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

		newCustomer.setCustomerId(UUID.randomUUID().toString());
		

		String sql = "insert into customer (customer_id, first_name, last_name, email, username, password) values (?, ?, ?, ?, ?, ?)";
		

		PreparedStatement ps = conn.prepareStatement(sql);
		

		ps.setString(1, newCustomer.getCustomerId());
		ps.setString(2, newCustomer.getFirstName());
		ps.setString(3, newCustomer.getLastName());
		ps.setString(4, newCustomer.getEmail());
		ps.setString(5, newCustomer.getUsername());
		ps.setString(6, newCustomer.getPassword());
		
		int rowsInserted = ps.executeUpdate();
		
		if (rowsInserted != 0) {
			return newCustomer;
		}
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return null;
	}


	@Override
	public List<Customer> findAll() {

		List<Customer> customerList = new LinkedList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from customers";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
					Customer customer = new Customer();
					customer.setCustomerId(rs.getString("customer_id"));
					customer.setFirstName(rs.getString("first_name"));
					customer.setLastName(rs.getString("last_name"));
					customer.setEmail(rs.getString("email"));
					customer.setUsername(rs.getString("username"));
					customer.setPassword(rs.getString("password"));

					return customer;
				}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}



}




