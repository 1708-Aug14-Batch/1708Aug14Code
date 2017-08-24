package com.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.jdbc.pojos.Example;
import com.jdbc.util.ConnectionFactory;

public class DAOImpl {

	//Callable Statement
	public int getID(String name) {
		Connection conn = null;
		CallableStatement cs = null;
		int id = 0;
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call findPerson(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name);
			cs.execute();
			id = cs.getInt(1);
		} catch (Exception e) {
			System.out.println("ERROR");
		} finally {
			try {
				cs.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("ERROR");
			}
		}
		
		return id;
	}
	
	public String getName(int id) {
		Connection conn = null;
		CallableStatement cs = null;
		String name = "";
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String sql = "{? = call getName(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			name += cs.getString(1);
		} catch (Exception e) {
			System.out.println("ERROR");
		} finally {
			try {
				cs.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("ERROR");
			}
		}
		return name;
	}
	
	//Prepared Statement
	public int addExample(String fn, String ln) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Example "
						 + "(Firstname, Lastname) " 
						 + "VALUES (?, ?)";
			String[] key = new String[1];
			key[0] = "Ex_ID";
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, fn);
			ps.setString(2, ln);
			
			int numRowsAdded = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				id = pk.getInt(1);
			}
			conn.commit();
			return id;
			
		} catch (Exception e) {
			System.out.println("ERROR");
		}	
		return -1;
	}
	
	//Get All Examples
	public ArrayList<Example> getAll() {
		ArrayList<Example> list = new ArrayList<Example>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM Example";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				int song = rs.getInt(4);
				Example tmp = new Example(id, firstname, lastname, song);
				list.add(tmp);
			}
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return list;
	}
	
}
