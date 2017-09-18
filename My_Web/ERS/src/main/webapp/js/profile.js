
'use strict';

function doViewProfile() {
	'use strict';
	log('doViewProfile');
	doLoadInformation();

	$('#editFullname').on('click',	function () { $('.fullnameInput').toggle().val(null); });
	$('#cancelFullname').on('click',function () {
		$('.fullnameInput').toggle();
		$('#nameMessage').hide();
	});
	$('#updateFullname').on('click',function () {
		let first = $('#newFirst').val().trim();
		let last = $('#newLast').val().trim();
		if (!first || !last) {
			$('#nameMessage').text('Please enter a first and last name').show();
			return;
		}
		if (!isValidName(first)) {
			$('#nameMessage').text('Please enter a valid first name').show();
			return;
		}
		if (!isValidName(last)) {
			$('#nameMessage').text('Please enter a valid last name').show();
			return;
		}
		$('.fullnameInput').toggle();
		$('#nameMessage').hide();
		updateInfo('fullname', first+'XQX'+last);
	});
	$('#editEmail').on('click',		function () { $('.emailInput').toggle().val(null); });
	$('#cancelEmail').on('click',	function () {
		$('.emailInput').toggle();
		$('#emailMessage').hide();
	});
	$('#updateEmail').on('click',	function () {
		let newEmail = $('#newEmail').val().trim();
		if (!newEmail) {
			$('#emailMessage').text('Please enter an email address').show();
			return;
		}
		if (!isValidEmail(newEmail)) {
			$('#emailMessage').text('Invalid email address').show();
			return;
		}
		$('.emailInput').toggle();
		$('#emailMessage').hide();
		updateInfo('email', newEmail);
	});
	$('#editPassword').on('click',	function () { $('.passwordInput').toggle().val(null); });
	$('#cancelPassword').on('click',function () {
		$('.passwordInput').toggle();
		$('#passwordMessage').hide();
	});
	$('#updatePassword').on('click',function () {
		let currentPassword = $('#currentPassword').val().trim();
		if (!currentPassword) {
			$('#passwordMessage').text('Please enter your current password').show();
			return;
		}
		if (checkCurrentPassword(currentPassword)) {
			$('#passwordMessage').text('Current password incorrect').show();
			return;
		}
		let newPassword = $('#newPassword').val().trim();
		let confirmPassword = $('#confirmPassword').val().trim();
		if (!newPassword) {
			$('#passwordMessage').text('Please enter a new password').show();
			return;
		}
		if (!confirmPassword) {
			$('#passwordMessage').text('Please confirm the new password').show();
			return;
		}
		if (newPassword !== confirmPassword) {
			$('#passwordMessage').text('New password doesn\'t match').show();
			$('#confirmPassword').val(null);
			return;
		}
		$('.passwordInput').toggle();
		$('#passwordMessage').hide();
		updateInfo('password', newPassword);
	});
}

function isValidName(name) {
	return /^[^\u0060~!@#$%^&*()_+={}|[\]\\:;\u0022\u0027<,>.?\/]+$/g.test(name);
}

function isValidEmail(email) {
	return /^\S+(\.\S)*@\S+(\.\S+)+$/g.test(email);
}

function updateInfo(type, newValue) {
	'use strict';
	log('updateInfo(type= '+type+', newValue= '+newValue+')');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'updateinfo', true);

	let data = JSON.stringify([type, newValue]);
	log('update data= '+data);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			log("update info received");
			doLoadInformation();
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

function checkCurrentPassword(password) {
	'use strict';
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'checkpassword', false);
	
	let data = JSON.stringify([password]);
	let response;
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			
			response = xhr.responseText;
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
	
	return response;
};

function doLoadInformation() {
	'use strict';
	log('doLoadInformation');

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'getuserinfo', true);

	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {

			log(xhr.responseText);
			let user = JSON.parse(xhr.responseText);
			let first = user.firstName;
			let last = user.lastName;
			let end = last.endsWith('s') ? '\'' : '\'s';
			$('#fullname').text(first+' '+last+end);
			$('#userFullname').text(first+' '+last);
			$('#userEmail').text(user.email);
		}
	};
	xhr.send();
}

function log(message) {
	'use strict';
	console.log('profile.js -- '+message);
}

