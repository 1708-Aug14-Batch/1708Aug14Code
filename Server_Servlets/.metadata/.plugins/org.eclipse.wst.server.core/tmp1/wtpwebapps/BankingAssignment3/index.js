/**
 * 
 */

// TODO form validation before clicking a button

var loggedIn = false;
window.onload = function() {

	$("#navbarDiv").attr("hidden", true);
	
	// If a session is currently active, log in to that one
	// Otherwise show the login screen
	tryLogin();

	setEventListeners();
	
};


function setEventListeners() {
	// Navbar
	$("#home").click(loadDashboard);
	$("#viewAcc").click(loadViewAcc);
	$("#depositAcc").click(loadDepositAcc);
	$("#transferAcc").click(loadTransferAcc);
	$("#withdrawAcc").click(loadWithdrawAcc);
	$("#editAcc").click(loadEditAcc);
	$("#profile").click(loadProfileView);
	
	// Set event listeners for logging in and creating an account
	$("#username_input").keypress(handleKeyPress);
	$("#password_input").keypress(handleKeyPress);
	$("#login_button").click(login);
	$("#create_button").click(loadCreateAccount);
	
	// Miscellaneous
	$("#view_password_check").click(togglePasswordView);
	$("#edit_button").click(updateAccount);
}

function hideAllViews() {
	$("#loginDiv").attr("hidden", true);
	$("#profileDiv").attr("hidden", true);
	$("#viewAccDiv").attr("hidden", true);
	$("#depositDiv").attr("hidden", true);
	$("#transferDiv").attr("hidden", true);
	$("#withdrawDiv").attr("hidden", true);
	$("#editDiv").attr("hidden", true);
	$("#dashboardDiv").attr("hidden", true);
	$("#createAccountDiv").attr("hidden", true);
	$("#accTableDiv").attr("hidden", true);
}

function loadLoginView() {
	hideAllViews();
	$("#navbarDiv").attr("hidden", true);
	$("#loginDiv").attr("hidden", false);
}

function loadDashboard() {
	hideAllViews();
	$("#navbarDiv").attr("hidden", false);
	$("#dashboardDiv").attr("hidden", false);
	$("#dashboardDiv").find("h3")[0].innerHTML = "Welcome to";
	$("#dashboardDiv").find("h3")[1].innerHTML = "People\'s Bank of Earth";
	
	// TODO
}

function loadViewAcc() {
	hideAllViews();
	viewAccounts();
	$("#viewAccDiv").attr("hidden", false);
	 
	// TODO
}

function loadCreateAccount() {
	hideAllViews();
	$("#loginDiv").attr("hidden", false);
	$("#createAccountDiv").attr("hidden", false);
	// TODO
}

function loadProfileView() {
	hideAllViews();
	$("#message_edit").text("");	// Clear message text
	$("#view_password_check").attr("checked", false);	// FIXME doesn't de-select the checkbox
	displayProfileInformation();
	$("#profileDiv").attr("hidden", false);
}

function loadDepositAcc() {
	hideAllViews();
	viewAccounts();
	$("#depositDiv").attr("hidden", false);;
	// TODO	
}
function loadTransferAcc() {
	hideAllViews();
	viewAccounts();
	$("#transferDiv").attr("hidden", false);
	// TODO	
}
function loadWithdrawAcc() {
	hideAllViews();
	viewAccounts();
	$("#withdrawDiv").attr("hidden", false);
	// TODO	
}
function loadEditAcc() {
	hideAllViews();
	viewAccounts();
	$("#editDiv").attr("hidden", false);
	// TODO	
}

function togglePasswordView() {
	if ($("#view_password_check").is(":checked"))
		$("#password_edit").attr("type", "text");
	else
		$("#password_edit").attr("type", "password");
}

//Called when the user presses a key in the password field
function handleKeyPress(event) {
	var PRESS_ENTER = 13;
	if (event.keyCode == PRESS_ENTER)
		login();
}

function viewAccounts() {
	$("#accTableDiv").attr("hidden", false);
	
	console.log("Getting account information");
	getAccountInformation(); // loads user info by calling function
}

function displayProfileInformation() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText).user;
			console.log("Displaying profile...");
			// Set display information:
			// id, name, username, email
			$("#id_text").text(user.userId);
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
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();

}

function getAccountInformation() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			var accounts = dto.accounts;
			console.log("Accounts: " + accounts);
			if (accounts.length == 0) {
				$("#accTableDiv").text("You have no accounts");
				console.log("null");
				console.log("accounts");
			} else {
				console.log("not null");
				console.log(accounts.length);
				populateAccountsTable(accounts);
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

function populateAccountsTable(accounts) {
	var html = "<h3>Accounts</h3>";
	console.log("Populating accounts table...");
	// Table head
	html += "<table class='table table-striped'><thead>	" + "<th>ID</th>"
			+ "<th>Date opened</th>" + "<th>Level</th>" + "<th>Type</th>"
			+ "<th>Balance</th><tbody>";

	// Table rows
	for (var i = 0; i < accounts.length; i++) {

		var day = accounts[i].accountOpenedDate;
		html += "<tr>"
		html += "<td>" + accounts[i].accountId + "</td>";
		html += "<td>" + day.month + " " + day.dayOfMonth + ", " + day.year
				+ "</td>";
		html += "<td>" + accounts[i].level + "</td>";
		html += "<td>" + accounts[i].type + "</td>";
		html += "<td>" + accounts[i].balance + "</td>";
		html += "</tr>";
	}

	// Table end
	html += "</tbody></thead></table>";

	$("#accTableDiv").html(html);
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
				loggedIn = true;
				loadDashboard();
			} else if (xhr.status == 418) {
				// Show login page
				loggedIn = false;
				loadLoginView();
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}


//Validates login and returns a useful error message if there is a mistake
function login() {
	var username = $("#username_input")[0].value;
	var password = $("#password_input")[0].value;

	var dto = [username, password];
	
	dto = JSON.stringify(dto);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// Message arrived
			var response =  xhr.responseText;

			console.log("xhr response arrived in login function in loginMessage.js: " + xhr.responseText);
			if (response == "fail"){
				$("#message").text("Invalid username. Please try again");
			}
			else if(response == "pass"){
				$("#message").text("Invalid password. Please try again");
			}
			else{
				$("#message").text("");
				loggedIn = true;
				console.log(response);
				console.log("calling success function");
				loadDashboard();
				$("#navbarDiv").attr("hidden", false);
			}
			
		}
	}
	
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(dto);
}

function updateAccount() {
	var userId = $("#id_text").text();
	var fistName = $("#firstname_edit")[0].value;
	var lastName = $("#lastname_edit")[0].value;
	var password = $("#password_edit")[0].value;
	var email = $("#email_edit")[0].value;
	
	var dto = [userId, fistName, lastName, password, email];
	
	dto = JSON.stringify(dto);
	console.log("updateAccount dto: " + dto);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// Message arrived
			var response =  xhr.responseText;

			console.log("xhr response arrived in updateAccount()");
			if (response == "false"){
				$("#message_edit").text("Information could not be updated");
				$("#message_edit").attr("style", "color:red");
			}
			else {
				setTimeout(loadProfileView(), 0);
				
				$("#message_edit").text("Information updated.");
				$("#message_edit").attr("style", "color:green");
			}
			
		}
	}
	
	xhr.open("POST", "updateProfile", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(dto);
}