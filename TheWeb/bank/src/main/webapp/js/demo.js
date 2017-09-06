window.onload = function(){

	loadDashboardView();

};

//Views
function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getUserInformation();
		}
	}
	console.log("getting dash")
	xhr.open("GET", "getDashboard", true);
	xhr.send();
}

function getUserInformation(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;

			document.getElementById('name')
			.innerHTML = user.firstname + " " + user.lastname;
			if (accounts.length == 0){
				document.getElementById("accounts").style.visibility = "hidden"; 

			}
			else{

				for(var i = 0; i < accounts.length; i++){
					// populate accounts table
					var table = document.getElementById("accTable");
					var row = table.insertRow();
					var acc = row.insertCell(0);
					var type = row.insertCell(1);
					var bal = row.insertCell(2);
					acc.innerHTML = "Account No. " + accounts[i].id;
					type.innerHTML = accounts[i].type;
					bal.innerHTML = "$" + accounts[i].balance;
				}
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();

}
