/**
 * 
 */



$(document).ready(function(){

	loadDashboardView();
	document.getElementById("submit").addEventListener("click", login);

});


function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
//			getUserInformation();
		}
		
	}
	xhr.open("GET", "loginmessagetest", true);
	xhr.send();
}



function login(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("password").value;
	
	var tx = [email, pass];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things
			document.getElementById("message").innerHTML = xhr.responseText;
			
		}
	}
	
	xhr.open("POST", "loginmessagetest", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//Parameters are header and value
	xhr.send(tx);
	
	
	
}



//Views




//function getUserInformation(){
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			console.log(xhr.responseText);
//			var dto = JSON.parse(xhr.responseText);
//			var user = dto.user;
//			var accounts = dto.reim;
//			document.getElementById("name").innerHTML = user.firstname + " " + user.lastname;
//		}
//	}
//	xhr.open("GET", "getUserInfo", true);
//	xhr.send();
//	
//	
//}

