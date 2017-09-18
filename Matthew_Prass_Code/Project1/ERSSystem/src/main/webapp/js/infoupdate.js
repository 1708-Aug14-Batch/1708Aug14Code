window.onload = function(){
	getEmployee();
};


function getEmployee(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			var emps = JSON.parse(xhr.responseText);
			var info = document.getElementById("info");
		
			info.innerHTML = "Id: "+ emps.id + "<br>" + "First name: " + emps.firstname + "<br>" +
			"Last name: " + emps.lastname +"<br>"+ "Email: " + emps.email + "<br>" +"Password :" +emps.password +"<br>" 
			+ "Username: " + emps.username + "<br>" + "Is Manager: " + "no";
		}
	}
	xhr.open("GET","getEmployee",true);
	xhr.send();


}



$(document).ready(function(){
	document.getElementById("submit").addEventListener("click", updateInfo)
});



function updateInfo(){
	
	var fname = document.getElementById("firstname").value;
	var lname = document.getElementById("lastname").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("pass").value;
	var username = document.getElementById("username").value;
	var tx = [fname,lname,email,password,username];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "EditUserInfo", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
}