window.onload = function() {
	loadDashboardView();
}

//Views

function loadDashboardView() {
	console.log('Getting Dash');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInformation();
		}
	};
	xhr.open('GET', 'getDashboard', true);
	xhr.send();
}

function getUserInformation() {
	console.log('Getting User Info');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			document.getElementById('name').innerHTML = user.firstname + " " + user.lastname;
			if(accounts.length == 0) {
				document.getElementById("accounts").style.visibility = "hidden";
			}
			else {
				document.getElementById("accounts").style.visibility = "visible";
				for(var i = 0; i < accounts.length; i++) {
					var table = document.getElementById('accounts');
					var row = table.insertRow();
					var accname = row.insertCell(0);
					var acctype = row.insertCell(1);
					var accbal = row.insertCell(2);
					accname.innerHTML = accounts[i].name;
					acctype.innerHTML = accounts[i].type.type;
					accbal.innerHTML = "$" + accounts[i].balance;
					console.log(accounts[i].balance);
				}
			}
		}
	};
	xhr.open('GET', 'getUserInfo', true);
	xhr.send();
}

document.getElementById('MyAccounts').addEventListener('click', loadDashboardView);

function loadSettingsView() {
	console.log('Getting Settings');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	};
	xhr.open('GET', 'getSettings', true);
	xhr.send();
}

document.getElementById('Settings').addEventListener('click', loadSettingsView);










