package com.day4;

public class KnockKnock implements Jokes{
	private String content;

	public KnockKnock(String content) {
		super();
		this.content = content;
	}

	@Override
	public void makeLaugh() {
		//Knock Knock jokes aren't funny
		System.out.println("*Sarcastic ha*");
	}

	@Override
	public void isLame() {
		System.out.println("This is a lame joke");
	}

	@Override
	public void tellJoke() {
		System.out.println(content);
	}

}
