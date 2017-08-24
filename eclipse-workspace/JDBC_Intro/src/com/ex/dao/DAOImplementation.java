package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.ex.pojos.Example;
import com.ex.util.ConnectionSingleton;

public class DAOImplementation {
	
	/**
	 * Callable statement
	 * @param name
	 * @return
	 */
	public int getID(String name) {
		Connection conn = null;
		CallableStatement statement = null;
		int id = 0;
		try {
			conn = ConnectionSingleton.getInstance().getConnection();
			String sql = "{? = call findPerson(?)}"; // syntax for calling stored procedure or function
			statement = conn.prepareCall(sql);
			statement.registerOutParameter(1, Types.NUMERIC);
			statement.setString(2, name);
			statement.execute();
			id = statement.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	/**
	 * Prepared statement
	 */
	public int addExample(String firstName, String lastName) {
		try(Connection conn = ConnectionSingleton.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO example(firstname, lastname) VALUES(?, ?)"; // do not use semicolon
			String[] key = new String[1];
			key[0] = "example_id";
			PreparedStatement statement = conn.prepareStatement(sql, key);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.executeUpdate();
			int id = 0;
			ResultSet primaryKeys = statement.getGeneratedKeys();
			while(primaryKeys.next()) {
				id = primaryKeys.getInt(1);
			}
			conn.commit();
			return id;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Statement
	 */
	public ArrayList<Example> getAll() {
		ArrayList<Example> list = new ArrayList<Example>();
		try(Connection conn = ConnectionSingleton.getInstance().getConnection();) {
			String sql = "SELECT * FROM example";
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(sql);
			while(results.next()) {
				int id = results.getInt(1);
				String firstName = results.getString(2);
				String lastName = results.getString("lastname");
				int song = results.getInt("fav_song_id");
				Example temp = new Example(id, firstName, lastName, song);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
