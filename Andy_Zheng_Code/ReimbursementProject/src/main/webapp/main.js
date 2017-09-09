

function loadLogin(){
	$.ajax({
		type: 'GET',
		url: 'loadLogin',
		success: function(response){
			document.getElementById('content').innerHTML = response;
			$('#login').click(loginRequest);
			$('#keyBubble').keypress(function(e){
				if(e.which == 13){
					$('#login').click(loginRequest());
				}
			})
		}
	})
}

function loginRequest(){
 	var email = $('#email').val();
 	var password = $('#password').val();

 	var to =[email,password];

 	to = JSON.stringify(to);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if(xhr.responseText == "0" || xhr.responseText == "1"){
				loadMenu(xhr.responseText);
			}else if(xhr.responseText == "Incorrect Password"){
				document.getElementById('fail').innerHTML = xhr.responseText;
			}else if(xhr.responseText == "Incorrect Credentials"){
				document.getElementById('fail').innerHTML = xhr.responseText;
			}
		}	
	}
	xhr.open("POST", "loginRequest", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
	xhr.send(to);
}

function getUserInfo(){
	$.ajax({
		type: 'GET',
		url: 'userInfo',
		success: function(response){
			//var dto = JSON.parse(response);
			var user = response;
			$('#fn').text(user.fname);
			$('#ln').text(user.lname);
			$('#email').text(user.email);
			$('#password').text(user.pwd);
		}
	})
}

function getReimInfo(){
	$.ajax({
		type: 'GET',
		url: 'reimInfo',
		success: function(response){
			var reim = response;
			var acctTable = document.getElementById('acctTable');
			for(var x = 0; x<reim.length; x++){
				var row = acctTable.insertRow(x+1);
				var col1 = row.insertCell(0);
				var col2 = row.insertCell(1);
				var col3 = row.insertCell(2);
				var col4 = row.insertCell(3);
				var col4 = row.insertCell(4);
				var col4 = row.insertCell(5);
				var col4 = row.insertCell(6);

				col1.innerHTML = accounts[x].reimID;
				col2.innerHTML = accounts[x].submitterID;
				col3.innerHTML = accounts[x].user.fname + " " + accounts[x].user.lname;
				col4.innerHTML = accounts[x].type.type;
				console.log(accounts[x]);
			}
		}
	})
}

function registerEmployee(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
 	var email = $('#email').val();
 	var password = $('#password').val();

 	var to = [fn,ln,email,password];

 	to = JSON.stringify(to);

	$.ajax({
		type: 'POST',
		url: 'registerEmployee',
		data: to,
		dataType: 'JSON',
		success: function(response){
			if(response == "Employee Registered"){
				alert("Employee Registered");	
			}else if(response == "Failed Registration"){
				alert("Failed Registration");	
			}
		}
	})
}

function submitReim(){
	var description = $('#description').val();
	var amount = $('#amount').val();

 	var to = [description,amount];

 	to = JSON.stringify(to);
 	$.ajax({
 		type: 'POST',
 		url: 'submitReim',
 		data: to,
 		dataType: 'JSON',
 		success: function(response){
			if(response == "Reimbursement Submitted"){
				alert("Reimbursement Submitted");
 			}
 		}
	})
}

function loadMenu(value){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
			loadHome();
			if(value == "0"){
				$('#five').click(loadSubmitReim);
			}else if(value == "1"){
				$('#five').click(loadRegisterEmployee);
			}
			//$('#one').click(loadHome);
			$('#two').click(loadUser);
			$('#three').click(loadUpdateUser);
			$('#four').click(loadReim);
			$('#six').click(loadLogin);
		}
	}
	xhr.open("GET", "loadMenu", true);
	xhr.send();
}

function loadHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "loadHome", true);
	xhr.send();
}

function loadUser(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			getUserInfo();
		}
	}
	xhr.open("GET", "loadUser", true);
	xhr.send();
}

function loadUpdateUser(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "loadUpdateUser", true);
	xhr.send();

}

function loadReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#reim').DataTable();
		}
	}
	xhr.open("GET", "loadReim", true);
	xhr.send();
}

function loadRegisterEmployee(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#register').click(registerEmployee);
		}
	}
	xhr.open("GET", "loadRegisterEmployee", true);
	xhr.send();
}

function loadSubmitReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#submit').click(submitReim);
		}
	}
	xhr.open("GET", "loadSubmitReim", true);
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

$(document).ready(function(){
	loadLogin();
});

/*
console.log(document.getElementById("login"));
document.getElementById("login").addEventListener("click",loginRequest);
*/



// Views
