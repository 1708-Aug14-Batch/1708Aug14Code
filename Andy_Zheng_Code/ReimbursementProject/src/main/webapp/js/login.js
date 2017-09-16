// ....

function loadLogin(){
	$.ajax({
		type: 'GET',
		url: 'loadLogin',
		success: function(response){
			document.getElementById('content').innerHTML = response;
			$('#login').click(loginRequest);
			$('#loginKey').keypress(function(e){
				if(e.which == 13){
					loginRequest();
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

$(document).ready(function(){
	loadLogin();
});