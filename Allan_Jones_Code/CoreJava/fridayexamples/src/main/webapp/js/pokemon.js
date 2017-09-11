

var pokemonVar, startTime;

function getPokemon() {
	var id = document.getElementById("pokemonId").value;
	console.log("poke id = " + id);
	startTime = new Date().getTime();
	
	//Step 1 of AJAX request
	var xhr = new XMLHttpRequest();
	
	//Step 2
	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	}
	
	//Step 3 - Open
	xhr.open("Get", "http://pokeapi.co/api/v2/pokemon/" + id, true);
	
	//Step 4 - send it
	xhr.send();
	
}

function setValues(pokemon) {
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
	pokeImg.setAttribute("alt", pokemon.name);
	var endTime = new Date().getTime();
	console.log("Getting this pokemon took " + (endTime-startTime) + " ms.");
}

window.onload = function() {
	document.getElementById("pokeSubmit").addEventListener("click", getPokemon);
}