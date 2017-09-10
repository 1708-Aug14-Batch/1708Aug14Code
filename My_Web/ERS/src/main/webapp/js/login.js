/**
 * 
 */
console.log('in login.js');

$(document).ready(function () {
	console.log('document ready');
	
	loadNavbar();
	
	$('#submitLogin').on('click', checkCredentials);
});

function checkCredentials() {
	'use strict';
	console.log('submitLogin clicked');

	let email = $('#email').val();
	let password = $('#password').val();

	console.log("email="+email+", password="+password);

	if (!email || !password) {
		console.log('email and password required');
		$('#message').html('You must enter an email and password').show();
		return;
	}

	let data = JSON.stringify([email, password]);
	console.log('data= ' + data);

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'checkCredentials', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				console.log('got response= ' + xhr.responseText);

				if (xhr.responseText) {
					console.log('set message');
					$('#message').html(xhr.responseText).show();

				} else {
					console.log('no response');
					location.href = 'home';
				}
			} else {
				console.log('something went wrong with request= status '+xhr.status);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}
