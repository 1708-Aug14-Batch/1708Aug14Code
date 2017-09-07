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

function loadLogin(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
			$('#login').click(loginRequest);
		}
	}
	xhr.open("GET", "loadLogin", true);
	xhr.send();
}

function loginRequest(){
 	var email = $('#email').val();
 	var password = $('#password').val();

 	var to =[email,password];

 	to = JSON.stringify(to);
/*
 	$.ajax({
 		type: "POST",
 		url: "loginRequest",
 		data:to,
		contentType: "application/json",
 		success: function (data){
 			if(data.success){
 				loadMenu();
 			}
 		},
 		error: function (data){
 			console.log(data);
 			if(data == "2"){
				document.getElementById('fail').innerHTML = xhr.responseText;
			}else{
				document.getElementById('fail').innerHTML = xhr.responseText;
			}
 		}
 	});


 		data:{
 			email: $('#email').val(),
 			password: $('#password').val()
 		},
 		dataType : "json",


*/

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			if(xhr.responseText == 1){
				document.getElementById('content').innerHTML = xhr.responseText;
				loadMenu();
			}else if(xhr.responseText == 2){
				document.getElementById('fail').innerHTML = xhr.responseText;
			}else{
				document.getElementById('fail').innerHTML = xhr.responseText;
			}
		}	
	}
	xhr.open("POST", "loginRequest", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
	xhr.send(to);
/*
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
			loadMenu();
		}
	}
	xhr.open("GET", "loadMenu", true);
	xhr.send();
	*/
}


function getUserInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			console.log(dto);
			var use = dto.user;
			//document.getElementById('name').innerHTML = dto.user.fname + " " + dto.user.lname;
			document.getElementById('fn').innerHTML = use.fname;
			document.getElementById('ln').innerHTML = use.lname;
			document.getElementById('email').innerHTML = use.email;
			}
		}
		xhr.open("GET", "userInfo", true);
		xhr.send();
}

//document.getElementById("login").addEventListener("click",loginRequest);

//$('#login').click(loginRequest);

function loadMenu(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
			loadHome();
			$('#one').click(loadHome);
			$('#two').click(loadUser);
			$('#three').click(loadUpdateUser);
			$('#four').click(loadReim);
			$('#five').click(loadSubmitReim);
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
		}
	}
	xhr.open("GET", "loadReim", true);
	xhr.send();
}

function loadSubmitReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
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
