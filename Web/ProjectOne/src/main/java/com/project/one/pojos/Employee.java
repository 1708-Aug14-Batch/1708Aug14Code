package com.project.one.pojos;

public class Employee {
	private int id;//EMPLOYEEID number Primary Key,
	private String fn;//FIRSTNAME VARCHAR2(30),
	private String ln;//LASTNAME VARCHAR2(30),
	private String email;//EMAIL VARCHAR2(30) UNIQUE NOT NULL,
	private String pwd;//PASSWORD VARCHAR2(30) NOT NULL,
	private int mngr;//ISMANAGER NUMBER NOT NULL
	
	public Employee(int id, String fn, String ln, String email, String pwd, int mngr) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.pwd = pwd;
		this.mngr = mngr;
	}

	public Employee(int emplid, String fn, String ln) {
		this.id = emplid;
		this.fn = fn;
		this.ln = ln;
	}
	/**
	 * This provides a secure constructor for an employee that does not
	 * include personal information like password 
	 * @param id2
	 * @param fn2
	 * @param ln2
	 * @param email2
	 */
	public Employee(int id, String fn, String ln, String email) {
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getMngr() {
		return mngr;
	}

	public void setMngr(int mngr) {
		this.mngr = mngr;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fn=" + fn + ", ln=" + ln + ", email=" + email + ", pwd=" + pwd + ", mngr="
				+ mngr + "]";
	}
	
	
	

}
