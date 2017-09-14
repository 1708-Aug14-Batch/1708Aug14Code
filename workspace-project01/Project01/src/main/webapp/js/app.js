
var loggedIn = false;
window.onload = function() {

};

$(document).ready(function() {
	$('#btnViewMyReimbs').click(viewMyReimbs);
	$('#btnMyInfo').click(viewMyInfoPage);
	$('#btnLogout').click(logout);
	$('#btnBackToMyInfo').click(viewMyInfoPage);
	$('#btnEditMyInfo').click(showEditMyInfoPage);
	$(document).on('click', '#btnSubmitNewInfo', editMyInfo);
});

function viewMyReimbs() {
	console.log("Inside viewMyReimbs");
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			console.log(request.responseText);
			$('#view').html(request.responseText);
			getMyReimbs();
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
					var table = document.getElementById("reimbsTable");
					var row = table.insertRow(0);
					var submitted = row.insertCell(0);
					var description = row.insertCell(1);
					var amount = row.insertCell(2);
					console.log(reimbs[i]);
					submitted.innerHTML = reimbs[i].dateSubmitted;
					description.innerHTML = reimbs[i].description;
					amount.innerHTML = reimbs[i].amount;
				}
			}
		}
	}
	request.open("GET", "employee-get-all-reimbs", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function viewMyInfoPage() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
			getMyInfo();
		}
	}
	request.open("GET", "employee-view-my-info", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function getMyInfo() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var user = JSON.parse(request.responseText);
			$('#welcome').html("Welcome " + user.firstName + " " + user.lastName);
			$('#myEmail').html("Email : " + user.email);
			$('#isManager').html("You are not a manager");
		}		
	}
	request.open("POST", "employee-view-my-info", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function showEditMyInfoPage() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
		}
	}
	request.open("GET", "employee-edit-my-info", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function editMyInfo() {
	var newPassword = $('#setNewPassword').val();
	var newPasswordConfirmed = $('#confirmNewPassword').val();
	if (newPassword === newPasswordConfirmed) {
		var request = new XMLHttpRequest();
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				viewMyInfoPage();
			}
		}
		var userData = JSON.stringify({firstName: $('#editFirstName').val(), 
			lastName: $('#editLastName').val(), 
			email: $('#editEmail').val(), 
			newPassword: $('#setNewPassword').val(), 
			currentPassword: $('#enterCurrentPassword').val()});
		request.open("POST", "employee-edit-my-info", true);
		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		request.send(userData); // send data here
	} else {
		alert("New password fields do not match!");
	}
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

