$(document).ready(function() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var employees = dto.employees;
			
			var hr = (new Date()).getHours();
			if (hr >= 5 && hr < 12)
				document.getElementById('welcome').innerHTML = "Good morning, "+ user.firstname + " " + user.lastname;
			else if (hr >= 12 && hr < 18)
				document.getElementById('welcome').innerHTML = "Good afternoon, "+ user.firstname + " " + user.lastname;
			else
				document.getElementById('welcome').innerHTML = "Good evening, "+ user.firstname + " " + user.lastname;
			
			var table = document.getElementById("employees");
			for (var e in employees) {
				var row = table.insertRow(e);
				row.id = employees[e].id;
				console.log(row.id);
				var id = row.insertCell(0);
				var fname = row.insertCell(1);
				var lname = row.insertCell(2);
				var email = row.insertCell(3);

				id.innerHTML = employees[e].id;
				fname.innerHTML = employees[e].firstname;
				lname.innerHTML = employees[e].lastname;
				email.innerHTML = employees[e].email;
			}
		}
	}
	xhr.open("GET", "viewEmployees", true);
	xhr.send();
});