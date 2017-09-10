/**
 * 
 */
console.log("in home.js")

$(document).ready(function () {
	console.log("document ready");
	
	loadNavbar();
	loadHome();
});

function loadHome() {
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'gethome', true);
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			
			$('#view').html(xhr.responseText);
		}
	};
	
	xhr.send();
}
