$(document).ready(function(){
	document.getElementById("submit").addEventListener("click", updateInfo)
});



function updateInfo(){
	
	var fname = document.getElementById("firstname").value;
	var lname = document.getElementById("lastname").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("pass").value;
	var username = document.getElementById("username").value;
	var tx = [fname,lname,email,password,username];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "EditUserInfo", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
}