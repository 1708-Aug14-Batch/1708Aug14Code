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
	public User editUser(User user) {
		// TODO Auto-generated method stub
		if(user==null)
			System.out.println("this user ID does not exist");
		else{
			boolean exit=false;
			while(!exit){
				Scanner input = new Scanner(System.in);
				System.out.println("0=EXIT");
				System.out.println("1=change user first name");
				System.out.println("2=change user last name");
				System.out.println("3=change user email");
				System.out.println("4=change user password");
				int userOption =input.nextInt();
				input.nextLine();
				
				switch(userOption){
				case 0: exit=true; break;
				case 1: {
					System.out.println("please enter your new firstname:");
					String changeFirst =input.nextLine();
					user.setFirstname(changeFirst);
					updateUser(user,1);
					System.out.println("you changed your firstname to: "+changeFirst);
				}break;
				case 2: {
					System.out.println("please enter your new lastname:");
					String changeLast =input.nextLine();
					user.setLastname(changeLast);
					updateUser(user,2);
					System.out.println("you changed your lastname to: "+changeLast);
				}break;
				case 3: {
					System.out.println("please enter your new email:");
					String changeEmail =input.nextLine();
					user.setEmail(changeEmail);
					updateUser(user,3);
					System.out.println("you changed your email to: "+changeEmail);
				}break;
				case 4: {
					System.out.println("please enter your new password:");
					String changePass =input.nextLine();
					user.setPassword(changePass);
					updateUser(user,4);
					System.out.println("you changed your password to "+changePass);
				}break;
				default: System.out.println("invalid input please try again"); break;
				}
			}
		}
		return user;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		if(user==null)
			System.out.println("this user ID does not exist");
		else{
			ArrayList<User> users = readUser();
			users.remove(user);
			writeUser(users);
		}
	}

	@Override
	public void writeUser(User user) {
		// TODO Auto-generated method stub
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(filename, true));){
			String text=user.getID()+":"+user.getFirstname()+":"+user.getLastname()+":"+user.getEmail()+":"+user.getPassword()+":"+user.getBalance()+"\n";
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
		if(user==null)
			System.out.println("this user ID does not exist");
		else{
			if(deposit)
				user.setBalance(user.getBalance()+amount);
			else
				user.setBalance(user.getBalance()-amount);
			
			updateUser(user,5);
			System.out.println("your reminding balance: "+user.getBalance());
		}
		return user;
		// TODO Auto-generated method stub
	}
	
	@Override
	public void updateUser(User user, int element) {
		// TODO Auto-generated method stub
		ArrayList<User> users = readUser();
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getID()==user.getID()){
				switch(element){
				case 1: users.get(i).setFirstname(user.getFirstname()); break;
				case 2: users.get(i).setLastname(user.getLastname()); break;
				case 3: users.get(i).setEmail(user.getEmail()); break;
				case 4: users.get(i).setPassword(user.getPassword()); break;
				case 5: users.get(i).setBalance(user.getBalance()); break;
				default: System.out.println("something went wrong");
				}
				break;
			}
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
