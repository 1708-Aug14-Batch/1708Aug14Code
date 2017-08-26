package com.bank2.pojos;

public class AcctType {
	private int accttypeid;
	private String name;
	
	public AcctType() {}
	
	public AcctType(int accttypeid, String name) {
		super();
		this.accttypeid = accttypeid;
		this.name = name;
	}

	public int getAccttypeid() {
		return accttypeid;
	}

	public void setAccttypeid(int accttypeid) {
		this.accttypeid = accttypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AcctType [accttypeid=" + accttypeid + ", name=" + name + "]";
	}
	
	
}
