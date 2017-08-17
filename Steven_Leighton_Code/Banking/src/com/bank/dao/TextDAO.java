package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bank.pojo.User;

public class TextDAO implements DAO{

	//filename for this application
	private final String filename = "src/com/bank/files/data.txt";

	@Override
	public void addUser(User user) {
		/*
		 * format: 
		 * 	-try with resources
		 *  -buffered writer -> File writer -> filename, true
		 *  -append user info with delimiter
		 *  
		 */

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){

			String addLine = "";
			//iterate over user info, adding delimiter if not last item
			//delimiter is ":"
			List<String> info = user.getInfoAsStringList();
			for (String string : info) {
				addLine += string;
				if(info.indexOf(string) != info.size()-1){
					addLine += ":";
				}
				else{
					addLine += "\n";
				}
			}

			//append to file
			bw.write(addLine);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getUsers() {
		//final output will be added to this List
		List<User> users = new ArrayList<User>();

		/*
		 * try catch and read everything line by line
		 * creating a new user per line and adding it to list
		 */

		try(BufferedReader br = new BufferedReader(new FileReader(filename))){

			String line = null;
			String[] split = null;
			//cycle through every available line
			while((line = br.readLine()) != null){
				split = line.split(":");

				//new user: id,fn,ln,username,pass,balance
				User u = new User(Integer.valueOf(split[0]), split[1], split[2],
						split[3], split[4], 
						BigDecimal.valueOf(Double.valueOf(split[5])));
				//add user
				users.add(u);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public void rewriteUsers(List<User> users) {

		/*
		 * try writing contents of users to file
		 * using " | " as delimiter
		 */
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))){

			for (User user : users) {

				String addLine = "";
				//iterate over user info, adding delimiter if not last item
				//delimiter is ":"
				List<String> info = user.getInfoAsStringList();
				for (String string : info) {
					addLine += string;
					if(info.indexOf(string) != info.size()-1){
						addLine += ":";
					}
					else{
						addLine += "\n";
					}
				}

				//append to file
				bw.write(addLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
