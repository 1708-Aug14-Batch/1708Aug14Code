/**
 * 
 */
console.log("in asdfasgadfsdf uni.js");

function logout() {
	console.log("in logout");
	location.href = 'logout';
}

function toHome() {
	console.log("in toHome");
	console.log($('#logout')[0]);

	location.href = $('#logout')[0] ? 'home' : 'login';
}

function loadNavbar() {
	'use strict';
	console.log('in loadNavbar');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'navbar', true);
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			$('#navContainer').html(xhr.responseText);
			loadNavItems();

			console.log($('#navImg')[0]);
			$('#navImg').on('click', toHome);
		}
	};
	xhr.send();
}

function loadNavItems() {
	'use strict';

	let xhr = new XMLHttpRequest();
	console.log('let xhr');
	xhr.open('POST', 'navitems', true);
	console.log('xhr.open');
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			console.log('loadNavItems response received');

			if (xhr.responseText) {

				let items = new DOMParser().parseFromString(xhr.responseText, 'text/html').getElementsByTagName('li');
				while (items.length > 0) {

					$('#navItems').append(items[0]);
				}

				$('#logout').on('click', logout);
			}
			if (!$('#logout')[0] && !$('#submitLogin')[0]) {
				console.log(location.href);
				location.href = 'login';
			}
		}
	};
	xhr.send();
	console.log('loadNavItems request sent');
}
