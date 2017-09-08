/**
 * 
 */

$(document).ready(function(){
	
	document.getElementById("loginSubmit").
	addEventListener("click",login);
	
});


function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;		
			document.getElementById("login")
			.addEventListener("click", login);
		}
	}
	console.log("getting homepage")
	xhr.open("GET", "getLoginView", true);
	xhr.send();
};




function login(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	var tx = [username,password];
	
	tx = JSON.stringify(tx);
	
	
	console.log("top of the morning to ya");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("Ready State: "+xhr.readyState);
		console.log("Status: "+xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200){
			var response =  xhr.responseText;
			console.log("hi there");
			if (response == "fail"){
				document.getElementById("message")
				.innerHTML = "Invalid credentials. Please try again";
			}
			else if(response == "password"){
				document.getElementById("message")
				.innerHTML = "Invalid user. Please try again";
			}
			else{
				//logged = true;
				console.log("THE RESPONSE");
				console.log(response);
				console.log("calling success function");
				successfulLogin(response);// w params
			}
		}
	}
	
	xhr.open("POST","loginmessage",true);
	xhr.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	xhr.send(tx);
	
}







