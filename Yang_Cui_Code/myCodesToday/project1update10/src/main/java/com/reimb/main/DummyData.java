package com.reimb.main;

public class DummyData {
	public static void main(String[] args){
		DBControl dbcon=new DBControl();
		/*
		boolean user1=dbcon.createNewUser("u1", "u1fn", "u1ln", "u1@revature.com", "12345", "manager");
		boolean user2=dbcon.createNewUser("u2", "u2fn", "u2ln", "u2@revature.com", "54321", "employee");
		boolean user3=dbcon.createNewUser("u3", "u3fn", "u3ln", "u3@revature.com", "abcde", "manager");
		boolean user4=dbcon.createNewUser("u4", "u4fn", "u4ln", "u4@revature.com", "fffff", "employee");
		
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(user4);
		*/
		boolean reimb1=dbcon.SumbitRemib(1, "good reason 1", 1000);
		boolean reimb2=dbcon.SumbitRemib(2, "good reason 2", 2000);
		boolean reimb3=dbcon.SumbitRemib(3, "good reason 3", 3000);
		boolean reimb4=dbcon.SumbitRemib(4, "good reason 4", 4000);
		
		System.out.println(reimb1);
		System.out.println(reimb2);
		System.out.println(reimb3);
		System.out.println(reimb4);
	}
}
