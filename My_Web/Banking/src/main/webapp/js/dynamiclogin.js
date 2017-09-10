/**
 * 
 */

function initDynamicLogin() {

	$('#login').on('click', login);
}

function login() {
	var email = $('input#email').val();
	var password = $('input#password').val();
	
	var tx = JSON.stringify([email, password]);
	
	var xhr = new XMLHttpRequest();	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			$('#message').html(xhr.responseText);
		}
	};
	
	xhr.open('POST', 'getmessage', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send(tx);
}
