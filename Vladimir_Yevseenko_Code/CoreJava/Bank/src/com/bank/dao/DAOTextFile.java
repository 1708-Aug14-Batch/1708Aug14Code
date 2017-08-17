package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bank.pojos.User;

public class DAOTextFile implements DAO<User> {
	
	private final String path;
	
	public DAOTextFile(String path) {
		this.path = path;
	}
	
	@Override
	public void write(List<User> list) {
		try (BufferedWriter b = new BufferedWriter(new FileWriter(path, false))) {
			for (User u: list)
				b.write(u.toStoredForm() + "\n");
		} catch (IOException ex) {
			System.err.println("I/O error");
			ex.printStackTrace();
		}
	}

	@Override
	public List<User> read() {
		try (BufferedReader r = new BufferedReader(new FileReader(path))) {
			List<User> list = new ArrayList<>();
			String line = null;
			while ((line = r.readLine()) != null)
				list.add(User.fromStoredForm(line));
	
			return list;
		} catch (IOException ex) {
			System.err.println("I/O error");
			ex.printStackTrace();
			return null;
		}
	}
}