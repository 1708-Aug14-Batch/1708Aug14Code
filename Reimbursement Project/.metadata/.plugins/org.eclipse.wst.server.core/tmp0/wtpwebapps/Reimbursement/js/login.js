/*
 * 
 */

$(document).ready(function(){
	
	
	document.getElementById("loginSubmit").
	addEventListener("click",login);
	
});

function login(){
	var email = document.getElementById("email").value;
	var pwd = document.getElementById("pwd").value;
	
	var tx = [email, pwd];
	console.log(email, pwd);
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("in ready state function");
			document.getElementById("message")
			.innerHTML = xhr.responseText;
		}
	}
	
	console.log(tx);
	
	xhr.open("POST", "loginmessagetest", true);
	console.log("opened up post request");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	console.log("sent post request");
	
	
};