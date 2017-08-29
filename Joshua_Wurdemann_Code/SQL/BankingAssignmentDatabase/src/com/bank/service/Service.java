package com.bank.service;

//import java.util.ArrayList;
import com.bank.dao.DAOIm;
import com.bank.pojo.Account;
import com.bank.pojo.User;


public class Service{
	//static DAOIm dao = new DAOIm();

	public User myUser;
	public static DAOIm myDao;
	public Account myAccount;
	//public ArrayList<Account> myAccounts;
	public Service(){
		myDao = new DAOIm();
		myUser = new User();
		myAccount = new Account();
		//myAccounts = new ArrayList<>();
	}

	public int addUser(String fn, String ln, String em, String pw){
		int id = myDao.addUser(fn, ln, em, pw);
		// validate email address
		return id;
	}

	/**Determines if user is logged in or not.
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean login(String email, String password){
		myUser = myDao.getUser(email, password);
		try{
			if(myUser.getUserId() != 0){

				return true;
			}
		}catch(NullPointerException e){
			//e.printStackTrace();
		}
		return false;
	}

	public boolean getAccount(User u){
		myAccount = myDao.getAccount(u);
		
		
		//myAccounts = myDao.getAccount(u);
		
		// loop through accounts to getid
		
		try{
			if(myAccount.getId() != 0){

				return true;
			}
		}catch(NullPointerException e){
			//e.printStackTrace();
		}
		return false;
	}

	/** needs to communicate to the sql server to verify user was created*/
	public int getUserId(String email, String password){

		myUser = myDao.getUser(email, password);
		try{
			int id = myUser.getUserId();

			return id;
		}catch(NullPointerException e){
			//e.printStackTrace();
		}
		return -1;
	}
	/** Retrieves User from the server*/
	public User getUser(String email, String password){

		myUser = myDao.getUser(email, password);
		return myUser;
	}

	/**
	 *  sends message to add account to server.
	 * @param u 
	 * @param typeid
	 * @return true or false back to main.
	 */
	public Account addAccount(User u, int typeid ){

		myAccount = myDao.addAccount(u, typeid);
		return myAccount;
	}
	/** used to logout of account*/
	public void logout() {
		myUser.setUserId(0);
	}
	/**
	 * Determines if you still in bank.
	 * @return
	 */
	public boolean isOpen() {
		return myUser.getUserId() != 0;
	}

	/** gets the balance from dao*/
	public String getBalance() {
		myAccount = myDao.getAccount(myUser);// need have an actual user here
		double someBalance = myAccount.getBalance();
		return String.valueOf(someBalance);
	}

	/**
	 * 
	 * @param u
	 * @param amount
	 * @return Returns the Balance updated balance.
	 */
	public double deposit(User u, String amount){

		Double balance = Double.parseDouble(getBalance());
		balance += Double.parseDouble(amount);
		int id =  u.getUserId();
		myDao.updateAccount(id, balance);
		return balance;
	}
	/**
	 * Withdraws money to create a new balance;
	 * @param amount
	 */
	public double withdraw(User u, String amount){

		Double balance = Double.parseDouble(getBalance());
		if(Double.parseDouble(amount) > balance){
			return -1;
		}
		else{
			balance -= Double.parseDouble(amount);
			int id =  u.getUserId();
			myDao.updateAccount(id, balance);
		}
		return balance ;
	}
     /**
      * Edits the email and password. 
      * @param u current logged in user.
      * @param email updated email.
      * @param password updated password.
      */
	public void editUser(User u, String email, String password) {

		int id =  u.getUserId();
		myDao.editUser(id, email, password);
	}
}
