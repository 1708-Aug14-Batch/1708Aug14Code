package com.revature.andy.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.ReimStatus;
import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;
import com.revature.andy.util.ConnectionFactory;

public class RunReim {

	private static Logger log = Logger.getRootLogger();
	static Service s = new Service();
	static DAOImplementation d = new DAOImplementation();
	
	public static void main(String[] args) {
	
		String a = "A";
		
		//HashSet<Reimbursement> temp = d.getReims();
		
		Connection con = ConnectionFactory.getInstance().getConnection();
				
		try {
			HashSet<Reimbursement> emp = d.getReims(con);
			
			for(Reimbursement x : emp ) {
				log.debug(x.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//con.getI
		
		//HashSet<User> emp = d.getEmployees();
		
		//User u = d.getUser(211);
		
		//ReimStatus rs = d.getReimStatusFromID(1);
		
		//System.out.println(s.login("A","A"));
		
		//String temp = d.getUser(a, a).getEmail();
		
		//d.selectALL();
		
		//System.out.println(temp);
		
	}
}
