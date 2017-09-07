/**
 * 
 */

$(document).ready(function(){

	document.getElementById("submit").addEventListener("click", login);
});

function login(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("password").value;
	
	var tx = [email, pass];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things
			document.getElementById("message").innerHTML = xhr.responseText;
			
		}
	}
	
	xhr.open("POST", "loginmessagetest", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//Parameters are header and value
	xhr.send(tx);
	
	
	
}
