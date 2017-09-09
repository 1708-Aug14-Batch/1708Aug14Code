/**
 * 
 */

$(document).ready(function() {
	document.getElementById("submit").addEventListener("click",login);
});

function login() {
	var email = document.getElementById("email").value;
	var pass = document.getElementById("pass").value;
	
	var to = [email,pass];
	
	to = JSON.stringify(to);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			if(xhr.responseText == "Invalid") {
				document.getElementById("message").innerHTML = "Invalid user. Please try again.";
			}
			else if (xhr.responseText == "Incorrect") {
				document.getElementById("message").innerHTML = "Incorrect password. Please try again.";
			}
			else {
				window.location.href = xhr.responseText;
			}
		}
	}
	xhr.open("POST", "loginmessagetest", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(to);
};