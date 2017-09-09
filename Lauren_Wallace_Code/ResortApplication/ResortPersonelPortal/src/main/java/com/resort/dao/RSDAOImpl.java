package com.resort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.resort.pojos.Reimbursement;
import com.resort.pojos.ReimbursementStatus;
import com.resort.util.ConnectionFactory;

public class RSDAOImpl implements RSDAO {

	@Override
	public ReimbursementStatus getRSById(int stat) {
		
		ReimbursementStatus rstat = new ReimbursementStatus();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from reimbursement_status where status_id =  ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stat);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				rstat.setStatId(info.getInt(1));
				rstat.setName(info.getString(2));
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return rstat;
}

}
