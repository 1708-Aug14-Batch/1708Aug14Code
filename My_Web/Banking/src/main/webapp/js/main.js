/**
 * 
 */

$(document).ready(function() {
	
	getLoginFragment();
});

function getLoginFragment() {
	console.log("in getLoginFragment");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			$('#content').html(xhr.responseText);
			initDynamicLogin();
		}
	}
	xhr.open('POST', 'getlogin', true);
	xhr.send();
};
