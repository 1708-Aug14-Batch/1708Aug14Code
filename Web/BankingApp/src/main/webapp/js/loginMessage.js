/**
 * 
 */

$(document).ready(function(){
	isLoggedIn();
	
});


function isLoggedIn(){	
	alert("In login Checker");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var dto = JASON.parse(xhr.responseText);
			var id = dto.user.id;
			alert(id);
			if(id == null){
				loadLoginView();
			}
			else{
				loadHomepageView();
			}
		}
	}
	xhr.open("GET", "getsession", true);
	xhr.send();
}

function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('loginSubmit').addEventListener("click", login);
		}
	}
	xhr.open("GET", "getLogin", true);
	xhr.send();	
}


function login(){
	var email = document.getElementById('email').value;
	var pass = document.getElementById('password').value;
	
	var tx  = [email, pass];
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('message').innerHTML = xhr.responseText;
			if(document.getElementById('message').innerHTML == "SUCCESS"){
				loadHomepageView();
			}
		}
	}
	xhr.open("POST", "loginMessage", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
};

function loadHomepageView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('logout').addEventListener("click", logout, true);
			loadDashboardView();
			
		}
	}
	xhr.open("GET", "getHome", true);
	xhr.send();	
}


function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "logout", true);
	xhr.send();	
}

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view1').innerHTML = xhr.responseText;
			getUserInformation();
			getAccountInformation();
		}
	}
	xhr.open("GET", "getDash", true);
	xhr.send();	
}

function getUserInformation(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			document.getElementById('Name').innerHTML = user.firstname+" "+ user.lastname;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();	
}

function getAccountInformation(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var accounts = dto.accounts;
			data = "";
			for(i=0;i<accounts.length;i++){
			data += "<tr>";
			var account = accounts[i];
			data += "<td>" + accounts[i].id + "</td><td>" + accounts[i].accountType.description + "<\/td><td>" + accounts[i].balance;
			data += "</tr>"
			}
			document.getElementById('accounts').innerHTML = data;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

