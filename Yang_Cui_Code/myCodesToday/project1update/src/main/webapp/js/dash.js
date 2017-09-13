/**
 * 
 */
var logged = false;
window.onload = function(){

	loadHomeView();
};

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			document.getElementById('homeview').innerHTML = xhr.responseText;
			console.log($("#login"));
			document.getElementById("login").addEventListener("click", login);
		}
	}
	console.log("getting homepage")
	xhr.open("GET", "getLoginView", true);
	xhr.send();
};

function login(){
	var uname = document.getElementById("uname").value;
	var pass = document.getElementById("pass").value;
	var tx = [uname, pass];
	tx = JSON.stringify(tx);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("got login response");
			var response =  xhr.responseText;

			if (response == "fail"){
				document.getElementById("message").innerHTML = "Invalid credentials. Please try again";
				console.log("login fial");
			}
			else if(response == "pass"){
				document.getElementById("message").innerHTML = "Invalid user. Please try again";
				console.log("login fial");
			}
			else{
				logged = true;
				console.log(response);
				loadDashView();
			}
		}
	}

	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(tx);
};

function loadDashView(){
	console.log("in load dashboard view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('homeview').innerHTML = xhr.responseText;

		}
	}
	console.log("getting dash");
	xhr.open("GET", "getDashboard", true);
	xhr.send();
};