package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.RUser;
import com.revature.util.ConnectionSingleton;

public class RUserDAO implements IRUserDAO {

	@Override
	public void create(RUser user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO r_user(r_user_id, first_name, last_name, email, password, is_manager) VALUES(DEFAULT, ?, ?, ?, ?, DEFAULT)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RUser read(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Email cannot be null");
		}
		RUser user = null;
		try (Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			String sql = "SELECT * FROM r_user WHERE email = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				user = this.getRUserFromQuery(results);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	private RUser getRUserFromQuery(ResultSet results) throws SQLException {
		RUser user = new RUser();
		user.setRUserID(results.getInt("r_user_id"));
		user.setFirstName(results.getString("first_name"));
		user.setLastName(results.getString("last_name"));
		user.setEmail(results.getString("email"));
		user.setPassword(results.getString("password"));
		user.setManager(0 != results.getInt("is_manager"));
		return user;
	}

	@Override
	public ArrayList<RUser> readAll() {
		ArrayList<RUser> allRUsers = new ArrayList<RUser>();
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			String sql = "SELECT * FROM r_user";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				RUser user = this.getRUserFromQuery(results);
				allRUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allRUsers;
	}

	@Override
	public int update(RUser user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		int numberOfRowsAffected = 0;
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE r_user SET first_name = ?, last_name = ?, email = ?, password = ?, is_manager = ? WHERE r_user_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setBoolean(5, user.isManager());
			statement.setInt(6, user.getRUserID());
			numberOfRowsAffected = statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfRowsAffected;
	}

}
