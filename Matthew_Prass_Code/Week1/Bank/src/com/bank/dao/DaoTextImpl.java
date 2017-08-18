package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.bank.pojos.User;

public class DaoTextImpl implements DAO {

	//file = located in data package
	//very similar the studentio.java!!!
	
	static String filename = "src/com/bank/files/users.txt";

	@Override
	public User addUser(User u) {
		writeUser(u);
		return u;
	}
	
	@Override
	public User editUser(User u) {
		ArrayList<User> list = readUsers();
		list.add(u);
		list.remove(list.size()-2);
		updateList(list);
		
		return u;
	}

	@Override
	public User getUser(String email,String pass) {
		ArrayList<User> list = readUsers();
		for(User u:list)
		{
			if(u.getEmail().equals(email))
				if(u.getPassword().equals(pass))
					return u;
		}
		return null;
	}
	
	public void writeUser(User u)
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true)))
		{
			String text = "";
			
			text = text.concat(u.toString());
			text = text.concat("\n");
			
			bw.write(text);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> readUsers()
	{
		ArrayList<User> list = new ArrayList<User>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String line = null;
			while((line = br.readLine())!= null) {
				User temp = new User();
				String[] states = line.split(" : ");
				temp.setId(Integer.parseInt(states[0]));
				temp.setFirstname(states[1]);
				temp.setLastname(states[2]);
				temp.setEmail(states[3]);
				temp.setPassword(states[4]);
				temp.setBalance(new BigDecimal(states[5]));
				list.add(temp);
			}
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateList(ArrayList<User> list)
	{
		ArrayList<User> newList = new ArrayList<User>();
		newList = list;
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,false)))
		{
			for(User u: newList)
			{
				String text = "";
				text = text.concat(u.toString());
				text = text.concat("\n");
				bw.write(text);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
}
