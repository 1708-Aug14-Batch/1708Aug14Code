
var loggedIn = false;
window.onload = function() { 
	//loadHomeView();
};

$(document).ready(function() {
	$('#btnViewMyReimbs').click(viewMyReimbs);
	$('#btnMyInfo').click(viewMyInfo);
	$('#btnLogout').click(logout);
});

function loadHomeView() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
		}
	}
	request.open("GET", "homepage", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
};

function viewMyReimbs() {
	console.log("Inside viewMyReimbs");
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			console.log(request.responseText);
			$('#view').html(request.responseText);
			//getMyReimbs();
		}
	}
	request.open("GET", "employee-view-all-reimbs", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function getMyReimbs() {
	console.log("Inside getMyReimbs");
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			console.log(request.responseText);
			var dto = JSON.parse(request.responseText);
			var user = dto.user;
			var reimbs = dto.reimbs;

			if (reimbs.length == 0) {
				console.log("Reimbs of length 0");
				$('#noReimbs').show();
				$('#reimbsTable').hide();
			} else {
				console.log("Displaying reimbs");
				$('#noReimbs').hide();
				$('#reimbsTable').show();
				for(var i = 0; i < reimbs.length; i++){
					var table = $('#reimbsTable');
					var row = table.insertRow();
					var submitted = row.insertCell(0);
					var description = row.insertCell(1);
					var amount = row.insertCell(2);
					submitted.html(reimbs[i].dateSubmitted);
					description.html(reimbs[i].description);
					amount.html("$" + reimbs[i].amount);
				}
			}
		}
	}
	request.open("GET", "employee-get-all-reimbs", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function sendRequest(servlet) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
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
