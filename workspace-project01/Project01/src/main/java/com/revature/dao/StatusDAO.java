/**
 * 
 */
package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Status;
import com.revature.util.ConnectionSingleton;

/**
 * @author Will Underwood
 *
 */
public class StatusDAO implements IStatusDAO {

	/* (non-Javadoc)
	 * @see com.revature.dao.IStatusDAO#read(java.lang.String)
	 */
	@Override
	public Status read(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		Status status = null;
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			String sql = "SELECT * FROM status WHERE name = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				status = new Status();
				status.setStatusID(results.getInt("status_id"));
				status.setName(results.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	/* (non-Javadoc)
	 * @see com.revature.dao.IStatusDAO#readAll()
	 */
	@Override
	public ArrayList<Status> readAll() {
		ArrayList<Status> allStatuses = new ArrayList<Status>();
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			String sql = "SELECT * FROM status";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Status status = new Status();
				status.setStatusID(results.getInt("status_id"));
				status.setName(results.getString("name"));
				allStatuses.add(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allStatuses;
	}

}
