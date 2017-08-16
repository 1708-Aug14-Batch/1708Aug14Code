package com.ex.fileio;

import java.io.Serializable;

public class Honda implements Serializable{
	public String color;
	public Honda(){
		color = "red";
	}
	public String getColor(){
		return color;
	}
}
