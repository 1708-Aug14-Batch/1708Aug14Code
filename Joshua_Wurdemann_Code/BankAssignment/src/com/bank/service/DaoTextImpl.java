package com.bank.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bankassignment.pojos.User;
import com.bankassignment.pojos.UserIO;

public class DaoTextImpl implements DAO {
	static String filename =  "student.txt";
	Scanner scan = new Scanner(System.in);
	UserIO io1 = new UserIO();


	//
	//	@Override
	//	public void getUser() {
	//		// may need to change this
	//		UserIO io = new UserIO();
	//		ArrayList<User> user = io.readUser();
	//		for (User u : user) {
	//			System.out.println(u.toString());
	//		}
	//	}


	/** may need to change login to service area*/
	@Override
	public int login(String email, String password) {

		String path = "user.txt";
		FileReader fileRead = null;
		BufferedReader buffRead = null;

		try {
			fileRead = new FileReader(path);
			buffRead = new BufferedReader(fileRead);

			String line = null;
			while ((line = buffRead.readLine() != null)) {
				String[] user = line.split(":");
				if (email.equals(user[0])) {
					if (password.equals(user[1])) {
						return 2; // user is found
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getAccountId(String email, String password) {

		String path = "src/useraccount.txt";
		FileReader fileRead = null;
		BufferedReader buffRead = null;

		try {
			fileRead = new FileReader(path);
			buffRead = new BufferedReader(fileRead);

			String line = null;
			while (line = buffRead.readLine() != null) {
				String[] user = line.split(":");
				if (email.equals(user[0])) {
					if (password.equals(user[1])) {
						return user[2];
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	/**
	 * Returns the Ballace of the user account.
	 */
	public String getBalance(String accountId) {
		String path = "user.txt";
		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader(path));
			String line = buffRead.readLine();
			String[] balance = line.split(":");
			return balance[0];
		} catch (FileNotFoundException e) {
			createAccount(accountId); // create method for crete UserID
			return "0";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if(buffRead != null) {
					buffRead.close(); //Closing readers
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * handles withdraws from users account.
	 * 
	 * @param accountId
	 * @param amount
	 * @return
	 */
	public int withdraw(String accountId, double amount) {
		double balance = Double.parseDouble(getBalance(accountId));
		balance -= amount;
		if (balance < 0) {
			try {

				throw new Exception("Insuffcient funds");

			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} else{

			/** adding new balance data to file.*/

			String update = balance + ":" +"- amount" + getDate();
			ArrayList<String> data = readAccount(accountId);
			data.add(0, update);
			updateAccount(accountId, data);
		}
		return 2;
	}

	public int deposit(String accountId, double amount){
		Double balance = Double.parseDouble(getBalance(accountId));
		balance += amount;

		String update = balance + ":" +" amount" + getDate();
		ArrayList<String> data = readAccount(accountId);
		data.add(0, update);
		updateAccount(accountId, data);

		return 2;
	}
	//TODO need to find out what to do about making unique account id.
	/** Creates new user account.
	 * 
	 * @param accountId
	 */
	public void createAccount(String accountNumber) {
		String path = "user.txt";
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(path));
			bufferedWriter.write("0:(account opened):" + getDate());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	/** Retrieves data from account file.
	 * 
	 */
	public ArrayList<String> readAccount(String accountId){
		ArrayList<String> data = new ArrayList<>();
		String path = "user.txt";
		BufferedReader buffRead = null;

		try {
			buffRead = new BufferedReader( new FileReader(path));
			String line = null;

			while (( line = buffRead.readLine()) != null) { 
				data.add(line);
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
			return readAccount(accountId);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return data;}

	public void updateAccount(String accountNumber, ArrayList<String> data) {
		String path = "resources/" + accountNumber + ".txt";
		BufferedWriter bufferedWriter = null;
		try
		{
			bufferedWriter = new BufferedWriter(new FileWriter(path));
			for (String i : data) //copy entire file to update
			{
				bufferedWriter.write(i);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try
			{
				if (bufferedWriter != null)
				{
					bufferedWriter.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
















	public void write(ArrayList<User> list) {
		String path = "user.txt";

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){

			for(User i : list) {
				String text = "";
				text = text.concat(i.getAccountId() + ":");
				
				
				text = text.concat(i.getFirstname() + ":");
				text = text.concat(i.getLastname() + ":");
				text = text.concat(i.getEmail()+ ":");
				text = text.concat(i.getPassword()+ ":");
				//text = text.concat(Double.parseDouble(i.getBalance();
				

				bw.write(text);
				bw.newLine();
				bw.flush();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public String getDate(){
		Date date = new Date();

		return new SimpleDateFormat("MMM d, yyyy").format(date);

	}

	public ArrayList<User> read() {
		ArrayList<User> data = new ArrayList<>();
		String path = "user.txt";
		BufferedReader buffRead = null;

		try(BufferedReader br = new BufferedReader(new FileReader(path));){

			String line = null;

			while ((line = br.readLine()) != null){
				if(line.equals("")) {
					continue;
				}
				User temp = new User();
				String[] states = line.split(":");
				temp.setAccountId(states[0]);
				temp.setFirstname(states[1]);
				temp.setLastname(states[2]);
				System.out.print("what is happening");
				temp.setEmail(states[3]); 
   
			/*** ERORR The Code is spitting out following message after I enter Balance.	
	/**what is happeningException in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
	at com.bank.service.DaoTextImpl.read(DaoTextImpl.java:306)
	at com.bank.service.Service.registerUser(Service.java:73)
	at com.bank.main.RunBank.main(RunBank.java:88)
*/
				temp.setPassword(states[4]);
				temp.setBalance(Double.parseDouble(states[5]));
				data.add(temp);
			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return data;
	}


}

// file is in data package
