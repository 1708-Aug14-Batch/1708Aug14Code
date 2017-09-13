window.onload = function(){
	loadDashboardView();
};

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getAllEmployees();
		}
	}
	xhr.open("GET","getDashboard",true);
	xhr.send();
}

function getAllEmployees(){
	console.log("getting here");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			var emps = JSON.parse(xhr.responseText);
			
			
			if(emps.length == 0){
				console.log("something");
			}
			else{
				for(var i =0; i <emps.length; i++){
					var table = document.getElementById("empReimbs");
					var tablename = document.getElementById("tableName");
					tablename.innerHTML = "Employees"
					var row = table.insertRow();
					var empid = row.insertCell(0);
					var fn = row.insertCell(1)
					var ln = row.insertCell(2)
					var email = row.insertCell(3);
					var username = row.insertCell(4)
					empid.innerHTML = "No.: " + emps[i].id + " ";
					fn.innerHTML = emps[i].firstname + " ";
					ln.innerHTML = emps[i].lastname + " ";
					email.innerHTML = emps[i].email+ " ";
					username.innerHTML = emps[i].username;
					
				}
			}
			//document.getElementById('info').innerHTML = JSON.stringify(user,null,4);
		}
	}
	xhr.open("GET","getAllEmployees",true);
	xhr.send();
}

$(document).ready(function(){
	document.getElementById("register").addEventListener("click", register)
});



function register(){
	
	var fn = document.getElementById("firstname").value;
	var ln = document.getElementById("lastname").value;
	var em = document.getElementById("email").value;
	
	var tx = [fn,ln,em];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "RegisterEmployee", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
}