
var loggedIn = false;
window.onload = function() {
	loadHomeView();
};

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