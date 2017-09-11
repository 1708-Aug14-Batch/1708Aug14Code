/**
 * 
 */
log('in uni.js');

function toHome() {
	log('toHome');
	log($('#logout')[0]);

	location.href = $('#logout')[0] ? 'home' : 'login';
}

function addUser() {
	log('addUser');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getadduser', true);
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			
			$('#view').html(xhr.responseText);
		}
	};
	xhr.send();
}

function viewProfile() {
	log('viewProfile');
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getprofile', true);
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			
			$('#view').html(xhr.responseText);
		}
	};
	xhr.send();
}

function logout() {
	log('logout');
	location.href = 'logout';
}

function loadNavbar() {
	'use strict';
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'navbar', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			$('#navContainer').html(xhr.responseText);
			loadNavItems();
			$('#navImg').on('click', toHome);
		}
	};
	xhr.send();
}

function loadNavItems() {
	'use strict';
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'navitems', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			if (xhr.responseText) {

				let items = new DOMParser().parseFromString(xhr.responseText, 'text/html').getElementsByTagName('li');

				while (items.length > 0) {

					$('#navItems').append(items[0]);
				}
				$('#home').on('click', toHome);
				$('#addUser').on('click', addUser);
				$('#profile').on('click', viewProfile);
				$('#logout').on('click', logout);
			}
			
			if (!$('#logout')[0] && !$('#submitLogin')[0]) {

				log('redirecting to login');
				location.href = 'login';
			}
		}
	};
	xhr.send();
}

function log(message) {
	console.log('uni.js -- '+message);
}

