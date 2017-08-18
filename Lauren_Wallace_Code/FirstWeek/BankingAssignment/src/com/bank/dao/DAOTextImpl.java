package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.bank.pojos.User;

public class DAOTextImpl implements DAO {
	
	//file = located in data package
	static String filename = "src/com/bank/data/userInfo.txt";
	static ArrayList<User> list = new ArrayList<User>();
	static User u = new User();
	static double max  = 100.00;
	
	public void writeUser(User u) {
		
		//FileWriter(String str, bool state)
		//the bool state states if we want to append new str to the file
		//or if we want to overwrite the entire file/str
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String text = " ";
			
			//writes the user provided information onto userInfo.txt
			text = text.concat(u.getFirstName()+":");
			text = text.concat(u.getLastName()+":");
			text = text.concat(u.getUserName()+":");
			text = text.concat(u.getPassword()+":");
			text = text.concat(u.getBalance() + ":");
			text = text.concat(u.getId() + "\n");
			bw.write(text);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUserFName(String change) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(u.getFirstName())) {
					line = line.replace(u.getFirstName(), change); //replaces the old email with 
				}										           //the new specified one
				bw.write(line+"\n");
			}
			bw.flush();
			bw.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void updateUserLName(String change) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(u.getLastName())) {
					line = line.replace(u.getLastName(), change); //replaces the old email with 
				}										          //the new specified one
				bw.write(line+"\n");
			}
			bw.flush();
			bw.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void updateUserName(String change) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(u.getUserName())) {
					line = line.replace(u.getUserName(), change); //replaces the old email with 
				}										          //the new specified one
				bw.write(line+"\n");
			}
			bw.flush();
			bw.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void updateUserPass(String change) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(u.getPassword())) {
					line = line.replace(u.getPassword(), change); //replaces the old email with 
				}										          //the new specified one
				bw.write(line+"\n");
			}
			bw.flush();
			bw.close();
		}catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void updateBalance(double change, String choice) {
		
		switch(choice) {
		case 		   "1" : if(change > max) {
							 System.out.println("Deposit amount is over max limit.");
							 System.out.println("Max deposit limit is" + max);
							 System.out.println("Cannot Deposit.");
						 }
						 else {
							 double newB = (u.getBalance()+change);
							 try {
									BufferedReader br = new BufferedReader(new FileReader(filename));
									BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
									String line;
									while((line = br.readLine()) != null) {
										if(line.contains( Double.toString(u.getBalance()))) {
											line = line.replace(Double.toString(u.getBalance()), Double.toString(newB)); //replaces the old email with 
										}										          //the new specified one
										bw.write(line+"\n");
									}
									bw.flush();
									bw.close();
								}catch (IOException e) {
									e.getStackTrace();
								}
						 }
						 break;
		case 		"2": if(u.getBalance() == 0) {
						 	System.out.println("Balance is 0.");
						 	System.out.println("Cannot withdraw.");
		 				 }
						 else if(u.getBalance() < change) {
							 System.out.println("Balance is too low.");
							 System.out.println("Cannot withdraw.");
						 }
						 else if(change > max) {
							 System.out.println("Withdraw amount is over max limit.");
							 System.out.println("Max withdraw limit is" + max);
							 System.out.println("Cannot withdraw.");
						 }
						 else {
							 double newB = (u.getBalance()-change);
							 try {
									BufferedReader br = new BufferedReader(new FileReader(filename));
									BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
									String line;
									while((line = br.readLine()) != null) {
										if(line.contains( Double.toString(u.getBalance()))) {
											line = line.replace(Double.toString(u.getBalance()), Double.toString(newB)); //replaces the old email with 
										}										                                         //the new specified one
										bw.write(line+"\n");
									}
									bw.flush();
									bw.close();
								}catch (IOException e) {
									e.getStackTrace();
								}
						 }
						 break;
		}
	}
	
	public ArrayList<User> readUsers() {
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			u = new User();
			String line = null;
			int i = 0;
			while((line = br.readLine()) != null) {
				//.split takes in a regular expression
				String[] states = line.split(":");
				u.setFirstName(states[0]);
				u.setLastName(states[1]);
				u.setUserName(states[2]);
				u.setPassword(states[3]);
				u.setBalance(0.00);
				u.setId(i++);
				list.add(u);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public User getUser() {
		return u;
	}

}
