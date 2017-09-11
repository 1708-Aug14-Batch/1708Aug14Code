/**
 * 
 */

$(document).ready(function() {
	document.getElementById("login").addEventListener("click", login);
});

function login() {
	console.log("Inside login function");
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var transaction = [email, password];
	transaction = JSON.stringify(transaction);
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			// Write response to message div
			document.getElementById("message").innerHTML = request.responseText;
		}
	}
	request.open("POST", "login-message-test", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(transaction);
};