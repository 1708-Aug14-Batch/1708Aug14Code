package com.homework.one;

abstract class Painter implements Artist {
	
	private String currentProject;
	private String artistsSignature;
	
	public Painter(String currentProject,String artistsSignature) {
		super();
		this.currentProject = currentProject;
		this.artistsSignature = artistsSignature;
	}

	public void perform(String creation) {
		// TODO Auto-generated method stub
		System.out.println(">=============================================================================================================================================================<");
		System.out.println("\"\"?$h.\"????,,._\"\"\" `.!!!;!!!!;`!!!   !><! '.\"?$??\"\",;!';;;`'- \"\"\".,;!!', A`!!!!' .<!'`.,c?)?\" ,\"\"??\".z..\"\".  `\"?$P\" \"\"?\" \"\" ,,`?\r\n");
		System.out.println(creation);
		System.out.println(">=============================================================================================================================================================<");
	}
	
	public void practice(int duration, String material) {
		// TODO Auto-generated method stub
		int tracker = duration*60;
		int curPos = 0;
		if ((duration*60) < material.length()) {
			while(tracker>0) {
				System.out.print(material.charAt(curPos));
				curPos++;
				tracker--;
			}
		}
		else {
			for (int i=0;i<(duration*60);i++) {
				System.out.print(material.charAt(i));
				
				
			}
		}
		
	}
	
	public void create(String progress) {
		// TODO Auto-generated method stub
		this.currentProject = this.currentProject + progress;
		
	}
	
	public void startProject(String beginning) {
		// TODO Auto-generated method stub
		this.currentProject = beginning;
	}
	
	public void finishProject(String ending) {
		// TODO Auto-generated method stub
		this.currentProject = this.currentProject + "\n"+this.artistsSignature;
	}
	public String getCurrentProject() {
		return currentProject;
	}
	public void setCurrentProject(String curProj) {
		this.currentProject = curProj;
	}
	public String getArtistsSignature() {
		return artistsSignature;
	}
	public void setArtistsSignature(String artSig) {
		this.artistsSignature = artSig;
	}

}
