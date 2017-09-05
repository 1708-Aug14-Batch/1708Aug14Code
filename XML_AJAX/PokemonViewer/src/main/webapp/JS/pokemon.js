/*
 * **** POKEMON JS
 */

var pokemonVar, startTime;

function getPokemon(){
	
	var id = document.getElementById("pokemonId").value;
	console.log("poke id = " + id);
	startTime = new Date().getTime(); // start timer to see how long it takes to send each request
	
	//STEP 1 OF AJAX REQUEST -- OPEN XHR
	var xhr = new XMLHttpRequest();
	
	//Step 2 - create function to handle readystatechange
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
			// why not just use pokemonVar
		}
	}
	
	//Step 3 - Open
	xhr.open("GET", 
			"http://pokeapi.co/api/v2/pokemon/" + id,true);
	//Step 4 - send it 
	xhr.send();
	
}

function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
	pokeImg.setAttribute("alt", pokemon.name);
	var endTime = new Date().getTime();
	console.log("Getting this pokemon took " +
			(endTime-startTime) + " ms."); 
}


window.onload = function(){
	document.getElementById("pokeSubmit")
		.addEventListener("click", getPokemon);
	// not adding useCapture -- undefined = falsy
}