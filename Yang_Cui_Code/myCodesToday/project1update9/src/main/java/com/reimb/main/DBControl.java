package com.reimb.main;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

import com.reimb.dao.DAO;
import com.reimb.dao.DAOImpl;
import com.reimb.pojo.ApproveStat;
import com.reimb.pojo.RemibView;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;

public class DBControl {
	static private DAO dao = new DAOImpl();
	static private Date date= new Date();
	
	public int VarifyUser(String userName){
		return dao.getUserID(userName);
	}
	
	public ArrayList<Users> getEveryOne(){
		return dao.getAllUser();
	}
	
	public Users Authentication(String userName, String password){
		Users user = dao.getUser(dao.getUserID(userName));
		if(user!=null){
			if(user.getPassword().equals(password))
				return user;
			else
				return null;
		}else
			return null;
	}
	
	public Users Authentication(int userID, String password){
		Users user = dao.getUser(userID);
		if(user!=null){
			if(user.getPassword().equals(password))
				return user;
			else
				return null;
		}else
			return null;
	}
	
	public ArrayList<Remibursment> getRemibs(Users user){
		if(user.getIsMananger()){
			return dao.getAllRemib();
		}else{
			return dao.getUserRemib(user.getID());
		}
		//return dao.getUserRemib(user.getID());
	}
	
	public ArrayList<Remibursment> getEveryRemib(){
		return dao.getAllRemib();
	}
	
	public ArrayList<RemibView> getRemibView(ArrayList<Remibursment> remib){
		ArrayList<RemibView> rv=dao.getUserReimbView(remib);
		return rv;
	}
	
	public boolean createNewUser(String userName, String firstName, String lastName, String email, String pass, String role){
		Users newUser = new Users();
		newUser.setUserName(userName);
		newUser.setFristName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setPassword(pass);
		
		if(role.equals("employee"))
			newUser.setISMananger(false);
		else if(role.equals("manager"))
			newUser.setISMananger(true);
		else
			System.out.println("unknow user type");
		
		int userID = dao.addUser(newUser);
		
		if(userID<0)
			return false;
		else
			return true;
	}
	
	public boolean SumbitRemib(int userID, String description, double amount){
		Remibursment reimb= new Remibursment();
		//reimb.setSender(dao.getUser(Integer.parseInt(userID)));;
		reimb.setSender(dao.getUser(userID));
		reimb.setResolver(null);
		reimb.setSumbitDate(new Timestamp(date.getTime()));
		reimb.setStatus(new ApproveStat(0, "pending"));
		reimb.setDescription(description);
		//reimb.setAmount(Double.parseDouble(amount));
		reimb.setAmount(amount);
		
		int result=dao.submitRemib(reimb);
		
		if(result<0)
			return false;
		else
			return true;
	}
	
	public boolean ResolveReimb(String reimbID, int manangerID, String note, String statID){
		Remibursment reimb=dao.getRemib(Integer.parseInt(reimbID));
		System.out.println(manangerID);
		reimb.setResolver(dao.getUser(manangerID));
		reimb.setResolveDate(new Timestamp(date.getTime()));
		reimb.setStatus(dao.getStatus(Integer.parseInt(statID)));
		reimb.setNote(note);
		
		int result=dao.resolveRemib(reimb);
		
		if(result<0)
			return false;
		else
			return true;
	}
	/*public boolean ResolveReimb(int reimbID, int manangerID, String note, int statID){
		Remibursment reimb=dao.getRemib(reimbID);
		reimb.setSender(dao.getUser(manangerID));
		reimb.setResolveDate(new Timestamp(date.getTime()));
		reimb.setStatus(dao.getStatus(statID));
		reimb.setNote(note);
		
		int result=dao.resolveRemib(reimb);
		
		if(result<0)
			return false;
		else
			return true;
	}
	
	public boolean processResolveReimb(ArrayList<Remibursment> resolved, int manangerID, String note, int statID){
		for(int i=0; i<resolved.size(); i++){
			ResolveReimb(resolved.get(i).getID(), manangerID, note, resolved.get(i).getStatus().getID());
		}
		return false;
	}*/
}