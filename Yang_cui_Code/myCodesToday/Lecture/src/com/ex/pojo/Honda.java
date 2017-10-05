package com.ex.pojo;

import static java.lang.Math.sqrt;

import java.io.Serializable;

import com.ex.vechiles.Car;

public class Honda extends Car implements Serializable {

	public int h=202;
	private String model;
	private int mpg;
	private String description;
	
	public Honda(){};
	
	public Honda(String model, int mpg, String description) {
		super();// call constructor of super class
		this.model = model;
		this.mpg = mpg;
		this.description = description;
		System.out.println("honda con");
	}
	
	//Encapsullation data hiding
	
	@Override
	public void steer() {
		// TODO Auto-generated method stub
		System.out.println("steering");
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("stoping");
	}
	
	//overriding stop method
	public double stop(double mph){
		double time=sqrt(mph);
		System.out.println("stooping");
		
		for(double i=mph; i>0; i--){
			System.out.println(i+" ");
		}
		
		return time/2;
		//System.out.println("unreachable code");
	}
	
	//overloading stop method
	public void stop(){
		System.out.println("stop");
	}
	
	//polymorhpism is take implmentation and mod it
	
	//Honda h=new Honda();
	//Honda honda = new Honda("model",3452,"description");
	
	public int getH(){
		return h;
	}

	public void setDescription(String string) {
		// TODO Auto-generated method stub
		this.description=string;
	}

	public void setModel(String string) {
		// TODO Auto-generated method stub
		this.model=string;
	}

	public void setMpg(int i) {
		this.mpg=i;
		// TODO Auto-generated method stub
		
	}

	public String getDescripition() {
		// TODO Auto-generated method stub
		
		return this.description;
	}
}
