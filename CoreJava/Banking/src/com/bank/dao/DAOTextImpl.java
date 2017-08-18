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

public class DAOTextImpl implements DAO{
	String filename = "src/com/bank/data/data.txt";

	@Override
	public ArrayList<User> getUser() {
		ArrayList<User> list = new ArrayList<User>();
		
		try(BufferedReader br =
				new BufferedReader(
						new FileReader(filename));){
			
			String line = null;
			while((line = br.readLine()) != null) {
				String[] states = line.split(":");
				User temp = new User();
				temp.setId(Integer.parseInt(states[0]));
				temp.setFirstname(states[1]);
				temp.setLastname(states[2]);
				temp.setEmail(states[3]);
				temp.setPassword(states[4]);
				double bal = Double.parseDouble(states[5]);
				BigDecimal balance = new BigDecimal(bal);
				temp.setBalance(balance);
				list.add(temp);
			}
			
		} 
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addUser(User newUser) {
		try(BufferedWriter bw =
				new BufferedWriter(
						new FileWriter(filename, true));){
			String text = "";
			text=text.concat(newUser.getId()+":");
			text=text.concat(newUser.getFirstname()+":");
			text=text.concat(newUser.getLastname()+":");
			text=text.concat(newUser.getEmail()+":");
			text=text.concat(newUser.getPassword()+":");
			text=text.concat(newUser.getBalance().toString()+ "\n");
			
			bw.write(text);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ArrayList<User> user) {
		try(BufferedWriter bw =
				new BufferedWriter(
						new FileWriter(filename, false));){
			
			String text = "";
			bw.write(text);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try(BufferedWriter bw =
				new BufferedWriter(
						new FileWriter(filename, true));){
			String text = "";
			for(User u: user) {
			text=text.concat(u.getId()+":");
			text=text.concat(u.getFirstname()+":");
			text=text.concat(u.getLastname()+":");
			text=text.concat(u.getEmail()+":");
			text=text.concat(u.getPassword()+":");
			text=text.concat(u.getBalance().toString()+ "\n");
			
			bw.write(text);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
