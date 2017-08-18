package com.bank.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
		
		private int id;
		private String firstname;
		private String lastname;
		private String email;
		private String password;
		private double balance;
		
		public User() {
			super();
		}
		
		

		public User(int id, String firstname, String lastname, String email, String password) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.password = password;
		}



		public User(int id, String firstname, String lastname, String email, String password, double balance) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.password = password;
			this.balance = balance;
		}
		
		public List<String> getInfoAsStringList(){
			List<String> info = new ArrayList<String>();
			info.add(String.valueOf(id));
			info.add(firstname);
			info.add(lastname);
			info.add(email);
			info.add(password);
			info.add(Double.toString(balance));
			
			return info;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
		public void userWithdraw(Double x){
			balance = balance-(x);
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
					+ ", password=" + password + ", balance=" + balance + "]";
		}
		
		
		
		// add constructors, getters, setters

}
