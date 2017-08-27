package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactory;

public class DBDAO implements DAO {

	@Override
	public int addUser(User user) {
		int id = -1;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "insert into users (firstname, lastname, username, pwd) values (?,?,?,?)";

			//to get back primary key
			String[] key = new String[1];
			key[0] = "userid";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql,key);
			//set values into sql string ?'s
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());

			//execute and get values
			int numRowsAdded = ps.executeUpdate();

			//results from keys
			ResultSet primaryKeys = ps.getGeneratedKeys();
			while(primaryKeys.next()){
				id = primaryKeys.getInt(1);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}

	public User getUser(int id) {
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users where"
					+ " userid = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setInt(1, id);

			
			//execute and get values
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getInt("userId"),rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("username"),rs.getString("pwd"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	
	@Override
	public User getUser(String usr, String pwd) {
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from users where"
					+ " username = ? AND "
					+ " pwd = ?";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setString(1, usr);
			ps.setString(2, pwd);

			
			//execute and get values
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getInt("userId"),rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("username"),rs.getString("pwd"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call updateUser(?,?,?,?) }";
			
			
			CallableStatement cs = conn.prepareCall(sql);
			//set second ? to findPerson for variable name
			cs.setString(1, user.getFirstname());
			cs.setString(2, user.getLastname());
			cs.setString(3, user.getPassword());
			cs.setInt(4, user.getId());
			//execute
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void deleteUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call deleteUser(?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, user.getId());
			//execute
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int addAccount(int userID, int typeID) {
		int id = -1;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "insert into account (userid,typeid) values (?,?)";

			//to get back primary key
			String[] key = new String[1];
			key[0] = "accountid";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql,key);
			//set values into sql string ?'s
			ps.setInt(1, userID);
			ps.setInt(2, typeID);

			//execute and get values
			ps.executeUpdate();

			//results from keys
			ResultSet primaryKeys = ps.getGeneratedKeys();
			while(primaryKeys.next()){
				id = primaryKeys.getInt(1);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;


	}

	@Override
	public Account getAccount(int accountID) {
		Account account = new Account();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from account where"
					+ " accountid = ? ";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setInt(1, accountID);

			
			//execute and get values
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				account = new Account(rs.getInt("accountId"),rs.getBigDecimal("balance"), rs.getInt("userID"), rs.getInt("typeID"));
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;

	}

	@Override
	public ArrayList<Account> getAccounts(int userID) {
		ArrayList<Account> accounts = new ArrayList<Account>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			conn.setAutoCommit(false);
			String sql = "select * from account where"
					+ " userid = ? ";

			//setup prepared with sql and allocate space for key
			PreparedStatement ps = conn.prepareStatement(sql);
			//set values into sql string ?'s
			ps.setInt(1, userID);

			
			//execute and get values
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Account account = new Account(rs.getInt("accountId"),rs.getBigDecimal("balance"), rs.getInt("userID"), rs.getInt("typeID"));
				accounts.add(account);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;

	}


	
	@Override
	public void updateAccount(Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call updateAccount(?,?) }";
			
			
			CallableStatement cs = conn.prepareCall(sql);
			//set second ? to findPerson for variable name
			cs.setBigDecimal(1,account.getBalance());
			cs.setInt(2, account.getAccountID());
			//execute
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAccount(Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{ call deleteAccount(?) }";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, account.getAccountID());
			//execute
			cs.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
