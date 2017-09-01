//learning JSON
//JS Object notation
//JSON is text, NOT a JS object

var myJSON = '{"name" : "Matt", "age" : 100, "city" : "Annapolis"}';

var myObject = JSON.parse(myJSON);
console.log(myJSON);
console.log(myObject);

document.getElementById("demo").innerHTML = myObject.name;

function getText(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("things").innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "getText", true);
	xhr.send();
}

document.getElementById("mybtn").addEventListener("click",getText);