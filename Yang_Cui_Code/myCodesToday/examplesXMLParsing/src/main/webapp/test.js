/**
 * LEARNING JSON
 * JavaScript Object Notation
 * JSON is text, NOT a JS Object
 */

var myJSON='{"name" : "Genesis", "age" : 100, "city" : "NYC"}';
var myObject=JSON.parse(myJSON);
console.log(myJSON);
console.log(myObject);
document.getElementById("demo").myObject.name;

/*
var cities = ["NYC", "Herndon", "Arlingtion", "DC", "Houston"];
cities.length;
var test=cities.join(",");
cities.pop();
cities.push("Montreal");
cities.shift();
cities.unshift();
cities[2]="Reston";
delete cities[2]; // leaves [2] undefined
cities.splice(2,2)// removes [2]
cities.toString();
cities.sort();
cities.reverse();
cities.sort().reverse();
*/

function getText(){
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById("things").innerHTML=xhr.responseText;
		}
	}
	xhr.open("GET", "getText", true);
	// HTTP method, url pattern, use Asynchronous always true
	xhr.send();
}

document.getElementById("myBtn").addEventListener("click",getText,false); // event function  use-capture