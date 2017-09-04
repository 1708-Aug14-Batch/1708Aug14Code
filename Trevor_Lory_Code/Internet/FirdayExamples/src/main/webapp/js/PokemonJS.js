var pokemonVar, startTime;

function getPokemon() {
	
	var id = document.getElementById("pokemonid").value;
	console.log("poke id = " + id);
	startTime = new Date().getTime(); //start timer to see how long it takes to fetch information
	
	//Step 1 of AJAX REQUEST -- OPEN XHR
	var xhr = new XMLHttpRequest();
	
	//Step 2 -- create function to handle readystatechange
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	}
	
	//step 3 -- Open
	xhr.open("GET", "http://pokeapi.co/api/v2/pokemon/" + id, true);
	
	//step 4 -- send it
	xhr.send();
}

function setValues(pokemon) {
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	var PokeImg = document.getElementById("pokemonImg");
	PokeImg.setAttribute("src", pokemon.sprites.front_shiny);
	PokeImg.setAttribute("alt", pokemon.name);
	var endTime = new Date().getTime();
	console.log("Getting this pokemon took " + (endTime - startTime) + "ms.");
}

window.onload = function() {
	document.getElementById("pokeSubmit").addEventListener("click", getPokemon);
	// not adding useCapture -- undefinded = falsy
}