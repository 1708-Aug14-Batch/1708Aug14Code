/**
 * 
 */

$(document).ready(function(){
	
	document.getElementById("loginSubmit").
	addEventListener("click",login);
	
});

function login(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	var tx = [username,password];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status==200){
			document.getElementById("message").innerHTML = xhr.responseText;
		}
	}
	
	xhr.open("POST","loginmessagetest",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(tx);
	
}