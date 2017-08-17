package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bank.pojos.User;

public class Dao_TextImplementation implements Dao {

	String filename = "src/com/bank/data/UserEntries.txt";
	String filename2 = "src/com/bank/data/UsernameBank.txt";
	
	@Override
	public void addUser(User user) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			bw.write(user.toFormattedString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename2, true))) {
			bw.write(user.getId() + ":" + user.getUsername() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean editUser(int valueID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(int ID) {
		User tempUser = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			while(br.readLine() != null) {
				if(Integer.parseInt(br.readLine().split(":")[0]) == ID) {
					//parse in the user
				}
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return null;
	}
	
	public boolean getUsername(String username) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename2));) {
			String name = "";
			while((name = br.readLine()) != null) {
				if(name.split(":")[1].equals(username)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		return false;
	}
	
	public int getUserID(String username) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename2));) {
			String name = "";
			while((name = br.readLine()) != null) {
				return Integer.parseInt(name.split(":")[0]);
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		return -1;
	}
	
	public int getAccountAmount() {
		int amount = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			while(br.readLine() != null) {
				amount++;
			}
		} catch (FileNotFoundException e) {
			amount = 0;
		} catch (IOException e) {
			amount = 0;
		}
		return amount;
	}
}
