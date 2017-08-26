package com.ex.pojos;

public class Example {
	int id;
	String fn;
	String ln;
	int song;
	
	public Example(){}
	
	
	
	public Example(int id, String fn, String ln, int song) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.song = song;
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


	public int getSong() {
		return song;
	}


	public void setSong(int song) {
		this.song = song;
	}



	@Override
	public String toString() {
		return "Example [id=" + id + ", fn=" + fn + ", ln=" + ln + ", song=" + song + "]";
	}
	
	
	
	

}
