/**
 * 
 */



var pokemonVar, startTime;

function getPokemon(){
	
	var id = document.getElementById("pokemonId").value;
	console.log("pokeID: " +id);
	startTime = new Date().getTime(); // start a timer rn
	
	//step 1 of AJAX Request - open XHR
	var xhr = new XMLHttpRequest();
	
	//step 2 create function to handle ready state change
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
	}
	
	///step 3 - Open & concantonate id t othe end
	xhr.open("GET", "http://pokeapi.co/api/v2/pokemon/"+id, true);
	
	//Step 4 - send it
	xhr.send();
}

function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("src",pokemon.sprites.front_shiny);
	pokeImg.setAttribute("alt",pokemon.name);
	var endTime = new Date().getTime();
	console.log("This pokemonster took "+(endTime - startTime)+"ms ");
	
}

window.onload = function(){
	document.getElementById("pokesubmit").addEventListener("click", getPokemon);
}

