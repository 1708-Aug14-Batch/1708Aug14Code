/**
 * 
 */

$(document).ready(function(){
	document.getElementById("infoButton").addEventListener("click", updateInfo)
});



function updateInfo(){
	
	var fname = document.getElementById("firstname").value;
	console.log(fname);
	var lname = document.getElementById("lastname").value;
	console.log(lname);
	var email = document.getElementById("email").value;
	console.log(email);
	var password = document.getElementById("password").value;
	console.log(password);
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
	console.log("HERE");
	var tx = [fname,lname,email,password];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			//Do things
//			
//		}
//	}
//	
	console.log("Gonna make the change");
	xhr.open("POST", "EditUserInfo", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	}
}