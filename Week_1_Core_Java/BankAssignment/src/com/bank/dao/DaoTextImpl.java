package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException; //Importing in the Wrtiers, Readers, Exceptions, ArrayList, and the Pojos
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bank.pojos.User;



public class DaoTextImpl implements DAO { //We implement the DAO interface
	
	static String textImp = "src/com/bank/files/customers1.txt"; //This is the text file used for reading/writing for the program
	
	/*
	 * The addUser function creates a BufferedWriter/FileWriter that concats a text string for the user info.
	 * It then is written to the text file.
	 */
	
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

	/*
	 * The read user creates an arrayList of Users and a BufferedReader/FileReader
	 * It then reads each line of the text file and for each string up to ":" puts into an element in the array to be added to the arrayList.
	 */
	
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
				temp.setBalance(Integer.parseInt(states[5].trim()));
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return list;

	}
	/*
	 * The editUser function is similar to the addUser function, except it overwrites instead of concats (see the false value in the creation of the FileWriter).
	 */

	@Override
	public void editUser(ArrayList<User> u) {
		try(BufferedWriter bw = new BufferedWriter(
				new FileWriter(textImp,false))){
			String text = " ";
			
			for(User i : u) {
			text = text.concat(i.getUserID() + ":");
			text = text.concat(i.getFirstName() + ":");
			text = text.concat(i.getLastName() + ":");
			text = text.concat(i.getEmail() + ":");
			text = text.concat(i.getPassWord() + ":");
			
			
			text = text.concat(i.getBalance() + "\n");
			}
			bw.write(text);
		} catch (IOException e) {
			
			e.printStackTrace();
		};
		
	}


}
