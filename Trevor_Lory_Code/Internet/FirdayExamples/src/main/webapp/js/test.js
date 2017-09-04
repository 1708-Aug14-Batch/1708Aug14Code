/*Learning JSON
 * JavaScript Object Notation
 * JSON is text, NOT a JS Object
 */

var myJSON = '{"name" : "Trevor", "Age" : 20, "city" : "Katy"}';

var myObject = JSON.parse(myJSON);
console.log(myJSON);
console.log(myObject);

document.getElementById("demo").innerHTML = myObject.name;

function getText() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("things").innerHTML = xhr.responseText;
		}
	}
	
	xhr.open("GET", "getText", true);
	xhr.send();
}

document.getElementById("myBtn").addEventListener("click", getText, false);
