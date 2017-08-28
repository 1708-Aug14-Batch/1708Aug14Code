package com.bank.pojo;

public class AccountType {
	private int id;
	private String name;

	public AccountType(){
 
	}

	public AccountType(int id, String name) {
		super();
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
				
		if(getId()== 1){
			name = "checking";
		}else if(getId()== 2){
			name = "saving";
		} else if(getId()== 3){
			name = "credit card";
		}else{
			this.name = name;
		}
	}
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + name + "]";
	}


}
