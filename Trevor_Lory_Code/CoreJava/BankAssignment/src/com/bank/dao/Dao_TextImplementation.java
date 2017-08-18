package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bank.pojos.User;

public class Dao_TextImplementation implements Dao {

	String filename = "src/com/bank/data/UserEntries.txt";
	String filename2 = "src/com/bank/data/UsernameBank.txt";
	
	@Override
	public void addUser(User user) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			bw.write(user.toFormattedString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename2, true))) {
			bw.write(user.getId() + ":" + user.getUsername() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateUsers(String[] Users) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));) {
			for(String s : Users) {
				bw.write(s + "\n");
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename2, false))) {
			String[] info;
			for(String s : Users) {
				info = s.split(":");
				bw.write(info[0] + ":" + info[1] + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editUser(User user) {
		int amt = getAccountAmount();
		String[] users = new String[amt];
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			for(int i = 0; i < amt; i++) {
				users[i] = br.readLine();
			}
			users[user.getId()] = user.toFormattedString();
			updateUsers(users);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	@Override
	public void deleteUser(int ID) {
		String[] users;
		ArrayList<String> tempusers = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String temp;
			while((temp = br.readLine()) != null) {
				tempusers.add(temp);
			}
			boolean found = false;
			for(String s : tempusers) {
				if(found) {
					int ind = tempusers.indexOf(s);
					String[] tempUser = s.split(":");
					tempUser[0] = "" + (Integer.parseInt(tempUser[0]) - 1);
					tempusers.set(ind, tempUser[0] + tempUser[1] + tempUser[2] + tempUser[3] + tempUser[4] + tempUser[5]);
				}
				else if(Integer.parseInt(s.split(":")[0]) == ID) {
					tempusers.remove(s);
					found = true;
				}
			}
			users = new String[tempusers.size()];
			users = tempusers.toArray(users);
			updateUsers(users);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	@Override
	public User getUser(int ID) {
		User tempUser = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String[] values = null;
			while((values = br.readLine().split(":")) != null) {
				if(Integer.parseInt(values[0]) == ID) {
					tempUser = new User(Integer.parseInt(values[0]), values[3], values[4], values[1], values[2], Double.parseDouble(values[5]));
					return tempUser;
				}
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return null;
	}
	
	public boolean getUsername(String username) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename2));) {
			String name = "";
			while((name = br.readLine()) != null) {
				if(name.split(":")[1].equals(username)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		return false;
	}
	
	public int getUserID(String username) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename2));) {
			String name = "";
			while((name = br.readLine()) != null) {
				if(name.split(":")[1].equals(username)) {
					return Integer.parseInt(name.split(":")[0]);
				}
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		return -1;
	}
	
	public int getAccountAmount() {
		int amount = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			while(br.readLine() != null) {
				amount++;
			}
		} catch (FileNotFoundException e) {
			amount = 0;
		} catch (IOException e) {
			amount = 0;
		}
		return amount;
	}
}
