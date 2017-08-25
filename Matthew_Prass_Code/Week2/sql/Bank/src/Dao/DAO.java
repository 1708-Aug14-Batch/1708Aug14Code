package Dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {

	public int addUser(String fn,String ln,String email,String pw);
	public Account creatAccount(User u, int typeid);
	//get account
}
