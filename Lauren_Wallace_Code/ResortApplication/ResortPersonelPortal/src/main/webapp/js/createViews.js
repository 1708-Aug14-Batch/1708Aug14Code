/**
 * 
 */

window.onload = function () {
	
	loadEmpView();
}

//Views
//this is the employee view
function loadEmpView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('empview').innerHTML = xhr.responseText;
			getUserInformation();
			//add what the employee should see upon being logged in
			$('#example').DataTable();
		}
	}
	xhr.open("GET", "getEmp", true);
	xhr.send();
}

//this is the manager view
function loadMgrView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('mgrview').innerHTML = xhr.responseText;
			getUserInformation();
			//add what the manager should see upon being logged in
		}
	}
	xhr.open("GET", "getMgr", true);
	xhr.send();
}

//shows the user who is logged in at the top
function getUserInformation() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			
			document.getElementById('welcome').innerHTML = "Hello: " + user.firstname + " " + user.lastname + "\n";
			
			xhr.open("GET", "getUserInfo", true);
			xhr.send();
		}
	}
}