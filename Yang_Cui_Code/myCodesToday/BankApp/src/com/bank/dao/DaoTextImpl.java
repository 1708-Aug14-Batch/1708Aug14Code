package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.User;

public class DaoTextImpl implements DAO{

	static String filename="src/com/bank/dao/user.txt";
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		ArrayList<User> users = readUser();
		for(int i=0; i<users.size(); i++)
			if(users.get(i).getID()==id)
				return users.get(i);
		return null;
	}

	@Override
	public void addUser(String id, String firstname, String lastname, String email, String password, String balance) {
		// TODO Auto-generated method stub
		User addUser = new User(id,firstname,lastname,email,password,balance);
		writeUser(addUser);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		ArrayList<User> users = readUser();
		users.remove(user.getID());
		writeUser(users);
	}

	@Override
	public void writeUser(User user) {
		// TODO Auto-generated method stub
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(filename, true));){
			String text=user.getID()+":"+user.getFirstname()+":"+user.getLastname()+":"+user.getEmail()+":"+user.getPassword()+":"+user.getBalance()+"\n";
			//System.out.println(text);
			bw.write(text);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void writeUser(ArrayList<User> users) {
		// TODO Auto-generated method stub
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(filename, false));){
			String text="";
			bw.write(text);
		}catch (IOException e){
			e.printStackTrace();
		}
		for(User u : users)
			writeUser(u);
	}

	@Override
	public ArrayList<User> readUser() {
		// TODO Auto-generated method stub
		ArrayList<User> list=new ArrayList<User>();
		try(BufferedReader br= new BufferedReader(new FileReader(filename));){
			String line = null;
			while((line=br.readLine())!=null){
				String[] states = line.split(":");
				User temp= new User(states[0],states[1],states[2],states[3],states[4],states[5]);
				list.add(temp);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public User changeBalance(User user, int amount, boolean deposit) {
		if(deposit)
			user.setBalance(user.getBalance()+amount);
		else
			user.setBalance(user.getBalance()-amount);
		return user;
		// TODO Auto-generated method stub
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		ArrayList<User> users = readUser();
		for(int i=0; i<users.size(); i++)
			if(users.get(i).getID()==user.getID()){
				users.get(i).setFirstname(user.getFirstname());
				users.get(i).setLastname(user.getLastname());
				users.get(i).setEmail(user.getEmail());
				users.get(i).setPassword(user.getPassword());
				users.get(i).setBalance(user.getBalance());
			}
		writeUser(users);
	}

	@Override
	public User authentication(int id, String password) {
		// TODO Auto-generated method stub
		ArrayList<User> users = readUser();
		for(int i=0; i<users.size(); i++)
			if(users.get(i).getID()==id && users.get(i).getPassword().equals(password))
				return users.get(i);
		return null;
	}

	@Override
	public int userIDgeneration() {
		// TODO Auto-generated method stub
		int goblin=0;
		ArrayList<User> users = readUser();
		for(int i=0; i<=users.size(); i++)
			goblin=i;
		return goblin;
	}
}
