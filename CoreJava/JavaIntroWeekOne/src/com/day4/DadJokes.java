package com.day4;

public class DadJokes implements Jokes{
	private String content;
	
	public DadJokes(String content) {
		super();
		this.content = content;
	}

	@Override
	public void makeLaugh() {
		for(int i=0;i<2;i++) {
			System.out.print("ha");
		}
	}

	@Override
	public void isLame() {
		System.out.println("Dad jokes are always lame");
		
	}

	@Override
	public void tellJoke() {
		System.out.println(content);
	}

}
