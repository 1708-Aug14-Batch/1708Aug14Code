/**
 * 
 */

// TODO form validation before clicking a button
var loggedIn = false; // Keeps track of whether a user is logged in
var id = -1; // Keeps track of the id of the logged in user. -1 means no user
// is logged in
var isManager = false; // Keeps track of whether the logged-in user is a
// manager
window.onload = function() {

	$("#navbarDiv").attr("hidden", true);
	$("#managerNavbarDiv").attr("hidden", true);

	// If a session is currently active, log in to that one
	// Otherwise show the login screen
	tryLogin();

	setEventListeners();

};

function setEventListeners() {

	// Employee
	// Employee navbar
	$("#home").click(loadDashboard);
	$("#profile").click(loadProfileView);
	$("#submitReim").click(loadSubmitReimView);
	$("#viewPendingReim").click(viewPendingReim);
	$("#viewResolvedReim").click(viewResolvedReim);

	// Miscellaneous
	$("#submit_button").click(submitReimbursement);
	// $("#submit_description").click(submitReimbursement);

	// Manager
	// Manager navbar
	$("#homeManager").click(loadDashboard);
	$("#profileManager").click(loadProfileView);
	$("#resolveReim").click(resolveReimView);
	$("#viewPendingReimManager").click(viewAllPendingReim);
	$("#viewResolvedReimManager").click(viewAllResolvedReim);
	$("#viewEmployeesReim").click(loadViewEmployeesReim);
	$("#viewEmployees").click(viewEmployees);
	$("#registerEmployee").click(registerEmployeeView);
	$("#viewReimIdButton").click(loadEmployeesReims);
	$("#resolve_button").click(resolveReim);

	// Miscellaneous

	// Set event listeners for logging in and creating an account
	$("#username_input").keypress(handleKeyPress);
	$("#password_input").keypress(handleKeyPress);
	$("#login_button").click(login);
	$("#create_button").click(loadCreateAccount);

	// Miscellaneous
	$("#view_password_check").click(togglePasswordView);
	$("#view_password_check2").click(togglePasswordView2);
	$("#update_profile").click(updateProfile);
	$("#update_profile2").click(createWorker);

	$("#view_button").click(getOneReimbursement);
}

function viewEmployees() {
	hideAllViews();
	$("#viewEmployeesDiv").attr("hidden", false);
	showEmployeesTable();
}

function resolveReimView() {
	hideAllViews();
	$("#resolveReimDiv").attr("hidden", false);
}

function loadEmployeesReims() {
	viewReimbursements("#viewReimIdDisplay", "", $("#employee_id_text")[0].value);
}

function getOneReimbursement() {
	var id = $("#view_reimbursement_id")[0].value;

	if (typeof id === "undefined")
		id = -1;	// There are no reimbursements with negative numbers
	
	var dto = [ ""+id ]; // dto must only contain String objects
	console.log("Get one reimbursement dto: " + dto);
	dto = JSON.stringify(dto);
	sendReceiveXMLResponse("POST", "getOneReimbursement", dto, function(
			responseText) {
		var reimbursement = JSON.parse(responseText);

		var div = "#viewReimDiv";
		
		$(div).attr("hidden", false);
		if (reimbursement == null)
			$(div).html("That id does not correspond to a reimbursement<br><br>");
		else populateReimbursementsTable(div, [ reimbursement ]);
	});
}

function registerEmployeeView() {
	hideAllViews();
	$("#registerEmployeeDiv").attr("hidden", false);
}

// FIXME double-check that I've added every div to this lsit
function hideAllViews() {
	$("#loginDiv").attr("hidden", true);
	$("#profileDiv").attr("hidden", true);
	$("#submitReimDiv").attr("hidden", true);
	$("#dashboardDiv").attr("hidden", true);

	$("#viewReimIdDiv").attr("hidden", true);
	$("#viewReimDiv").attr("hidden", true);
	$("#registerEmployeeDiv").attr("hidden", true);
	$("#resolveReimDiv").attr("hidden", true);
	$("#viewEmployeesDiv").attr("hidden", true);
}

function loadLoginView() {
	hideAllViews();
	$("#loginDiv").attr("hidden", false);
}

function loadDashboard() {
	hideAllViews();
	if (isManager) {
		$("#navbarDiv").attr("hidden", true);
		$("#managerNavbarDiv").attr("hidden", false);
	} else {
		$("#managerNavbarDiv").attr("hidden", true);
		$("#navbarDiv").attr("hidden", false);
	}

	$("#dashboardDiv").attr("hidden", false);

	if (isManager)
		$("#dashboardDiv").find("h3")[0].innerHTML = "Manager";
	else
		$("#dashboardDiv").find("h3")[0].innerHTML = "";

	var name = "";
	getXMLResponse("GET", "getUserInfo", function(responseText) {
		var user = JSON.parse(responseText).user;
		name = user.firstName + " " + user.lastName;
		$("#dashboardDiv").find("h3")[1].innerHTML = "Welcome " + name + " to";
	});

	$("#dashboardDiv").find("h3")[2].innerHTML = "The Online Reimbursement Resource";

}

function createWorker() {

	var firstName = $("#firstname_edit2")[0].value;
	var lastName = $("#lastname_edit2")[0].value;
	var email = $("#email_edit2")[0].value;
	var username = $("#username_edit2")[0].value;
	var password = $("#password_edit2")[0].value;
	var thisIsManager = "" + $("#create_manager_check")[0].checked;

	var dto = [ "-1", firstName, lastName, email, username, password, "" + id,
			"" + thisIsManager ];

	createUpdateEmployee("#message_edit2", dto);
}

function loadCreateAccount() {
	hideAllViews();
	$("#loginDiv").attr("hidden", false);
	$("#createAccountDiv").attr("hidden", false);
	// TODO
}

function loadProfileView() {
	hideAllViews();
	$("#message_edit").text(""); // Clear message text
	$("#view_password_check").attr("checked", false); // FIXME doesn't
	// de-select the checkbox
	displayProfileInformation();
	$("#profileDiv").attr("hidden", false);
}

function viewPendingReim() {
	hideAllViews();

	console.log("View reimbursements for the following employee id: " + id);
	viewReimbursements("#viewReimDiv", "PENDING", id);

}
function viewAllPendingReim() {
	hideAllViews();
	viewReimbursements("#viewReimDiv", "PENDING");
}
function viewResolvedReim() {
	hideAllViews();

	viewReimbursements("#viewReimDiv", "RESOLVED", id);
}
function viewAllResolvedReim() {
	hideAllViews();
	viewReimbursements("#viewReimDiv", "RESOLVED");
}
function loadViewEmployeesReim() {
	hideAllViews();
	$("#viewReimIdDiv").attr("hidden", false);
}
function resolveReim() {
	var reimbursement_id = $("#view_reimbursement_id")[0].value
	if (reimbursement_id == "")
		reimbursement_id = -1;
	var status
	if (document.getElementById('status_approved').checked) {
		status = "APPROVED";
	} else if (document.getElementById('status_denied').checked) {
		status = "DENIED";
	}
	var notes = $("#resolve_notes")[0].value;

	var dto = [ ""+reimbursement_id, status, notes];
	
	console.log("Resolving reimbursement with dto: " + dto);
	
	dto = JSON.stringify(dto);
	sendReceiveXMLResponse("POST", "updateReimbursement", dto, function(responseText) {
		var response = JSON.parse(responseText);
		
		console.log("Response recieved in resolveReimbursement: " + response);
		
		if (response == true)	{ // Success
			$("#resolve_error_message").text("Reimbursement resolved");
			$("#resolve_error_message").attr("style", "color:green");
		}
		else {
			$("#resolve_error_message").text(response);
			$("#resolve_error_message").attr("style", "color:red");
		}
	});
			
			

}
function loadSubmitReimView() {
	hideAllViews();
	$("#submitReimDiv").attr("hidden", false);

}

function togglePasswordView() {
	if ($("#view_password_check").is(":checked"))
		$("#password_edit").attr("type", "text");
	else
		$("#password_edit").attr("type", "password");
}

function togglePasswordView2() {
	if ($("#view_password_check2").is(":checked"))
		$("#password_edit2").attr("type", "text");
	else
		$("#password_edit2").attr("type", "password");
}

// Called when the user presses a key in the password field
function handleKeyPress(event) {
	var PRESS_ENTER = 13;
	if (event.keyCode == PRESS_ENTER)
		login();
}

// div is the HTML div where the table will be shown
// type is either PENDING, RESOLVED, or "" and determines which reimbursements
// to show.
// id is the id for the employee for which the reimbursements belong to
// if id is undefined (omitted in the function call), then view all.
// reimbursements
function viewReimbursements(div, type, id) {
	$(div).attr("hidden", false);

	if (typeof id === "undefined")
		id == -1;

	var dto = [ ""+id, type ]; // Both of these must be Strings

	console.log("Getting list of reimbursements" + div + " " + dto);

	dto = JSON.stringify(dto);
	sendReceiveXMLResponse("POST", "getReimbursements", dto, function(
			responseText) {
		var reimbursements = JSON.parse(responseText);

		if (reimbursements === null || reimbursements.length === 0)
			$(div).text("There are no " + type + " reimbursements");
		else {

			populateReimbursementsTable(div, reimbursements);
		}
	});

}

function submitReimbursement() {
	var description = $("#submit_description")[0].value;
	var ammount = $("#submit_ammount")[0].value;

	var dto = [ description, ""+ammount ];

	dto = JSON.stringify(dto);
	console.log("createReimbursement dto: " + dto);
	sendReceiveXMLResponse("POST", "createReimbursement", dto, function(
			responseText) {
		// Message arrived
		var response = JSON.parse(responseText);

		console.log("xhr response arrived in createReimbursement()");
		if (response == false) {
			$("#submit_error_text").text("Reimbursement could not be created");
			$("#submit_error_text").attr("style", "color:red");
		} else {
			setTimeout(loadSubmitReimView(), 0);

			$("#submit_error_text").text("Reimbursement created.");
			$("#submit_error_text").attr("style", "color:green");
		}

	});
}

function displayProfileInformation() {
	getXMLResponse("GET", "getUserInfo", function(responseText) {
		var user = JSON.parse(responseText).user;
		console.log("Displaying profile...");
		// Set display information:
		// id, name, username, email
		$("#id_text").text(user.workerId);
		$("#name_text").text(user.firstName + " " + user.lastName);
		$("#username_text").text(user.username);
		$("#email_text").text(user.email);

		// Set values for edit information:
		// firstname, lastname, username, password, email
		$("#firstname_edit").attr("value", user.firstName);
		$("#lastname_edit").attr("value", user.lastName);
		$("#username_edit").attr("value", user.username);
		$("#password_edit").attr("value", user.password);
		$("#email_edit").attr("value", user.email);
	});

}

function formatDate(day) {
	if (day === null)
		return "----";
	return day.month + " " + day.dayOfMonth + ", " + day.year;
}

function setNotes(notes) {
	if (notes === null)
		return "----";
	else
		return notes;
}

// Either log in to a current session or show the login screen
function tryLogin() {

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				var dto = JSON.parse(xhr.responseText);
				var user = dto.user;
				console.log("User: " + user);

				// Open the navbar and show the home page
				setLoggedInDetails();

			} else if (xhr.status == 418) {

				// Show login page
				loadLoginView();
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

function setLoggedInDetails() {
	loggedIn = true;
	getXMLResponse("GET", "getUserInfo", function(responseText) {
		var user = JSON.parse(responseText).user;
		id = user.workerId;
		isManager = user.manager;

		if (isManager)
			navbar = "#managerNavbarDiv";
		else
			navbar = "#navbarDiv";

		$(navbar).attr("hidden", false);
		loadDashboard();
	});

}

// Validates login and returns a useful error message if there is a mistake
function login() {
	var username = $("#username_input")[0].value;
	var password = $("#password_input")[0].value;
	var isManager = "" + $("#is_manager_check")[0].checked; // This must be a
	// String

	var dto = [ username, password, isManager ];

	dto = JSON.stringify(dto);

	sendReceiveXMLResponse(
			"POST",
			"login",
			dto,
			function(responseText) {
				// Message arrived
				var response = responseText;

				console
						.log("xhr response arrived in login function in loginMessage.js: "
								+ responseText);
				if (response == "username") {
					$("#message").text("Invalid username. Please try again");
				} else if (response == "password") {
					$("#message").text("Invalid password. Please try again");
				} else if (response == "check") {
					$("#message").text(
							"A manager must check the checkbox to login");
				} else if (response == "uncheck") {
					$("#message").text(
							"Uncheck the checkbox to login as an employee");
				} else {
					$("#message").text("");

					setLoggedInDetails();
				}
			});
}

function updateProfile() {
	var userId = $("#id_text").text();
	var firstName = $("#firstname_edit")[0].value;
	var lastName = $("#lastname_edit")[0].value;
	var email = $("#email_edit")[0].value;
	var username = $("#username_edit")[0].value;
	var password = $("#password_edit")[0].value;

	var dto = [ userId, firstName, lastName, email, username, password, "-1",
			"null" ];

	createUpdateEmployee("#message_edit", dto);
}

function createUpdateEmployee(div, dto) {
	dto = JSON.stringify(dto);
	console.log("updateProfile dto: " + dto);
	sendReceiveXMLResponse(
			"POST",
			"updateProfile",
			dto,
			function(responseText) {
				// Message arrived
				var response = responseText;

				console.log("xhr response arrived in updateProfile()");
				if (response == false) {
					$(div).text("Information could not be updated");
					$(div).attr("style", "color:red");
				} else {
					setTimeout(loadProfileView(), 0);

					$(div).text("Information updated.");
					$(div).attr("style", "color:green");
				}

			});
}

function showEmployeesTable() {
	
	getXMLResponse("GET", "getEmployees", function(responseText) {
		var employees = JSON.parse(responseText);

		populateEmployeesTable(employees);
	});
	
}

// type should be "GET" or "POST"
// url corresponds to the servlet being called
// callback is the function to call after the request is received and successful
function getXMLResponse(type, myurl, callback) {
	xmlhttp = new XMLHttpRequest();

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if (typeof callback === 'function')
				callback(xmlhttp.responseText);
		}
	}

	xmlhttp.open(type, myurl, true);
	xmlhttp.send();
}

function sendReceiveXMLResponse(type, myurl, dto, callback) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			callback(xmlhttp.responseText);
		} else if (xmlhttp.status == 500)
			$("#message").text("Something went wrong"); // Meant to show on the
		// login page
	}
	xmlhttp.open(type, myurl, true);
	xmlhttp.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	xmlhttp.send(dto);
}

//FIXME how to make the table not so wide OR be able to dynamically shrink
//horizontally
function populateReimbursementsTable(div, reimbursements) {
	var html = "<h3>Reimbursements</h3>";
	console.log("Populating reimbursements table..." + reimbursements.length);
	// Table head
	html += "<table class='table table-striped'><thead>	"
			+ "<th>Reimbursement ID</th>" + "<th>Submitter ID</th>"
			+ "<th>Resolver ID</th>" + "<th>Description</th>"
			+ "<th>Ammount</th>" + "<th>Date opened</th>"
			+ "<th>Date closed</th>" + "<th>Status</th>" + "<th>Notes</th>"
			+ "<tbody>";

	// Table rows
	for (var i = 0; i < reimbursements.length; i++) {

		html += "<tr>"
		html += "<td>" + reimbursements[i].reimbursementId + "</td>";
		html += "<td>" + reimbursements[i].submitterId + "</td>";
		html += "<td>" + reimbursements[i].resolverId + "</td>";
		html += "<td>" + reimbursements[i].description + "</td>";
		html += "<td>$" + reimbursements[i].ammount + "</td>";
		html += "<td>" + formatDate(reimbursements[i].submitDate) + "</td>";
		html += "<td>" + formatDate(reimbursements[i].resolvedDate) + "</td>";
		html += "<td>" + reimbursements[i].status + "</td>";
		html += "<td>" + setNotes(reimbursements[i].resolveNotes) + "</td>";

		html += "</tr>";
	}

	// Table end
	html += "</tbody></thead></table>";

	$(div).html(html);
}

function populateEmployeesTable(employees) {
	
	var html = "<h3>Employees</h3>";
	console.log("Populating employees table...");
	// Table head
	html += "<table class='table table-striped'><thead>	"
			+ "<th>Worker ID</th>" + "<th>First name</th>"
			+ "<th>Last name</th>" + "<th>Email</th>"
			+ "<th>Username</th>" + "<th>is Manager</th>"
			+ "<tbody>";
	
	// Table rows
	for (var i = 0; i < employees.length; i++) {

		html += "<tr>"
		html += "<td>" + employees[i].workerId + "</td>";
		html += "<td>" + employees[i].firstName + "</td>";
		html += "<td>" + employees[i].lastName + "</td>";
		html += "<td>" + employees[i].email + "</td>";
		html += "<td>" + employees[i].username + "</td>";
		html += "<td>" + employees[i].isManager + "</td>";

		html += "</tr>";
	}

	// Table end
	html += "</tbody></thead></table>";

	$(viewEmployeesDiv).html(html);
}
