/* learning JSON
 * JavaScript Object Notation 
 * JSON is text, NOT a JS Object
 */

var myJSON = 
	'{ "name" : "Genesis", "age" : 100, "city" : "NYC" }';

var myObj = JSON.parse(myJSON);
console.log(myJSON);
console.log(myObj);

document.getElementById("demo").innerHTML = myObj.name;

function getText(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("things").innerHTML = 
				xhr.responseText;
		}
	}
	// HTTP method, urlpattern, use Asynchronous? (always true)
	xhr.open("GET", "getText", true);
	xhr.send();	
}

	document.getElementById("myBtn").addEventListener("click", getText);
