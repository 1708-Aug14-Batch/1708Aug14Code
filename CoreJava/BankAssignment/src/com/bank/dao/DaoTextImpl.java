package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pojos.User;

public class DaoTextImpl implements Dao {
	
	public static final String FILEPATH = "src/com/bank/data/bank_data.txt";

	public boolean addUser(User user) {
		if (user == null) return false;
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH, true))) {
						
			bw.write("" + user.getUserId() + ':' + user.getEmail() + ':' + user.getPassword() + ':'
					+ user.getLast() + ':' + user.getFirst() + ':' + user.getBalance() + '\n');
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean editUser(User user) {
		List<User> users = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line == "") break;
				users.add(parseLine(line));
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file = new File(FILEPATH);
		file.delete();
		
		for (User u : users) {
			if (user.getUserId() == u.getUserId()) {
				addUser(user);
			}
			else {
				addUser(u);
			}
		}		
		return true;
	}

	public User getUser(int userId) {
		if (userId < 1) return null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				if (String.valueOf(userId).equals(line.split(":")[0])) {
					return parseLine(line);
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String email) {
		if (email == null) return null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				if (email.equals(line.split(":")[1])) {
					return parseLine(line);
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean hasUser(String email) {
		return getUser(email) != null;
	}
	
	private User parseLine(String line) {
		String[] info = line.split(":");
		
		if (info.length != 6) return null;
		
		User user = new User();
		
		try {
			user.setUserId(Integer.valueOf(info[0]));
			user.setBalance(new BigDecimal(info[5]));
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
		user.setEmail(info[1]);
		user.setPassword(info[2]);
		user.setLast(info[3]);
		user.setFirst(info[4]);
		
		return user;
	}

	public static int nextId() {
		int ret = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line == "") break;
				int id = Integer.parseInt(line.split(":")[0]);
				if (id > ret) ret = id;
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return -1;
		}
		catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return ret + 1;
	}
}
