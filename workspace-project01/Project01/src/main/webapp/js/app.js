
var loggedIn = false;
window.onload = function() { 
	//loadHomeView();
};

$(document).ready(function() {
	$('#btnViewPending').click(viewPending);
	$('#btnMyInfo').click(viewMyInfo);
	$('#btnLogout').click(logout);
});

function loadHomeView() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			document.getElementById("view").innerHTML = request.responseText;
		}
	}
	request.open("GET", "homepage", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
};

function viewPending() {
	console.log("Inside view pending");
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			$('#view').innerHTML = request.responseText;
			var dto = JSON.parse(request.responseText);
			var user = dto.user;
			var reimbs = dto.pendingReimbs;

			if (reimbs.length == 0) {
				console.log("Reimbs of length 0");
				$('#reimbsTable').hide();
			} else {
				console.log("Displaying reimbs");
				for(var i = 0; i < reimbs.length; i++){
					var table = $('#reimbsTable');
					var row = table.insertRow();
					var submitted = row.insertCell(0);
					var description = row.insertCell(1);
					var amount = row.insertCell(2);
					submitted.innerHTML = reimbs[i].dateSubmitted;
					description.innerHTML = reimbs[i].description;
					amount.innerHTML = "$" + reimbs[i].amount;
				}
			}
		}
	}
	request.open("GET", "employee-pending-reimbs", true);
	request.send();
}

function sendRequest(servlet) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			$('#view').innerHTML = request.responseText;
		}
	}
	request.open("GET", servlet, true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function viewMyInfo() {
	sendReqest("employee-view-info");
}

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
