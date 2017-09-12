/**
 * 
 */
log('in login.js');

$(document).ready(function () {
	log('document ready');

	loadNavbar();

	$('#submitLogin').on('click', checkCredentials);
});

function checkCredentials() {
	'use strict';
	log('submitLogin clicked');

	let email = $('#email').val();
	let password = $('#password').val();

	log("email="+email+", password="+password);

	if (!email || !password) {
		log('email and password required');
		$('#message').html('You must enter an email and password').show();
		return;
	}

	let data = JSON.stringify([email, password]);
	log('data= ' + data);

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'checkCredentials', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			log('got response= ' + xhr.responseText);

			if (xhr.responseText) {
				log('set error message');
				$('#message').html(xhr.responseText).show();

			} else {
				log('no error on login');
				location.href = 'home';
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function log(message) {
	console.log('login.js -- '+message);
}

