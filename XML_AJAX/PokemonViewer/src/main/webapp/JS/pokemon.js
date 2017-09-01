/**
 * POKEMON JS
 */

var pokemonVar, startTime;

function getPokemon() {
	var id = document.getElementById("pokemonId").value;
	console.log("poke id: " + id);
	
	// Start timer to see how long it takes to retrieve data
	startTime = new Date().getTime();
	
	// AJAX request step 1
	var xhr = new XMLHttpRequest();
	
	// AJAX step 2
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	}
	
	// AJAX step 3
	xhr.open("GET", "http://pokeapi.co/api/v2/pokemon/" + id, true);
	
	// AJAX step 4
	xhr.send();
}

function setValues(pokemon) {
	document.getElementsById("pokemonName").innerHTML = pokemon.name;
	var pokeImg = document.getElementsById("pokemonImg");
	pokeImg.setAttribute("src", "pokemon.sprites.front_shiny");
	pokeImg.setAttribute("alt", pokemon.name)
	
	var endTime = new Date.getTime();
	console.log("Getting this pokemon took: " + (endTime-startTime) + " ms.");
}
