/**
 * 
 */
log('begin');

function loadNavbar() {
	'use strict';
	log('in loadNavbar');
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'navbar', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			$('#navContainer').html(xhr.responseText);
			loadNavItems();
			$('#navImg').on('click', function () { location.href = 'home' });
		}
	};
	xhr.send();
}

function loadNavItems() {
	'use strict';
	log('in loadNavItems');
	
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
				$('#addUser').on('click', loadAddUser);
				$('#profile').on('click', loadProfile);
				$('#logout').on('click', logout);
				
				if ($('#addUser')[0]) {
					$('#empListCheck').show();
				} else {
					$('#newExpense').show();
				}
			}

			log('logout= '+ !$('#logout')[0]+', subLogin= '+!$('#submitLogin')[0]);
			if (!$('#logout')[0] && !$('#submitLogin')[0]) {

				log('redirecting to login');
				location.href = 'login';
			}
		}
	};
	xhr.send();
}

function checkHome() {
	'use strict';
	log('check if menu selected on login');
	if (location.href.split('/').pop() === 'login') {
		log('go to home first');
		toHome();
	}
}

function toHome() {
	'use strict';
	log('toHome');

	if ($('#logout')[0]) {
		if (location.href.split('/').pop() === 'login') {

			location.href =  'home';
		} else {

			loadHome();
		}
	} else {
		location.href = 'login';
	}
}

function loadAddUser() {
	'use strict';
	log('loadAddUser');
	
	checkHome();
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getadduser', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			$('#view').html(xhr.responseText);
			doAddUser();
		}
	};
	xhr.send();
}

function loadProfile() {
	'use strict';
	log('loadProfile');
	checkHome();
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getprofile', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			$('#view').html(xhr.responseText);
			doViewProfile();
		}
	};
	xhr.send();
}

function logout() {

	log('logout');
	location.href = 'logout';
}

function log(message) {

	console.log('uni.js -- '+message);
}

