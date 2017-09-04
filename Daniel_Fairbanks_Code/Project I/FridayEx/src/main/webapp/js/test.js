var myJSON = '{ "name" : "Daniel", "age" : 24, "city" : "Permberville" }';
var myObj = JSON.parse(myJSON);

console.log(myJSON);
console.log(myObj);

document.getElementById("demo").innerHTML = myObj.name;

function getText() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("things").innerHTML =
				xhr.responseText;
		}
	}
	xhr.open("GET", "getText", true); //HTTP method, url-pattern, use asynchronously
	xhr.send(); 
}
document.getElementById("myBtn").addEventListener("click", getText, false);