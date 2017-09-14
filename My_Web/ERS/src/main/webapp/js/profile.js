
'use strict';

function doViewProfile() {
	'use strict';
	log('doViewProfile');
	doLoadInformation();

	$('#editFullname').on('click',	function () { $('.fullnameInput').toggle().val(null); });
	$('#cancelFullname').on('click',function () {
		$('.fullnameInput').toggle();
	});
	$('#updateFullname').on('click',function () {
		let first = $('#newFirst').val().trim();
		let last = $('#newLast').val().trim();
		$('.fullnameInput').toggle();
		updateInfo('fullname', first+'XQX'+last);
	});
	$('#editEmail').on('click',		function () { $('.emailInput').toggle().val(null); });
	$('#cancelEmail').on('click',	function () { $('.emailInput').toggle(); });
	$('#updateEmail').on('click',	function () {
		let newEmail = $('#newEmail').val().trim();
		$('.emailInput').toggle();
		updateInfo('email', newEmail);
	});
	$('#editPassword').on('click',	function () { $('.passwordInput').toggle().val(null); });
	$('#cancelPassword').on('click',function () {
		$('.passwordInput').toggle();
	});
	$('#updatePassword').on('click',function () {
		let newPassword = $('#newPassword').val().trim();
		$('.passwordInput').toggle();
		updateInfo('password', newPassword);
	});
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
		}
	};
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(data);
}

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

