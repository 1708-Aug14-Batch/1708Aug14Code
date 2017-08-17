package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import com.bank.pojos.User;



public class DaoTextImpl implements DAO{

	public static String filename = "src/com/bank/data/data.txt";
	
	@Override
	public User addUser(User u) {
		if (getUser(u.getEmail(), u.getPassword()) != null)
			return null;
		write(u);
		return u;
	}

	@Override
	public User editUser(int id, User u) {
		Map<Integer, User> map = getAllUsers();
		map.put(id, u);
		writeAll(map);
		return u;
	}

	@Override
	public User getUser(String email, String password) {
		Map<Integer, User> map = getAllUsers();
		for(Map.Entry<Integer,User> entry : map.entrySet()) {
			if (entry.getValue().getEmail().equals(email)) {
				if (entry.getValue().getPassword().equals(password)) {
					return entry.getValue();
				}
				//TODO: Return unique value if email exists and password is wrong.
			}
		}
		return null;
	}
	
	public Map<Integer, User> getAllUsers() {
		Map<Integer, User> map = new TreeMap<Integer, User>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line=br.readLine()) != null) {
				User temp = new User();
				String[] states = line.split(":");
				temp.setId(Integer.parseInt(states[0]));
				temp.setFirstname(states[1]);
				temp.setLastname(states[2]);
				temp.setEmail(states[3]);
				temp.setPassword(states[4]);
				temp.setBalance(new BigDecimal(states[5]));
				map.put(Integer.parseInt(states[0]), temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public void write(User u) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			String txt = "";
			txt = txt.concat(((Integer)u.getId()).toString()+":");
			txt = txt.concat(u.getFirstname()+":");
			txt = txt.concat(u.getLastname()+":");
			txt = txt.concat(u.getEmail()+":");
			txt = txt.concat(u.getPassword()+":");
			txt = txt.concat(u.getBalance()+"\n");
			
			bw.write(txt);
		} catch (IOException e) {
			System.out.println("IOException encountered...");
		}
	}
	
	public void writeAll(Map<Integer, User> users) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));) {
			for(Map.Entry<Integer,User> entry : users.entrySet()) {
				String txt = "";
				txt = txt.concat(((Integer)entry.getValue().getId()).toString()+":");
				txt = txt.concat(entry.getValue().getFirstname()+":");
				txt = txt.concat(entry.getValue().getLastname()+":");
				txt = txt.concat(entry.getValue().getEmail()+":");
				txt = txt.concat(entry.getValue().getPassword()+":");
				txt = txt.concat(((BigDecimal)entry.getValue().getBalance()).toString()+"\n");
				
				bw.write(txt);
			}
		} catch (IOException e) {
			System.out.println("IOException encountered...");
		}
	}
}
