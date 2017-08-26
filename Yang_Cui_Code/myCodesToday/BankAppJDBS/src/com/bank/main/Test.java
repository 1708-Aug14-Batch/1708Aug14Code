package com.bank.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public class Test {
	static int userID;
	public static void main(String[] args){
		DaoImpl dao = new DaoImpl();
		Random rng = new Random();
		//dao.addUser("Random2", "Random2", "random2@random2.com", "random222");
		//User user1 =new User(1,"test0x","test0x","test0x@random0x.com","random000x");
		//int x=dao.updateUser(user1);
		//System.out.println(x);
		int userOption=0;
		Scanner input = new Scanner(System.in);
		while (true){
			System.out.println("0=add new user test");
			System.out.println("1=change user info test");
			System.out.println("2=delete user test");
			System.out.println("3=open new account test");
			System.out.println("4=close account test");
			System.out.println("5=view account info test");
			System.out.println("6=deposit test");
			System.out.println("7=withdraw test");
			System.out.println("8=transfer test");
			userOption =input.nextInt();
			input.nextLine();
			switch (userOption){
			case(0): userID=AddUser(dao,rng); break;
			case(1): EditUser(dao,rng,userID); break;
			case(2): RemoveUser(dao,userID); break;
			case(3): OpenAccount(dao,userID); break;
			case(4): CloseAccount(dao,userID); break;
			case(5): ViewAccount(dao,userID); break;
			case(6): Deposit(dao,userID); break;
			case(7): Withdraw(dao,userID); break;
			case(8): Transfer(dao,userID); break;
			default: System.out.println("wrong choice try again"); break;
			}
		}
	}
	
	public static int AddUser(DaoImpl dao, Random rng){ //<-- create a new user and return this user id
		int x=dao.addUser(RandString(rng,"abcdefg", 6), RandString(rng,"abcdefg", 6), RandString(rng,"abcdefg", 6), RandString(rng,"abcdefg", 6));
		//int x=dao.addUser("Random3", "Random3", "random3@random3.com", "1b1b1b1");
		System.out.println(x);
		User user =dao.getUser(x);
		System.out.println(user.getID());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println();
		return x; //<-- new user id
	}
	
	public static void EditUser(DaoImpl dao, Random rng, int id){ //<-- edit user at this user id
		int x=dao.updateUser(new User(id,RandString(rng,"hijk", 6), RandString(rng,"hijk", 6), RandString(rng,"hijk", 6), RandString(rng,"hijk", 6)));
		//int x=dao.updateUser(new User(id,"Random3A", "Random3B", "random3AB@random3.com", "1b1b1b1"));
		System.out.println(x);
		User user =dao.getUser(x);
		System.out.println(user.getID());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println();
	}
	
	public static void RemoveUser(DaoImpl dao, int id){ //<-- delete user at this user id
		int x=dao.deleteUser(dao.getUser(id));
		System.out.println(x);
	}
	
	public static void OpenAccount(DaoImpl dao, int id){ //<-- open new account at this user id
		User user =dao.getUser(id);
		int x1=dao.addAccount(user, 1);
		int x2=dao.addAccount(user, 2);
		int x3=dao.addAccount(user, 3);
		System.out.println(x1+" "+x2+" "+x3);
	}
	
	public static void CloseAccount(DaoImpl dao, int id){ //<-- close the credit account at this user id
		int accountDeleted=-1;
		User user =dao.getUser(id);
		ArrayList<Account> acclist = dao.getAccount(user);
		for(Account acc : acclist){
			if(acc.getType().getID()==2){
				accountDeleted=dao.closeAccount(acc);
				break;
			}
		}
		System.out.println(accountDeleted);
	}
	
	public static void ViewAccount(DaoImpl dao, int id){ //<-- view account info of this user id
		User user = dao.getUser(id);
		ArrayList<Account> acclist = dao.getAccount(user);
		
		System.out.println(user.getID());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		for(Account acc : acclist){
			System.out.println(acc.getID());
			System.out.println(acc.getBalance());
			System.out.println(acc.getType().getID());
			System.out.println(acc.getType().getName());
		}
	}
	
	public static void Deposit(DaoImpl dao, int id){ //<-- add money to all account of this user id
		User user =dao.getUser(id);
		ArrayList<Account> acclist = dao.getAccount(user);
		
		for(Account acc : acclist){
			acc.setBalance(acc.getBalance()+1000);
			dao.changeBalance(acc);
		}
		ViewAccount(dao,id);
	}
	
	public static void Withdraw(DaoImpl dao, int id){ //<-- tank money from all account of this user id
		User user =dao.getUser(id);
		ArrayList<Account> acclist = dao.getAccount(user);
		
		for(Account acc : acclist){
			acc.setBalance(acc.getBalance()-1000);
			dao.changeBalance(acc);
		}
		ViewAccount(dao,id);
	}
	
	public static void Transfer(DaoImpl dao, int id){// <-- transfer money from one account to another at this user id
		User user =dao.getUser(id);
		ArrayList<Account> acclist = dao.getAccount(user);
		ArrayList<Integer> accID =new ArrayList<Integer>();
		for(Account acc : acclist){
			accID.add(acc.getID());
		}
		Account acc1 = dao.getAnAccount(accID.get(0));
		Account acc2 = dao.getAnAccount(accID.get(1));
		acc1.setBalance(acc1.getBalance()+200);
		acc2.setBalance(acc2.getBalance()-200);
		
		dao.changeBalance(acc1);
		dao.changeBalance(acc2);
		
		ViewAccount(dao,id);
	}
	
	public static String RandString(Random rng, String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
}
