/**
 * 
 */




$(document).ready(function(){
	console.log("HERE");
		
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var user = JSON.parse(xhr.responseText);
			
			
			
			var table = document.getElementById("list");
			var row = table.insertRow();
			var fname = row.insertCell(0);
			var lname = row.insertCell(1);
			var email = row.insertCell(2);
			console.log(fname + " " + lname + " " + email);
			fname.innerHTML = user.firstname;
			lname.innerHTML = user.lastname;
			email.innerHTML = user.email;
		}
	}
	xhr.open("GET", "UserInformation", true);
	xhr.send();
	
	
	
});