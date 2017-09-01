package com.ers.pojos;

public class ReimbursementStatus 
{
	private int id;
	private String name;
	
	public ReimbursementStatus() {}

	public ReimbursementStatus(int id, String name) {
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
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", name=" + name + "]";
	};
	
	
}
