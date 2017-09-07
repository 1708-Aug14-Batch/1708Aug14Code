/**
 * 
 */

window.onload = function() {
	getAccountInformation();
}

function getAccountInformation() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			var accounts = dto.accounts;

			if (accounts.length == 0) {
				document.getElementById("accounts").style.visibility = "hidden";
				console.log("null");
				console.log("accounts");
			} else {
				console.log("not null");
				console.log(accounts.length);
				populateAccountsTable(accounts);
			}
		}
	}
	xhr.open("GET", "../getUserInfo", true);
	xhr.send();

}

function populateAccountsTable(accounts) {
	var html = "";

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

	document.getElementById('accounts_table').innerHTML = html;
}