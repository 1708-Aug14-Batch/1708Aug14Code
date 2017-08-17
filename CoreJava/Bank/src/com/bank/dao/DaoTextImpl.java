package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bank.pojos.User;
import com.bank.files.*;

public class DaoTextImpl implements DAO {
	// file = located in data package
	static String filename = "src/com/bank/files/Bank.txt";

	@Override
	public void addUser(User user) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			String text = "";

			text = text.concat(user.getId() + ":");
			text = text.concat(user.getFirstname() + ":");
			text = text.concat(user.getLastname() + ":");
			text = text.concat(user.getEmail() + ":");
			text = text.concat(user.getPassword() + ":");
			text = text.concat(user.getBalance() + "\n");

			bw.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editUser(User user) {

	}

	@Override
	public ArrayList<User> getUser(User user) {
		ArrayList<User> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				User temp = new User();
				String[] states = line.split(":");
				temp.setFirstname(states[0]);
				temp.setLastname(states[1]);
				temp.setEmail(states[2]);
				temp.setPassword(states[3]);
				
				System.out.println(states[4]);
				
				//temp.setBalance.parseDouble(states[4]);
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
	public int getUserID(String fn, String ln) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] states = line.split(":");
				String firstName = states[1];
				String lastName = states[2];
				if(firstName.equals(fn) && lastName.equals(ln)) {
					return Integer.parseInt(states[0]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}