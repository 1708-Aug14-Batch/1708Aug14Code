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
			var emp = dto.emp;
			var reimbs = dto.reimbs;
			
			document.getElementById('name').innerHTML = emp.firstname + " " +emp.lastname;
			
			if(accounts.length == 0){
				
			}
			else{
				for(var i =0; i <reimbs.length; i++){
					var table = document.getElementById("empReimbs");
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
	xhr.open("GET","getEmployeeInfo",true);
	xhr.send();
}