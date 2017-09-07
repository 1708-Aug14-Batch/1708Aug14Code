/**
 * 
 */

var loggedIn = false;
window.onload = function(){

	loadHomeView();
	
	if(loggedIn == false){
		$("#navbar").hide();
	}
	else{
		$("#navbar").show();};

		document.getElementById("homePage")
		.addEventListener("click", loadDashboardView);
		document.getElementById("accPage")
		.addEventListener("click", loadAccountPageView);

};


function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("Message received in loadHomeView: " + xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;		

			// Set event listeners for logging in
			document.getElementById("login_button")
			.addEventListener("click", login);
			document.getElementById("password_input")
			.addEventListener("handleKeyPress", login);

		}
	}
	console.log("getting homepage")
	xhr.open("GET", "../getLoginView", true);
	xhr.send();
};
