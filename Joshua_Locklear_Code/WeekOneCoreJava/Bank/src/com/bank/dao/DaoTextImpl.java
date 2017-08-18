package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bank.pojos.User;

public class DaoTextImpl implements DAO {
	//file = located in data package
static String filename = "src/com/bank/Files/User.txt";
	

@Override
public void addUser(User user) {

	try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){

		String addLine = "";
		List<String> info = user.getInfoAsStringList();
		for (String string : info) {
			addLine += string;
			if(info.indexOf(string) != info.size()-1){
				addLine += " ";
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
//public void deleteUser(User user){
//	BufferedReader dr = new BufferedReader(new FileReader(filename);
//	BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true);
//}

@Override
public List<User> readUsers() {
	//final output will be added to this List
	List<User> users = new ArrayList<User>();

	try(BufferedReader br = new BufferedReader(new FileReader(filename));){

		String line = null;
		String[] split = null;
		while((line = br.readLine()) != null){
			split = line.split(" ");
			User u = new User(Integer.valueOf(split[0]), split[1], split[2],
					split[3], split[4], 
					Double.valueOf(Double.valueOf(split[5])));
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

	try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))){

		for (User user : users) {

			String addLine = "";
			List<String> info = user.getInfoAsStringList();
			for (String string : info) {
				addLine += string;
				if(info.indexOf(string) != info.size()-1){
					addLine += " ";
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