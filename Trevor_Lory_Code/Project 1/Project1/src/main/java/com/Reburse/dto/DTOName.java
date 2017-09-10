package com.Reburse.dto;

public class DTOName {

	private String fn;
	private String ln;
	
	public DTOName(String fn, String ln) {
		super();
		this.fn = fn;
		this.ln = ln;
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
	
}
