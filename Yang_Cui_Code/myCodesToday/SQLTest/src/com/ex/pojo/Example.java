package com.ex.pojo;

public class Example {
	int id;
	String fn;
	String ln;
	
	public Example(){}
	public Example(int id, String fn, String ln){
		super();
		this.id=id;
		this.fn=fn;
		this.ln=ln;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getFn(){
		return fn;
	}
	
	public void setFn(String fn){
		this.fn=fn;
	}
	
	public String getLn(){
		return ln;
	}
	
	public void setLn(String ln){
		this.ln=ln;
	}
	@Override
	public String toString() {
		return "Example [id=" + id + ", fn=" + fn + ", ln=" + ln + "]";
	}
	
	
}
