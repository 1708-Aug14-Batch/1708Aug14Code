/**
 * 
 */



function loadMain(){

/*
	$.ajax({url: "getMain",
		type: 'GET', 
		success: function(data){
			$('#view').text() = data;
		}});

*/

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInfo();
			//$('#view').text() = xhr.responseText;
		}
	}
		xhr.open("GET", "getMain", true);
		xhr.send();
}

function loadLogin(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
 			$("#login").click(login);
			//$('#view').text() = xhr.responseText;
		}
	}
		xhr.open("GET", "getLogin", true);
		xhr.send();
}

 function login(){
 	var email = $('#email').val();
 	var password = $('#password').val();

 	var to =[email,password];

 	to = JSON.stringify(to);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			document.getElementById('fail').innerHTML = xhr.responseText;
		}	
	}
	xhr.open("POST", "testLogin", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
	xhr.send(to);

 }

// really acccounts
function getUserInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			console.log(accounts[0]);
			document.getElementById('name').innerHTML = dto.user.fname + " " + dto.user.lname;

			var acctTable = document.getElementById('acctTable');
			for(var x = 0; x<accounts.length; x++){
				var row = acctTable.insertRow(x+1);
				var col1 = row.insertCell(0);
				var col2 = row.insertCell(1);
				var col3 = row.insertCell(2);
				var col4 = row.insertCell(3);

				col1.innerHTML = accounts[x].accountID;
				col2.innerHTML = accounts[x].balance;
				col3.innerHTML = accounts[x].user.fname + " " + accounts[x].user.lname;
				col4.innerHTML = accounts[x].type.type;
				console.log(accounts[x]);
			}
		}
	}
		xhr.open("GET", "getUserInfo", true);
		xhr.send();
}

function loadUserSettings(){
	console.log("gettingusersetting");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("inside userSettings")
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserSettings();
		}
	}
	xhr.open("GET", "getUserSettings", true);
	xhr.send();
}

function getUserSettings(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var use = dto.user;
			document.getElementById('name').innerHTML = dto.user.fname + " " + dto.user.lname;

			document.getElementById('fn').innerHTML = use.fname;
			document.getElementById('ln').innerHTML = use.lname;
			document.getElementById('email').innerHTML = use.email;
			}
		}

		xhr.open("GET", "getUserInfo", true);
		xhr.send();
}

document.getElementById("userSettings").addEventListener("click",loadUserSettings);

document.getElementById("accounts").addEventListener("click",loadMain);

$(document).ready(function(){
	loadLogin();
});




// Views
