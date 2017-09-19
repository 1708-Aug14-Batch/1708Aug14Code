/**
 * 
 */
$(document).ready(function(){
	document.getElementById("infoButton").addEventListener("click", updateInfo)
});



function updateInfo(){
	
	var fname = document.getElementById("firstname").value;
	var lname = document.getElementById("lastname").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var passwordTwo = document.getElementById("passwordtwo").value;
	console.log(passwordTwo);
	if(password != passwordTwo){
		$('#firstname').text("");
		$("#lastname").text("");
		$("#email").text("");
		$("#password").text("");
		$("#passwordtwo").text("");
		alert("Please provide a matching password.");
		}
	else{
	var tx = [fname,lname,email,password];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();

	console.log("Gonna make the change");
	xhr.open("POST", "EditUserInfo", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	}
}