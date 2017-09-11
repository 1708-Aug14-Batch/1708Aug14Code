var pageCounter = 1;
var animalContainer = document.getElementById("animal-info");  // the empty div element in index.html
var btn = document.getElementById("btn");
btn.addEventListener("click", function() {
	var ourRequest = new XMLHttpRequest();
	ourRequest.open('GET', 'https://learnwebcode.github.io/json-example/animals-' + pageCounter + '.json');
	ourRequest.onload = function() {
		//var ourData = ourRequest.responseText;  // this only gets a string of data.. it is not JSON
		if(ourData.status >= 200 && ourRequest.status < 400) {
			var ourData = JSON.parse(ourRequest.responseText);  // this parses the responseText into JSON
			renderHTML(ourData);   // pass the JSON string object to the renderHTML function
		} else {
			console.log("We connected but the server responded with an error!");
		}
	};
	
	// handling connection failures ...  done before the send();
	ourRequest.onerror = function() {
		console.log = ("A connection error has occurred!")
	}
	
	ourRequest.send();
	pageCounter++;
	if(pageCounter > 3) {
		btn.classList.add("hide-me");
	}
});

function renderHTML(data) {
	var htmlString = "";
	for(i = 0; i < data.length; i++) {
		htmlString += "<p>" + data[i].name + " is a " + data[i].species + " that likes to eat ";
		for(ii = 0; ii < data[i].foods.likes.length; ii++) {
			if(ii == 0) {
				htmlString += data[i].foods.likes[ii];
			} else {
				htmlString += " and " + data[i].foods.likes[ii];
			}
		}

		htmlString += ' and dislikes ';
		
		for(ii = 0; ii < data[i].foods.dislikes.length; ii++) {
			if(ii == 0) {
				htmlString += data[i].foods.dislikes[ii];
			} else {
				htmlString += " and " + data[i].foods.dislikes[ii];
			}
		}
		
		htmlString += ".</p>";
	}
	animalContainer.insertAdjacentHTML('beforeend', htmlString);
}
