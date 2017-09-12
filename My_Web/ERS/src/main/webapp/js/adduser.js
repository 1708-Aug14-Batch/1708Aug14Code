/**
 * 
 */

function doAddUser() {
	
	$('#firstname').on('keyup', checkFirst);
	$('#lastname').on('keyup', checkLast);
	$('#email').on('keyup', checkEmail);
	$('#password').on('keyup', checkPassword);
	$('#confirmPw').on('keyup', checkConfirm);
	$('#register').on('click', register);
}

function register() {
	'use strict';
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'adduser', true);
	
	let email = $('#email').val();
	let password = $('#password').val();
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

function checkFirst() {
	
	let firstname = $('#firstname').val().trim();
	log(firstname);
	if (!/[!@#$%^&*(){}[\\\]_+=|:;'"<,>.?/]/g.test(firstname)) {
		
	}
}

function checkLast() {

	let lastname = $('#lastname').val().trim();
	log(lastname);
	if (!/[!@#$%^&*(){}[\\\]_+=|:;'"<,>.?/]/g.test(lastname)) {
		
	}
}

function checkEmail() {

	let firstname = $('#firstname').val().trim();
	log(firstname);
	if (!/[]/g.test(firstname)) {
		
	}
}

function checkPassword() {

	let password = $('#password').val().trim();
	log(password);
	if (!/[]/g.test(password)) {
		
	}
}

function checkConfirm() {

	let confirmPw = $('#confirmPw').val().trim();
	log(confirmPw);
	if (!/[]/g.test(confirmPw)) {
		
	}
}


function log(message) {
	
	console.log('adduser.js -- '+message);
}

