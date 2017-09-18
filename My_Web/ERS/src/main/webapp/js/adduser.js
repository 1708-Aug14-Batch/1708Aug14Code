/**
 * 
 */

function doAddUser() {

	$('#register').on('click', register);
}

function register() {
	'use strict';

	if (checkFirst() && checkLast() && checkEmail() && checkPassword()) {

		let xhr = new XMLHttpRequest();
		xhr.open('POST', 'adduser', true);

		let email = $('#email').val();
		let password = $('#newPassword').val();
		let first = $('#firstname').val();
		let last = $('#lastname').val();
		let isManager = $('#isManager')[0].checked.toString();

		let data = JSON.stringify([email, password, first, last, isManager]);

		xhr.onreadystatechange = function () {
			if (xhr.readyState === 4 && xhr.status === 200) {			
				if (xhr.responseText) {

					log('Failed to create user '+first+' '+last);
					$('#message').html(xhr.responseText).show();

				} else {
					log('successfully created '+first+' '+last);
					location.href = 'home';
				}

			}
		};
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xhr.send(data);
	}
}

function checkFirst() {
	'use strict';
	let firstname = $('#firstname').val().trim();
	log(firstname);
	let goodFirst = isValidName(firstname);
	log('good first= '+goodFirst);
	if (!goodFirst) {
		$('#userMessage').text('Invalid first name').show();
	}
	return goodFirst;
}

function checkLast() {
	'use strict';
	let lastname = $('#lastname').val().trim();
	log(lastname);
	let goodLast = lastname && isValidName(lastname);
	log('good last= '+goodLast);
	if (!goodLast) {
		$('#userMessage').text('Invalid last name').show();
	}
	return goodLast;
}

function checkEmail() {
	'use strict';
	let email = $('#email').val().trim();
	log(email);
	let goodEmail = email && isValidEmail(email);
	log('good email= '+goodEmail);
	if (!goodEmail) {
		$('#userMessage').text('Invalid email address').show();
	}
	return goodEmail;
}

function checkPassword() {
	let newPassword = $('#newPassword').val().trim();
	if (!newPassword) {
		$('#userMessage').text('Please enter a password').show();
		return false;
	}
	let confirmPassword = $('#confirmPw').val().trim();
	let goodPassword = newPassword === confirmPassword;
	log('good password= '+goodPassword);
	if (!goodPassword) {
		$('#userMessage').text('Passwords don\'t match').show();
	}
	return goodPassword;
}

function log(message) {

	console.log('adduser.js -- '+message);
}

