package com.reimb.main;

public class DummyData {
	public static void main(String[] args){
		DBControl dbcon=new DBControl();
		dbcon.createNewUser("u1", "u1fn", "u1ln", "u1@revature.com", "12345", "manager");
		dbcon.createNewUser("u2", "u2fn", "u2ln", "u2@revature.com", "54321", "employee");
		dbcon.createNewUser("u3", "u3fn", "u3ln", "u3@revature.com", "abcde", "manager");
		dbcon.createNewUser("u4", "u4fn", "u4ln", "u4@revature.com", "fffff", "employee");
	}
}
