var logged = false;
$(document).ready(function(){
	loadLoginView();
	//document.getElementById("loginSubmit").addEventListener("click",login);
});

function initLoginView(){
	document.getElementById("loginSubmit").addEventListener("click",login);
}


function login(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("pass").value;
	
	var tx = [email, pass];
	
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
				logged = true;
				console.log(response);
				console.log("calling success function");
				loadDashboardView();
				$("#navbar").show();
			}
		}
	}
	xhr.open("POST","loginmessagetest",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(tx);
};



function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('loginview').innerHTML = xhr.responseText;
			initLoginView();
		}
	}
	xhr.open("GET","getLoginDashboard",true);
	xhr.send();
}
function loadDashboardView(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status ==200){
				document.getElementById('loginview').innerHTML = xhr.responseText;
				getUserInformation();
			}
		}
		xhr.open("GET","getDashboard",true);
		xhr.send();
	}

function getUserInformation(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status ==200){
				console.log(xhr.responseText);
				var dto = JSON.parse(xhr.responseText);
				var user = dto.user;
				var accounts = dto.accounts;
				
				document.getElementById('name').innerHTML = user.firstname + " " +user.lastname;
				
				if(accounts.length == 0){
					
				}
				else{
					for(var i =0; i <accounts.length; i++){
						var table = document.getElementById("accTable");
						var row = table.insertRow();
						var acc = row.insertCell(0);
						var type = row.insertCell(1);
						var bal = row.insertCell(2);
						acc.innerHTML = "Account no.: " + accounts[i].id + " ";
						type.innerHTML = accounts[i].type.name+ " ";
						bal.innerHTML = "$" + accounts[i].balance;
					}
				}
				document.getElementById('info').innerHTML = JSON.stringify(user,null,4);
			}
		}
		xhr.open("GET","getUserInfo",true);
		xhr.send();
	}
