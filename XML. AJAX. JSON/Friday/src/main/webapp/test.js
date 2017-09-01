/**
 *  learning JSON
 *  JavaScript Object Notation
 *  JSON is text, not a JS Object
 *  
 */

// key, value

var myJSON = '{"name":"andy","age":100,"city":"NYC"}';

var myObj = JSON.parse(myJSON);
console.log(myJSON);
console.log(myObj);
$('#demo').text(myObj.name);

function getText(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange=function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("things").innerHTML = xhr.responseText;
		}
	}
	// HTTP METHOD, url pattern, use asynchronous?(always true)
	xhr.open("GET","text",true);

	xhr.send();
}

$('#myButton').click(getText);

//$('#myButton').on('click', getText);