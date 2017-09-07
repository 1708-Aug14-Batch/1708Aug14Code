/**
 * 
 */

window.onload = function() {
	loadDashBoardView();
}

// Views
function loadDashBoardView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInformation();
		}
	}
	xhr.open("GET", "getDashboard", true);
	xhr.send();
}

function getUserInformation() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			document.getElementById('name').innerHTML = user.firstname + " " + user.lastname;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}