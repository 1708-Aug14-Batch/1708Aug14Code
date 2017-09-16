window.onload = function() {
	getLoginInfo();
	getUserInfo();
}

function getLoginInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200)  {
			var user = xhr.responseText;
			console.log(user);
			document.getElementById("uname").innerHTML = user;
		}
	}
	xhr.open('Get', "homePage", true);
	xhr.send();
}

function getUserInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200)  {
			var user = xhr.responseText;
			console.log(user);
			var emp = JSON.parse(user);

			document.getElementById("EmpFirstName").innerHTML = emp.firstName;
			document.getElementById("EmpLastName").innerHTML = emp.lastName;
			document.getElementById("EmpEmail").innerHTML = emp.email;
			document.getElementById("EmpUserName").innerHTML = emp.userName;
			document.getElementById("EmpPassword").innerHTML = emp.password;
			
			document.getElementById("fname").value = emp.firstName;
			document.getElementById("lname").value = emp.lastName;
			document.getElementById("email").value = emp.email;
			document.getElementById("username").value = emp.userName;
			document.getElementById("password").value = emp.password;
		}
	}
	xhr.open('Get', "empInfo", true);
	xhr.send();
}
