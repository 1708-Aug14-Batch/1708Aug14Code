package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ex.util.ConnectionFactory;

public class DAOImpl {
	
	/*
	 * Callable statement
	 * calls findPerson function in DB that takes in a
	 * string (firstname) as a parameter then returns the
	 * person's ID
	 */
	public int getID(String name){
		Connection connect = null;
		CallableStatement cs = null;
		int id = 0;
		try{
			connect = ConnectionFactory
					.getInstance()
					.getConnection();
			String sql = "{? = call findPerson(?)}";
			cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setString(2, name );
			cs.execute();
			id = cs.getInt(1);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				cs.close();
				connect.close();
			} catch(Exception e){e.printStackTrace();}
		}
		return id;
	}
	
	
	

}
