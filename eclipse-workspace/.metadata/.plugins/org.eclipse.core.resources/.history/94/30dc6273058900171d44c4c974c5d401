package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.ex.util.ConnectionSingleton;

public class DAOImplementation {
	
	/*
	 * Callable statement
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

}
