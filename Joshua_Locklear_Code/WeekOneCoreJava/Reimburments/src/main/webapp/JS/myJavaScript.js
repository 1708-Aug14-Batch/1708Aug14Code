window.onload = function(){
	getUserInformation()
	loadDashboardView();
}


//Views

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInformation();
		}
		
	}
	xhr.open("GET", "getdashboard", true);
	xhr.send();
}


function getUserInformation(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.reim;
			document.getElementById("name").innerHTML = user.firstName + " " + user.lastName;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	
	
}
function checkInput(input) {
	if (input.value.length > 0) {
		input.className = 'active';
	} else {
		input.className = '';
	}
}