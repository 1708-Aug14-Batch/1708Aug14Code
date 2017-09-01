/**
 * POKEMON JS
 */

 var pokemonVar, startTime;

 function getPokemon(){
 	var id = $('#pokemonID').val();
 	console.log(id);
 	startTime = new Date().getTime(); // start timer

 	//step 1 ajax

 	var xhr = new XMLHttpRequest();

 	// step 2 create function to handle readystatechange
 	xhr.onreadystatechange = function(){
 		if(xhr.readyState = 4 && xhr.status == 200){
 			var pokemon = JSON.parse(xhr.responseText);
 			setValues(pokemon);
 			pokemonVar = pokemon;

 		}
 	}

 	// true is for Asynchronous
 	// step 3 - open
 	xhr.open("GET", "http://pokeapi.co/api/v2/pokemon/" + id, true);
 	xhr.send();
 }

 function setValues(pokemon) {
 	//document.getElementById("pokemonName").innerHTML = pokemon.name;
 	//var pokeImg = document.getElementById("pokemonImg");
 	$('#pokemonName').val(pokemon.name)
 	var pokeImg = $('#pokemonImg');
 	pokeImg.setAttribute("src", pokemon.sprites.front_shiny);
 	pokeImg.setAttribute("alt", pokemon.name);
 	var endtime = new Date().getTime();
 	console.log((endtime-startTime) + "ms");
 }

 window.onload = function () {
 	// not adding useCapture -- undefined = falsey
 	$('#pokemonSubmit').click(getPokemon);

 }