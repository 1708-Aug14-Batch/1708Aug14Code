window.onload = function(){
	loadDashboardView();
};

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInformation();
		}
	}
	xhr.open("GET","getDashboard",true);
	xhr.send();
}

function getUserInformation(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			
			document.getElementById('name').innerHTML = user.firstname + " " +user.lastname;
			
			if(accounts.length == 0){
				
			}
			else{
				for(var i =0; i <accounts.length; i++){
					var table = document.getElementById("accTable");
					var row = table.insertRow();
					var acc = row.insertCell(0);
					var type = row.insertCell(1);
					var bal = row.insertCell(2);
					acc.innerHTML = "Account no.: " + accounts[i].id + " ";
					type.innerHTML = accounts[i].type.name+ " ";
					bal.innerHTML = "$" + accounts[i].balance;
				}
			}
			document.getElementById('info').innerHTML = JSON.stringify(user,null,4);
		}
	}
	xhr.open("GET","getUserInfo",true);
	xhr.send();
}