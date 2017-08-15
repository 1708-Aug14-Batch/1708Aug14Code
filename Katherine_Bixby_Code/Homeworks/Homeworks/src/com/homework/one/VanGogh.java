package com.homework.one;

class VanGogh extends Painter {

	public VanGogh(String currentProject, String artistsSignature) {
		super(currentProject, artistsSignature);
		// TODO Auto-generated constructor stub
	}
	
	public void cutOffEar() {
		System.out.println("ow");
	}
	
	public void cry() {
		System.out.println(":'(");
	}
	
	public void beDepressed(int depressionLevel) {
		if(depressionLevel>90) {
			cutOffEar();
		}
		else {
			cry();
		}
	}
	
	

}
