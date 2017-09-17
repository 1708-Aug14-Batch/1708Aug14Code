
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
	$('#btnNewRequest').click(showSubmitRequestView);
	$(document).on('click', '#btnSubmitRequest', submitRequest);
	$('#btnAllRequests').click(showAllRequestsView);
	$('#btnAllEmployees').click(showAllEmployeesView);
	$(document).on('click', '#btnEmpRequests', viewRequestPage)
});

//Begin Employee Functions

function viewMyReimbs() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
			getMyReimbs();
		}
	}
	request.open("GET", "employee-view-all-reimbs", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function getMyReimbs() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var dto = JSON.parse(request.responseText);
			var reimbs = dto.reimbs;
			populateReimbsTable(reimbs);
		}
	}
	request.open("GET", "employee-get-all-reimbs", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function populateReimbsTable(reimbs) {
	if (reimbs.length == 0) {
		$('#noReimbs').show();
		$('#reimbsTable').hide();
	} else {
		$('#noReimbs').hide();
		$('#reimbsTable').show();
		for(var i = 0; i < reimbs.length; i++){
			var table = document.getElementById("reimbsTable");
			var row = table.insertRow(1);
			var submitted = row.insertCell(0);
			var description = row.insertCell(1);
			var amount = row.insertCell(2);
			submitted.innerHTML = reimbs[i].dateSubmitted;
			description.innerHTML = reimbs[i].description;
			amount.innerHTML = reimbs[i].amount;
			
			// Make buttons to view individual requests
			var cellShowReq = row.insertCell(3);
			var btnShowReq = document.createElement("button");
			btnShowReq.innerHTML = "View This Employee";
			cellShowReq.appendChild(btnShowReq);
		}
	}
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

function showSubmitRequestView() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
		}
	}
	request.open("GET", "employee-submit-request", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function submitRequest() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			viewMyReimbs();
		}
	}
	request.open("POST", "employee-submit-request", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	var reimb = JSON.stringify({description: $('#inputDescription').val(),
		amount: $('#inputAmount').val()});
	request.send(reimb);
}

//End Employee Functions

//Begin Manager Functions

function showAllRequestsView() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
			getAllRequests();
		}
	}
	request.open("GET", "manager-all-reimbs", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function getAllRequests() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var reimbs = JSON.parse(request.responseText);
			populateReimbsTable(reimbs);
		}
	}
	request.open("POST", "manager-all-reimbs", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function showAllEmployeesView() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
			getAllEmployees();
		}
	}
	request.open("GET", "manager-view-emps", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function getAllEmployees() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var emps = JSON.parse(request.responseText);
			populateEmpsTable(emps);
		}
	}
	request.open("POST", "manager-view-emps", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function populateEmpsTable(emps) {
	if (emps.length == 0) {
		$('#noEmps').show();
		$('#empsTable').hide();
	} else {
		$('#noEmps').hide();
		$('#empsTable').show();
		for(var i = 0; i < emps.length; i++){
			var table = document.getElementById("empsTable");
			var row = table.insertRow(0);
			var firstNameCell = row.insertCell(0);
			var lastNameCell = row.insertCell(1);
			var emailCell = row.insertCell(2);
			
			firstNameCell.innerHTML = emps[i].firstName;
			lastNameCell.innerHTML = emps[i].lastName;
			emailCell.innerHTML = emps[i].email;
			
			var cellShowEmp = row.insertCell(3);
			var btnShowEmp = document.createElement("button");
			btnShowEmp.innerHTML = "View This Employee";
			cellShowEmp.appendChild(btnShowEmp);
			
			var email = emailCell.innerHTML;
			function invokeShowSingleEmpView() {
				showSingleEmpView(email);
			}
			$(btnShowEmp).click(invokeShowSingleEmpView);
		}
	}
}


function showSingleEmpView(email) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			$('#view').html(request.responseText);
			getSingleEmp(email);
		}
	}
	request.open("GET", "manager-view-employee", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function getSingleEmp(email) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var employee = JSON.parse(request.responseText);
			$('#firstName').html(employee.firstName);
			$('#lastName').html(employee.lastName);
			$('#email').html(employee.email);
		}
	}
	//email = JSON.stringify(email);
	request.open("POST", "manager-view-employee", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(email);
}

function viewRequestPage() {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var email = $('#email').html();
			$('#view').html(request.responseText);
			getEmpRequest(email);
		}
	}
	request.open("GET", "manager-view-request", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send();
}

function getEmpRequest(email) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if(request.readyState == 4 && request.status == 200) {
			var reimbs = JSON.parse(request.responseText);
			if (reimbs.length == 0) {
				$('#noReimbs').show();
				$('#reimbsTable').hide();
			} else {
				$('#noReimbs').hide();
				$('#reimbsTable').show();
				for(var i = 0; i < reimbs.length; i++){
					var table = document.getElementById("reimbsTable");
					var row = table.insertRow(0);
					var submitted = row.insertCell(0);
					var description = row.insertCell(1);
					var amount = row.insertCell(2);
					submitted.innerHTML = reimbs[i].dateSubmitted;
					description.innerHTML = reimbs[i].description;
					amount.innerHTML = reimbs[i].amount;
				}
			}
		}
	}
	request.open("POST", "manager-view-request", true);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	//email = JSON.stringify(email);
	request.send(email);
}

function showRegisterView() {
	
}

//End Manager Functions

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

