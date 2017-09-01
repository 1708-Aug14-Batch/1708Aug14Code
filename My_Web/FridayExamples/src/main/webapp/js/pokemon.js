/**
 * 
 */

 var pokemon, start;

 function getPokemon() {

    var id = parseInt($('#pokemonId').val());
    console.log("id = " + id);
    start = new Date().getTime();

    // STEP 1: OPEN XMLHttpRequest
    var xhr = new XMLHttpRequest();

    // STEP 2: Handle onreadystatechange
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log("in readystatechanged");
            pokemon = JSON.parse(xhr.responseText);
            setValues(pokemon);
            console.log(new Date().getTime() - start + " ms");
        }
    };

    // STEP 3: Open
    xhr.open("GET", "http://pokeapi.co/api/v2/pokemon/" + id, true);

    // STEP 4: Send
    xhr.send();
 }

 function setValues(pokemon) {
    $('#pokemonName').text(pokemon.name);
    $('#pokemonImg').attr('src', pokemon.sprites.front_shiny);
    $('#pokemonImg').attr('alt', pokemon.name);
 }

window.onload = function() {
    document.getElementById('pokeSubmit').addEventListener('click', getPokemon);
}
