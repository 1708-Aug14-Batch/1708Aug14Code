package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bank.pojos.User;



public class DaoTextImpl implements DAO {
	static String textImp = "src/com/bank/files/customer.txt";
	@Override
	public void addUser(User u) {
		
		try(BufferedWriter bw = new BufferedWriter(
				new FileWriter(textImp,true))){
			String text = " ";
			
			text = text.concat(u.getUserID() + ":");
			text = text.concat(u.getFirstName() + ":");
			text = text.concat(u.getLastName() + ":");
			text = text.concat(u.getEmail() + ":");
			text = text.concat(u.getPassWord() + ":");
			text = text.concat(u.getBalance() + "\n");
			
			bw.write(text);
		} catch (IOException e) {
			
			e.printStackTrace();
		};
		
	}

	@Override
	public ArrayList<User> readUser() {
		ArrayList<User> list = new ArrayList<User>();
		try(BufferedReader rw = new BufferedReader(
				new FileReader(textImp))){
			String line = null;
			while((line = rw.readLine()) != null) {
				User temp = new User();
				String[] states = line.split(":");//Need to get in balance later
				temp.setUserID(states[0]);
				temp.setFirstName(states[1]);
				temp.setLastName(states[2]);
				temp.setEmail(states[3]);
				temp.setPassWord(states[4]);
				temp.setBalance(states[5]);
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void editUser() {
		
		
	}

	@Override
	public void deleteUser() {
		
		
	}

}
