
function loadDashboardView() {
	console.log('Getting Dash');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	};
	xhr.open('GET', 'getDashboard', true);
	xhr.send();
}

function getUserNavInfo() {
	console.log('Getting User Nav Info');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			var firstname = dto.fn;
			var lastname = dto.ln;
			document.getElementById('GreetThing').innerHTML = 'Hello, ' + firstname + ' ' + lastname + '!';
			console.log(dto);
		}
	};
	xhr.open('GET', 'getUserNavInfo', true);
	xhr.send();
}

var reims;

function getUserReim() {
	console.log('Getting Reim Base Data');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var dto = JSON.parse(xhr.responseText);
			reims = dto.reims;
			var ch1 = document.getElementById('ResCheck').checked;
			for(var i = 0; i < reims.length; i++) {
				if(ch1 || reims[i].status == 'Pending') {
					var row = document.getElementById('ReimTableBody').insertRow(0);
					var col1 = row.insertCell(0);
					col1.innerHTML = reims[i].sub;
					var col2 = row.insertCell(1);
					col2.innerHTML = reims[i].res;
					var col3 = row.insertCell(2);
					col3.innerHTML = reims[i].subDate;
					var col4 = row.insertCell(3);
					col4.innerHTML = reims[i].resDate;
					var col5 = row.insertCell(4);
					col5.innerHTML = reims[i].status;
					if(reims[i].status == 'Pending') {
						col5.style.color = 'orange';
					}
					else if(reims[i].status == 'Approved') {
						col5.style.color = 'green';
					}
					else {
						col5.style.color = 'red';
					}
					var col6 = row.insertCell(5);
					col6.innerHTML = reims[i].desc;
					var col7 = row.insertCell(6);
					col7.innerHTML = reims[i].resNote;
					var col8 = row.insertCell(7);
					col8.innerHTML = reims[i].amount;
				}
			}
			console.log(dto);
		}
		document.getElementById('ResCheck').onchange = function() {
			document.getElementById('ReimTableBody').innerHTML = "";
			var ch = document.getElementById('ResCheck').checked;
			for(var i = 0; i < reims.length; i++) {
				if(ch || reims[i].status == 'Pending') {
					var row = document.getElementById('ReimTableBody').insertRow(0);
					var col1 = row.insertCell(0);
					col1.innerHTML = reims[i].sub;
					var col2 = row.insertCell(1);
					col2.innerHTML = reims[i].res;
					var col3 = row.insertCell(2);
					col3.innerHTML = reims[i].subDate;
					var col4 = row.insertCell(3);
					col4.innerHTML = reims[i].resDate;
					var col5 = row.insertCell(4);
					if(reims[i].status == 'Pending') {
						col5.style.color = 'orange';
					}
					else if(reims[i].status == 'Approved') {
						col5.style.color = 'green';
					}
					else {
						col5.style.color = 'red';
					}
					col5.innerHTML = reims[i].status;
					var col6 = row.insertCell(5);
					col6.innerHTML = reims[i].desc;
					var col7 = row.insertCell(6);
					col7.innerHTML = reims[i].resNote;
					var col8 = row.insertCell(7);
					col8.innerHTML = reims[i].amount;
				}
			}
		};
	};
	xhr.open('GET', 'getMyReimData', true);
	xhr.send();
}

function loadMyReimView() {
	console.log('Getting Reim');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserReim();
		}
	};
	xhr.open('GET', 'getMyReim', true);
	xhr.send();
}

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

function loadNavBarView() {
	console.log('Getting NavBar');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('AppView').innerHTML = xhr.responseText;
			getUserNavInfo();
			document.getElementById('HomeBut').addEventListener('click', loadDashboardView);
			document.getElementById('MyR').addEventListener('click', loadMyReimView);
			document.getElementById('Settings').addEventListener('click', loadSettingsView);
			loadDashboardView();
		}
	};
	xhr.open('GET', 'getNavBar', true);
	xhr.send();
}

function attemptLoginFunc() {
	console.log('Attempting Login');
	var xhr = new XMLHttpRequest();
	var email = document.getElementById('email').value;
	var pass = document.getElementById('pass').value;
	var tx = [email, pass];
	tx = JSON.stringify(tx);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			if(xhr.responseText == "Failed") {
				console.log('ResponseText: ' + xhr.responseText);
				document.getElementById("passText").style.visibility = "visible";
			}
			else {
				document.getElementById('bodyTag').setAttribute('background', '');
				loadNavBarView();
			}
		}
	};
	xhr.open('POST', 'attemptLogin', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
}

document.getElementById('submit').addEventListener('click', attemptLoginFunc);