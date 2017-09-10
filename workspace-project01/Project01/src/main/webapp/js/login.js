
$(document).ready(function() {
	document.getElementById("btnLogin").addEventListener("click", login);
});

function login() {
	console.log("Inside login function");
	var email = $('#email').val();
	var password = $('#password').val();
	var transaction = [email, password];
	transaction = JSON.stringify(transaction);
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var responseText = request.responseText;
			if (responseText == "user-not-exist") {
				$('#bad-login-message').innerHTML = "Login failed. Please re-enter email and password";
			} else if (responseText == "password-incorrect") {
				$('#bad-login-message').innerHTML = "That email was not found. Please re-enter email";
			} else {
				window.location.href = request.responseURL;
			}
		}
	}
	request.open("POST", "login", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(transaction);
};