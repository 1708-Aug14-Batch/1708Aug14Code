package com.reimb.pojo;

public class Users {
	private int userID;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private boolean isMananger;
	
	public Users(int userID, String firstName, String lastName, String userName, String email, String password, boolean isMananger){
		this.userID=userID;
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.email=email;
		this.password=password;
		this.isMananger=isMananger;
	}
	
	public Users(){
		
	}
	
	public int getID(){
		return userID;
	}
	
	public void setID(int userID){
		this.userID=userID;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFristName(String firstName){
		this.firstName=firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public boolean getIsMananger(){
		return isMananger;
	}
	
	public void setISMananger(boolean isMananger){
		this.isMananger=isMananger;
	}
}
