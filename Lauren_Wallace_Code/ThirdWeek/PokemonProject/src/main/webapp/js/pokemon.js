/**
 * Pokemon JS

\ */

var pokemonVar, startTime;

function getPokemon() {
	var pokeid = document.getElementById("pokemonId").value;
	console.log("Poke id: " + pokeid);
	//starttime will show how long the query takes
	startTime = new Date().getTime();
	
	//Step 1 of AJAX request -- open XHR
	var xhr = new XMLHttpRequest();
	
	//Step 2 - create function handle readystatechange
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
			//why not just use pokemonVar
		}
	}
	//Step 3
	xhr.open("GET", "http://pokeapi.co/api/v2/pokemon/" + pokeid, true);
	
	//Step 4 - send it
	xhr.send();
}

function setValues(pokemon) {
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	var pokeimg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
	pokeImg.setAttribute("alt", pokemon.name);
	var endTime = new Date.getTime();
	console.log("Getting this pokemon took " + (endTime-startTime) + "ms.");
}



window.onload = function() {
	document.getElementById("pokeSubmit").addEventListener("click", getPokemon);
	//not using useCapture == undefined = falsey
}
