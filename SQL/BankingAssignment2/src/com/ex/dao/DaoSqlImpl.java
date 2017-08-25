package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import java.util.Date;

import com.bank.pojos.*;
import com.ex.util.ConnectionFactory;

// NOTE: SQL is 1-indexed rather than 0-indexed

public class DaoSqlImpl implements DaoSql {
	
	public String getFormatedDate(Date day) {
		String result = "";
		
		result += day.getYear() + '-';
		result += day.getMonth() + '-';
		result += day.getDay();
		
		return result;
	}
	
	public ArrayList<Example> getAll() {
		ArrayList<Example> whateverFloatsYourBoat = new ArrayList<Example>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT * from example";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int song_id = rs.getInt(4);

				whateverFloatsYourBoat.add(new Example(id, firstName, lastName, song_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return whateverFloatsYourBoat;
	}

	public ArrayList<Example> getAllWithTitle() {
		ArrayList<Example> whateverFloatsYourBoat = new ArrayList<Example>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "SELECT ex.ex_id, ex.firstname, ex.lastname, tr.name" + 
					" FROM example ex" + 
					" LEFT JOIN track tr" + 
					" ON ex.favorite_song_id = tr.trackid";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				Example exp = new Example();
				exp.setId(rs.getInt(1));
				exp.setFirstName(rs.getString(2));
				exp.setLastName(rs.getString(3));
				exp.setSongName(rs.getString(4));

				whateverFloatsYourBoat.add(exp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return whateverFloatsYourBoat;
	}

	public Person createPerson(int SSN, String firstName, String lastName, Date birthDate) {
		Person per = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);

			// No semi-colon inside the quotes
			String sql = "INSERT INTO person(ssn, first_name, last_name, email, birth_date, deceased)" + 
					" VALUES(?, ?, ?, ?, TO_DATE(?,'yyyy-mm-dd'), ?)";
			String[] key = new String[1];
			key[0] = "ex_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, SSN);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, null);
			ps.setString(5, getFormatedDate(birthDate));
			ps.setInt(6, 0);		// false

			// executeUpdate() returns the number of rows updated
			ps.executeUpdate();
			
			per = new Person(SSN, firstName, lastName, birthDate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return per;

	}

	@Override
	public Person readPerson(int SSN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean readPerson(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePerson(Person per) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(String SSN, boolean erase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Person> readAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// FIXME Dont take in a user, return a user
	public BankUser createBankUser(Person per, String username, String password) {
		BankUser guy = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO bank_user(username, password, ssn) VALUES(?, ?, ?)";
			String[] key = new String[1];
			key[0] = "user_id";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, guy.getUsername());
			ps.setString(2, guy.getPassword());
			ps.setInt(3, guy.getSSN());
			
			ps.executeUpdate();
			
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next())
				id = pk.getInt(1);
			
			guy = new BankUser(per, id, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return guy;
		
	}

	@Override
	public BankUser readBankUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankUser readBankUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBankUser(BankUser guy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBankUser(int userId, boolean erase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<BankUser> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	// FIXME Don't take in an account, return an account
	public Account createAccount(BankUser guy) {
		Account acc = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);

			// FIXME sql statement
			String sql = "INSERT INTO account()" + 
					" VALUES()";
			String[] key = new String[1];
			key[0] = "account_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, per.getSSN());
			ps.setString(2, per.getFirstName());
			ps.setString(3, per.getLastName());
			ps.setString(4, per.getEmail());
			ps.setString(5, getFormatedDate(per.getBirthDate()));
			ps.setInt(6, per.isDeceased()?1:0);

			// executeUpdate() returns the number of rows updated
			ps.executeUpdate();
			
			Integer id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next())
				id = pk.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Something went wrong
		return acc;

	}

	@Override
	public Person readAccount(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Account acc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int accountId, boolean erase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Person> readAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


}
