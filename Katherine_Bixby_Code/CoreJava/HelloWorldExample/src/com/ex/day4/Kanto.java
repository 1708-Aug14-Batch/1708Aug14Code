package com.ex.day4;

public class Kanto {

	public static void main(String[] args) {
		Mew mew = Mew.returnMew();
		mew.noise();
		mew.peek();
		CommonPokemonFactory pokeFactory = new CommonPokemonFactory();
		CommonPokemon pidgey1 = pokeFactory.getCommonPokemon("Pidgey");
		pidgey1.noise();
		CommonPokemon pidgey2 = pokeFactory.getCommonPokemon("PIDGEY");
		pidgey2.noise();
		CommonPokemon weedle1 = pokeFactory.getCommonPokemon("Weedle");
		weedle1.noise();
		CommonPokemon weedle2 = pokeFactory.getCommonPokemon("WEEDLE");
		weedle2.noise();
	}
	
}
