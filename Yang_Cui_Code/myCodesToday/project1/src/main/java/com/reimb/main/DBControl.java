package com.reimb.main;

import java.util.Date;
import java.sql.Timestamp;

import com.reimb.dao.DAO;
import com.reimb.dao.DAOImpl;
import com.reimb.pojo.ApproveStat;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;

public class DBControl {
	static private DAO dao = new DAOImpl();
	static private Date date= new Date();
	
	public Users Authentication(String userName, String password){
		Users user = dao.getUser(dao.getUserID(userName));
		if(user!=null)
		{
			if(user.getPassword().equals(password))
				return user;
			else
				return null;
		}else
			return null;
	}
	
	public boolean SumbitRemib(String userID, String description, String amount){
		Remibursment reimb= new Remibursment();
		reimb.setSender(dao.getUser(Integer.parseInt(userID)));;
		reimb.setResolver(null);
		reimb.setSumbitDate(new Timestamp(date.getTime()));
		reimb.setStatus(new ApproveStat(0, "pending"));
		reimb.setDescription(description);
		reimb.setAmount(Double.parseDouble(amount));
		
		int result=dao.submitRemib(reimb);
		
		if(result<0)
			return false;
		else
			return true;
	}
	
	public boolean ResolveReimb(String reimbID, String manangerID, String note, String statID){
		Remibursment reimb=dao.getRemib(Integer.parseInt(reimbID));
		reimb.setSender(dao.getUser(Integer.parseInt(manangerID)));
		reimb.setResolveDate(new Timestamp(date.getTime()));
		reimb.setStatus(dao.getStatus(Integer.parseInt(statID)));
		reimb.setNote(note);
		
		int result=dao.resolveRemib(reimb);
		
		if(result<0)
			return false;
		else
			return true;
	}
}
