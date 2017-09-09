
$(document).ready(function() {
	document.getElementById("btnLogin").addEventListener("click", login);
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
			var response = request.responseText;
			if (response == "user-not-exist") {
				$('#bad-login-message').innerHTML = "Login failed. Please re-enter email and password";
			}
			if (response == "password-incorrect") {
				$('#bad-login-message').innerHTML = "That email was not found. Please re-enter email";
			}
		}
	}
	request.open("POST", "login", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(transaction);
};