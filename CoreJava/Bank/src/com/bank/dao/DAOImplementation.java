package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.bank.pojos.Account;

public class DAOImplementation implements DAOInterface{
	
	static String filename = "src/com/bank/data/data.txt";
	
	// Add a new user with a balance of 0.00 to textfile;
	
	@Override
	public void addAccount(Account a) {
		// TODO Auto-generated method stub		

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			String text = "";
			
			// id?
			text += a.getId() + ":" + a.getFname() + ":" + a.getLname() + ":" + a.getEmail() + ":" + a.getPwd() + ":" + "0.00\n";
			
			bw.write(text);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// Update info
	
	@Override
	public void editAccount(Account s) {
		// TODO Auto-generated method stub
		
		ArrayList<Account> userList = getAll();
		
		for(Account x:userList) {
			if(x.getId()==s.getId()) {
				x = s;
			}
		}
		
		updateAccounts(userList);
	}

	// Gets the user object associated with the email and pwd
	@Override
	public Account getAccount(String email, String pwd) {
		// TODO Auto-generated method stub
		
		ArrayList<Account> userList = getAll();
		
		for(Account x:userList) {
			System.out.println(x.getEmail());
			if(x.getEmail().equals(email)) {
				System.out.println(x.getPwd());
				if(x.getPwd().equals(pwd)) {
					return x;	
				}
			}
		}
		return null;
	}

	// Updates the text file
	public void updateAccounts(ArrayList<Account> al){
		clearUsers();
		
		for(Account a: al) {
			addAccount(a);
		}
		
	}
	
	// Get an ArrayList of all accounts
	public ArrayList<Account> getAll() {
			
			ArrayList<Account> userList = new ArrayList<>();
			
			try (BufferedReader br = new BufferedReader(new FileReader(filename));){
				
				//br.readLine().split(":");
				
				String line = null;
				while((line = br.readLine())!=null) {
					String[] data = line.split(":");

					Account tempUser = new Account(Integer.parseInt(data[0]),data[1],data[2],
							data[3],data[4],new BigDecimal(data[5]));
					
					userList.add(tempUser);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userList;
	}

	// Clear the text file
	public void clearUsers() {
		try {
			PrintWriter erase = new PrintWriter(filename);
			erase.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int newID() {

		ArrayList<Account> userList = getAll();
		
		if(userList.size()==0) {
			return 1;
		}else {
			return userList.get(userList.size()-1).getId()+1;	
		}
		
	}
	
}
