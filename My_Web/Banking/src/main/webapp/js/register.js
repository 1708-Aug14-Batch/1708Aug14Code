/**
 * 
 */

$(document).ready(function() {

	$('#register').on('click', register);
})

function register() {
	console.log("in register");
	
	var firstname = $('#firstname').val();
	var lastname = $('#lastname').val();
	var email = $('#email').val();
	var password = $('#password').val();
	var confirmPw = $('#confirmPw').val();
	
	if (password != confirmPw) {
		console.log("Passwords must match");
		return;
	}
	
	var tx = JSON.stringify([firstname, lastname, email, password]);
	
	var xhr = new XMLHttpRequest();	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
		}
	};
	
	xhr.open('POST', 'confirmregister', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	//xhr.send(tx);
}
