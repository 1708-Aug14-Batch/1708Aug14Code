package com.homework.one;

public abstract class Singer implements Artist {
	
	String currentProject;

	public Singer(String currentProject) {
		super();
		this.currentProject = currentProject;
	}

	public void perform(String creation) {
		// TODO Auto-generated method stub
		System.out.println("♫♫ "+creation+" ♫♫");
	}
	
	public void practice(int duration, String material) {
		// TODO Auto-generated method stub
		for (int i=0;i<duration;i++) {
			System.out.println(material);
		}
		
	}
	
	public void create(String progress) {
		// TODO Auto-generated method stub
		this.currentProject = this.currentProject+" "+progress;
	}
	
	public void startProject(String beginning) {
		// TODO Auto-generated method stub
		this.currentProject = beginning;
		
	}
	
	public void finishProject(String ending) {
		// TODO Auto-generated method stub
		currentProject = this.currentProject+" "+ending+"©";
		
	}

	
	
}
