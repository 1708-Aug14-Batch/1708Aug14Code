$(document).ready(function(){
	console.log("Hello");
	document.getElementById("loginSubmit").
	addEventListener("click", login);
});

function login(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("password").value;
	
	var transaction = [email, pass];
	transaction = JSON.stringify(transaction);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if (xhr.responseText == "invalid"){
				alert("Invalid user. Please try again.");
			}
			else if (xhr.responseText == "password"){
				alert("Invalid password. Please try again.");
			}
			else
				window.location.href = xhr.responseText;
		}
	};
	
	xhr.open("POST", "loginmessagetest", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(transaction);
};
