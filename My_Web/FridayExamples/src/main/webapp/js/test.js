/**
 * Learning JSON format
 * JavaScript Object Notation
 * JSON is text, NOT a JS Object
 */

var myJSON = '{ "name":"Nathan", "age":23, "city":"Milwaukee" }';
var myObj = JSON.parse(myJSON);

console.log(myJSON);
console.log(myObj);

document.getElementById("demo").innerHTML = myObj.name;


function getText() {
	console.log("in getText");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("in onReadyStateChange");
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("in change text");
			document.getElementById("things").innerHTML = xhr.responseText;
		}
	}
	// HTTP method, URL pattern, asynchronous? (always true for AJAX)
	xhr.open("GET", "getText", true);
	xhr.send();
	console.log("end getText");
}

document.getElementById("myButton").addEventListener("click", getText);
