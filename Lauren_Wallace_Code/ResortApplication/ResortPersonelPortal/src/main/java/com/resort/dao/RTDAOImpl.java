package com.resort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.resort.pojos.ReimbursementStatus;
import com.resort.pojos.ReimbursementType;
import com.resort.util.ConnectionFactory;

public class RTDAOImpl implements RTDAO{

	@Override
	public ReimbursementType getRTById(int type) {
		
		ReimbursementType rtype = new ReimbursementType();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from reimbursement_type where type_id =  ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, type);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				rtype.settypeId(info.getInt(1));
				rtype.setName(info.getString(2));
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return rtype;
}

}
