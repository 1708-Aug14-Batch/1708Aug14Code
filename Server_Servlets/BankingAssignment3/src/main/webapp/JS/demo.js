/**
 * 
 */

window.onload = function() {
	loadDashboardView();
}

// Views
function loadDashboardView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// Replace the "view" div with the xhr response
			document.getElementById("view").innerHTML = xhr.responseText;
			getUserInformation();
		}
	}
	xhr.open("GET", "../getDashboardView", true);
	xhr.send();
}

function getUserInformation() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;

			document.getElementById('name').innerHTML = user.firstName + " "
					+ user.lastName;
		}
	}
	xhr.open("GET", "../getUserInfo", true);
	xhr.send();

}
