var pokemonVar, startTime;

function getPokemon(){
	var id = document.getElementById("pokemonid").value;
	console.log(id);
	startTime = new Date().getTime(); //how long it take to send request
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			pokemonVar = pokemon;
		}
		
	}
	xhr.open("GET","http://pokeapi.co/api/v2/pokemon/" + id,true);
	xhr.send();
}

function setValues(pokemon){
	document.getElementById("pokemonName").innerHTML = pokemon.name;
	var pokeImg = document.getElementById("pokemonImg");
	pokeImg.setAttribute("src",pokemon.sprites.front_shiny);
	pokeImg.setAttribute("alt",pokemon.name);
	var endTime = new Date().getTime();
	console.log("Gettin this took " + (endTime-startTime));
}

window.onload = function(){
	document.getElementById("pokeSubmit").addEventListener("click",getPokemon);
}

