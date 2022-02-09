package com.revature.bankofandrew.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.bankofandrew.models.Account;

import com.revature.bankofandrew.util.collections.LinkedList;
import com.revature.bankofandrew.util.collections.List;
import com.revature.bankofandrew.util.datasource.ConnectionFactory;




public class AccountDAO implements CrudDAO<Account> {

	

	public Account findByUsername(String username) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			
			String sql = "select * from account where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getString("account_id"));
				account.setUsername(rs.getString("username"));
				account.setBalance(rs.getDouble("balance"));
				
				return account;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
			
	
	@Override
	public Account create(Account newAccount) {
	
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				newAccount.setAccountId(UUID.randomUUID().toString());
	            String sql = "insert into account (username, account_id, balance) values (?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, newAccount.getUsername());
				pstmt.setString(2, newAccount.getAccountId());
				pstmt.setDouble(3, newAccount.getBalance());

				int rowsInserted = pstmt.executeUpdate();

				if (rowsInserted != 0) {
					return newAccount;
				}

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return null;
		}
    @Override
	public List<Account> findAll() {
		
		List<Account> accountList = new LinkedList<>();
		
		
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from account";
			Statement s = conn.createStatement();
			
				ResultSet resultSet = s.executeQuery(sql);{
			while(resultSet.next()) {
				Account account = new Account();
				account.setUsername(resultSet.getString("username"));
				account.setAccountId(resultSet.getString("accountId"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList.add(account);
		}
		return accountList;
				}
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return null;
			}
	

	
    public boolean update(Double updatedBalance, String AccountId) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update account set balance = ? where account_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, updatedBalance);
			ps.setString(2, AccountId);
			ps.executeUpdate();

			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		return false;
	}

	
	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean update(Double updatedBalance) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Account updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}


	


}
