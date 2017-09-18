
$(document).ready(function() {
	document.getElementById("btnLogin").addEventListener("click", login);
});

function login() {
	var email = $('#email').val();
	var password = $('#password').val();
	var transaction = [email, password];
	transaction = JSON.stringify(transaction);
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var responseText = request.responseText;
			if (responseText == "user-not-exist") {
				$('#bad-login-message').html("That email was not found. Please re-enter email");
			} else if (responseText == "password-incorrect") {
				$('#bad-login-message').html("Login failed. Please re-enter  password");
			} else {
				window.location.href = request.responseURL;
			}
		}
	}
	request.open("POST", "login", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(transaction);
};