package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.bank.pojos.User;


public class DAOTextImpl implements DAO{
	static String filename = "src/com/bank/data/bank_info.txt";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Override
	public ArrayList<User> getUser() {
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
	public void update(ArrayList<User> user) {
		try(BufferedWriter bw =	new BufferedWriter(new FileWriter(filename, false));){
			
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
			text=text.concat(u.getBalance()+ "\n");
			
			bw.write(text);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	





	

}
