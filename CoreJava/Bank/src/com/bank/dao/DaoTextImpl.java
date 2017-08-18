package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
	static String fileID = "src/com/bank/files/nextID.txt";

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
	public ArrayList<User> getAllUsers() {
		ArrayList<User> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
					User temp = new User();
					String[] states = line.split(":");
					temp.setId(Integer.parseInt(states[0]));
					temp.setFirstname(states[1]);
					temp.setLastname(states[2]);
					temp.setEmail(states[3]);
					temp.setPassword(states[4]);
					temp.setBalance(Double.parseDouble(states[5]));
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
	public ArrayList<User> getUser(int id) {
		ArrayList<User> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.substring(0,1).equals(Integer.toString(id))) {
					User temp = new User();
					String[] states = line.split(":");
					temp.setFirstname(states[1]);
					temp.setLastname(states[2]);
					temp.setEmail(states[3]);
					temp.setPassword(states[4]);
					temp.setBalance(Double.parseDouble(states[5]));
					list.add(temp);
					return list;
				}
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
				if (firstName.equals(fn) && lastName.equals(ln)) {
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

	@Override
	public int getNextID() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileID));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				return Integer.parseInt(line) + 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public void updateID(String id) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileID, false));) {
			bw.write(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteFile() {
		new File(filename).delete();
	}

}