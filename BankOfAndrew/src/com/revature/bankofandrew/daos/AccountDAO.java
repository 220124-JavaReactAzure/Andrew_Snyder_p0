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

	

	public Account findByAccountName(String accountName) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			
			String sql = "select * from account where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountName);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getString("account_id"));
				account.setAccountName(rs.getString("account_name"));
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
	            String sql = "insert into account (account_id, account_name, balance, owner_id) values (?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, newAccount.getAccountName());
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
				account.setAccountName(resultSet.getString("account_name"));
				account.setAccountId(resultSet.getString("account_id"));
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
	

	
    public boolean update(String accountId, Double newBalance) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update account set balance = ? where account_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newBalance);
			ps.setString(2, accountId);
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
	public boolean update(Account updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}


	


}
