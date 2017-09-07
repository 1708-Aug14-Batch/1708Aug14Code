/**
 * 
 */
 $('document').ready(function(){
 	$("#login").click(login);
 })

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