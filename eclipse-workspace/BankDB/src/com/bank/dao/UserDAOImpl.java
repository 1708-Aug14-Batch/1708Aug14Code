package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.model.User;
import com.bank.util.ConnectionSingleton;

/**
 * Concrete implementation of UserDAO.
 * @author Will Underwood
 */
public class UserDAOImpl implements UserDAO<User> {

	/**
	 * Inserts a new user into the database.
	 * @precondition User cannot be null
	 * @param user - the User to be inserted
	 * @return The id of the inserted user / or zero if failure
	 */
	@Override
	public int createUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO bankuser(user_id, firstname, lastname, email, password) VALUES(DEFAULT, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "user_id";
			PreparedStatement statement = conn.prepareStatement(sql, key);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.executeUpdate();
			int id = 0;
			ResultSet returnedKeys = statement.getGeneratedKeys();
			while(returnedKeys.next()) {
				id = returnedKeys.getInt(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Returns all user data from the database.
	 * @precondition None
	 * @param None
	 * @return A collection of all users
	 */
	@Override
	public ArrayList<User> readAllUsers() {
		ArrayList<User> allUsers = new ArrayList<User>();
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM bankuser";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet results = statement.executeQuery(sql);
			while(results.next()) {
				int id = results.getInt("user_id");
				String firstName = results.getString("firstname");
				String lastName = results.getString("lastname");
				String email = results.getString("email");
				String password = results.getString("password");
				boolean hasChecking = (0 != results.getInt("has_checking"));
				boolean hasSavings = (0 != results.getInt("has_savings"));
				boolean enabled = (0 != results.getInt("enabled"));
				User user = new User();
				user.setUserID(id);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setHasChecking(hasChecking);
				user.setHasSavings(hasSavings);
				user.setEnabled(enabled);
				allUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

	/**
	 * Returns the data of a single user from the database
	 * @precondition ID cannot be less than 1.
	 * @param id - The ID of the desired user
	 * @return The user whose ID was specified
	 */
	@Override
	public User readUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Updates the data of the specified user
	 * @precondition User cannot be null
	 * @param user - the user to be updated
	 * @return The number of affected rows. Should be 1.
	 */
	@Override
	public void updateUser(User user) {
		try(Connection conn = ConnectionSingleton.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "UPDATE bankuser SET email = ?, password = ?, has_checking = ?, has_savings = ? WHERE user_id = ?"; // do not use semicolon
			String[] key = new String[1];
			key[0] = "user_id";
			PreparedStatement statement = conn.prepareStatement(sql, key);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			int hasChecking = user.hasChecking() ? 1 : 0;
			statement.setInt(3, hasChecking);
			int hasSavings = user.hasSavings() ? 1 : 0;
			statement.setInt(4, hasSavings);
			statement.setInt(5, user.getUserID());
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * Disables the specified user.
	 * @precondition User cannot be null.
	 * @param user - the user to be disabled.
	 * @return The number of affected rows. Should be 1.
	 */
	@Override
	public void disableUser(User user) {
		try(Connection conn = ConnectionSingleton.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "UPDATE bankuser SET enabled = 0 WHERE user_id = ?"; // do not use semicolon
			String[] key = new String[1];
			key[0] = "user_id";
			PreparedStatement statement = conn.prepareStatement(sql, key);
			statement.setInt(1, user.getUserID());
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}

}
