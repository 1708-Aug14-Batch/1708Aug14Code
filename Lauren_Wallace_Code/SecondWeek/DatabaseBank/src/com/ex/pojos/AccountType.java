package com.ex.pojos;

/*
 * This class determines the user account types 
 * the bank offers currently:
 * - checking (id = 0) - savings (id = 1)
 * 
 * This class will only be used by the DataBase Admin (DBA)
 * to add new types of user accounts based on bank's needs
 */

public class AccountType {
	
	private int id;
	private String name;
	
	public AccountType() {};
	
	public AccountType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + name + "]";
	}
	
	
}
