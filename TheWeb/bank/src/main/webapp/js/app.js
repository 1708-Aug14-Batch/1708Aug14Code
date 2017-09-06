/**
 * 
 */
window.onload = function(){
	//addScript('features/dashboard/dashboard.js');
	loadNavbar();
	loadDashboardView();
};

function loadNavbar(){ // partial function to load the navbar to html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readystate == 4 && xhr.status == 200){
			//load navbar as response from get request from ajaxnavbar servlet via ajax request
			document.getElementById('navbar').innerHTML = xhr.responseText;
			// when tx is clicked, load the tx view. functionality in function defined below
			//document.getElementById('tx').addEventListener('click', loadTxView, false);
			document.getElementById('dashboard').addEventListener('click', loadDashboardView, false);
		}
	}
	console.log("loading navbar")
	xhr.open("GET", "ajaxNavbar", true);
	xhr.send();
	
};

//----------------------------------Views
function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveBankUserAccountInfo();
		}
	}
	xhr.open("GET", "ajaxDashboard", true);
	xhr.send();
}

function loadTxView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('txBtn').addEventListener("click",processTx, false)
		}
	}
	xhr.open("GET", "ajaxDoTransaction", true);
	xhr.send();
}

function retrieveBankUserAccountInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			document.getElementById('name').innerHTML = user.firstname + " " + user.lastname;
		}
	}
	xhr.open("GET", "ajaxBankInfo", true);
	xhr.send();
}
