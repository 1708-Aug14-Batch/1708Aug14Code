/**
 * 
 */


window.onload = function(){
	
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
			document.getElementById("name").innerHTML = user.firstname + " " + user.lastname;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	
	
}




//function retrieveText(){
//	
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			document.getElementById("name").innerHTML = xhr.responseText;
//		}
//	}
//	xhr.open("GET", "HomePage", true);
//	// HTTP method, urlpattern, use Asynchronous? (always true)
//	xhr.send();
//	//Listens for the request
//};
//
//document.addEventListener("load", retrieveText, false)