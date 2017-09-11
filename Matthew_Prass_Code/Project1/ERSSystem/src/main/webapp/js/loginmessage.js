$(document).ready(function(){
	document.getElementById("submit").addEventListener("click",login);
});


function login(){
	var email = document.getElementById("name").value;
	var pass = document.getElementById("paw").value;
	var username = document.getElementById("username").value;
	
	var tx = [email, pass, username];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response =  xhr.responseText;

			if (response == "fail"){
				document.getElementById("message")
				.innerHTML = "Invalid credentials. Please try again";
			}
			else if(response == "pass"){
				document.getElementById("message")
				.innerHTML = "Invalid user. Please try again";
			}
			else{
				loadEmployeePage();
				console.log(responseText);
			}
		}
	}
	xhr.open("POST","login",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(tx);
};

function loadEmployeePage(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response =  xhr.responseText;
			//console.log(responseText);
		}
	}
	xhr.open("POST","getEmployeePage",true);
	xhr.send();
}


