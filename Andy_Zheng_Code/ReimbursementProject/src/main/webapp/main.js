/*
$(document).ready(function(){
	$('loginRequest()';
})
 var loginRequest = function(){
	$.ajax({
	   type: 'POST',
	   url: '/login',
	   data: {
	      "username" : $('exampleInputEmail1').val,
	      "password" : $('exampleInputPassword1').val
	   },
	   success: function(data) {
	      console.log(data);
	   },
	});
}
*/

/*
function loginRequest(){
	console.log("tacooooo");
	$.ajax({
	   type: 'POST',
	   url: '/login',
	   data: {
	      "username" : $('#email').val(),
	      "password" : $('#password').val()
	   },
	   success: function(data) {
	      console.log(data);
	   },
	});
}
*/

function loginRequest(){
	console.log("hello");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "loadMenuPage", true);
	xhr.send();

}

//$('#login').click(loginRequest);

function loadLoginPage(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
		}
	}
		xhr.open("GET", "loadLoginPage", true);
		xhr.send();
}

function loadMenuPage(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
		}
	}
		xhr.open("GET", "loadMenuPage", true);
		xhr.send();

}

function loadUserPage(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
		}
	}
		xhr.open("GET", "loadUserPage", true);
		xhr.send();
}

// Gets user info and accounts
/*
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
}*/

function loadReimPage(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "loadAccountPage", true);
	xhr.send();
}

/*
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
*/

//document.getElementById("userSettings").addEventListener("click",loadUserSettings);

//document.getElementById("accounts").addEventListener("click",loadMain);

window.onload = function(){
	loadLoginPage();
};

/*
console.log(document.getElementById("login"));
document.getElementById("login").addEventListener("click",loginRequest);
*/



// Views
