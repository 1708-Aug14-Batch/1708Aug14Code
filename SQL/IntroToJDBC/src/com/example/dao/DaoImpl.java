package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import com.example.pojos.Example;
import com.example.util.ConnectionFactory;

public class DaoImpl {

	// Callable Statement

	public String getName(int id) {
		Connection connect = null;
		CallableStatement cs = null;
		String name = null;

		try {
			connect = ConnectionFactory.getInstance().getConnection();

			String sql = "{ ? = call findPerson2 ? }";

			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();

			name = cs.getString(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cs.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		return name;
	}

	public int getId(String name) {
		Connection connect = null;
		CallableStatement cs = null;
		int id = 0;

		try {
			connect = ConnectionFactory.getInstance().getConnection();

			String sql = "{ ? = call findPerson(?) }";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();

			id = cs.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cs.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return id;
	}
	
	
	// Prepared Statement
	
	public int addExample(String firstName, String lastName) {
		int id = -1;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO EXAMPLE (FIRSTNAME, LASTNAME) VALUES(?, ?)";
			String[] key = { "EX_ID" };
			
			PreparedStatement statement = conn.prepareStatement(sql, key);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			
			statement.executeUpdate();
			ResultSet pk = statement.getGeneratedKeys();
			while (pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	// Statement - get all examples
	
	public List<Example> getAll() {
		List<Example> list = new ArrayList<Example>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			String sql = "SELECT EX.EX_ID, EX.FIRSTNAME, EX.LASTNAME, TR.NAME " +
						 "FROM EXAMPLE EX " + 
						 "LEFT JOIN TRACK TR ON EX.FAV_SONG_ID = TR.TRACKID";			
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String first = rs.getString(2);
				String last = rs.getString("LASTNAME");
				String song = rs.getString(4);
				list.add(new Example(id, first, last, song));
			}
			
			conn.commit();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
