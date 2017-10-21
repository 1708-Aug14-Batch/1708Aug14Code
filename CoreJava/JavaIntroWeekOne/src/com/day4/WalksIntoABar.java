package com.day4;

public class WalksIntoABar implements Jokes{
	private String content;
	

	public WalksIntoABar(String content) {
		super();
		this.content = content;
	}

	@Override
	public void makeLaugh() {
		System.out.println("hahaha");
		
	}

	@Override
	public void isLame() {
		System.out.println("This is a good joke");
	}

	@Override
	public void tellJoke() {
System.out.println(content);		
	}

}
