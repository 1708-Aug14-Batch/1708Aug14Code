package com.ex.day4;

public class CommonPokemonFactory {

	public CommonPokemon getCommonPokemon(String pokemonType) {
		if(pokemonType==null) {
			return null;
		}
		if(pokemonType.equalsIgnoreCase("PIDGEY")) {
			return new Pidgey();
		}
		else if(pokemonType.equalsIgnoreCase("WEEDLE")) {
			return new Weedle();
		}
		return null;
	}
	
}
