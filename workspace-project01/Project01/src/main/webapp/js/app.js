
var loggedIn = false;
window.onload = function() {
	loadHomeView();
};

$(document).ready(function() {
	document.getElementById("btnLogout").addEventListener("click", logout);
});

function loadHomeView() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			//$('#view').html = request.responseText;
			document.getElementById("view").innerHTML = request.responseText;
		}
	}
	request.open("GET", "homepage", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
};

function logout() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			window.location.href = request.responseURL;
		}
	}
	request.open("GET", "logout", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
};