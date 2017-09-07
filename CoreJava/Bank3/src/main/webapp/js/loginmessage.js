$(document).ready(function() {
	document.getElementById("loginbtn").addEventListener("click", login);
});

function login() {
	var username = document.getElementById("InputUsername").value;
	var pass = document.getElementById("InputPassword").value;
	
	var tx = [username, pass];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("message").innerHTML = xhr.responseText;
		}
	}
	xhr.open("POST", "loginmessagetest", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
};