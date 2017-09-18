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
			getAcctPageInfo()
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
function getAcctPageInfo(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;


			if (accounts.length == 0){
				document.getElementById("accounts").style.visibility = "hidden"; 

			}
			else{

				for(var i = 0; i < accounts.length; i++){
					// populate Reimbursement table
					//var time = new Date().getTime();
					var table = document.getElementById("accTable");
					var row = table.insertRow();
					var acc = row.insertCell(0);
					var amo = row.insertCell(1);
					var type = row.insertCell(2);
					var sdate = row.insertCell(3);
					var rdate = row.insertCell(4);
					var des = row.insertCell(5);
					var rn = row.insertCell(6);
					var r_id = row.insertCell(7);
					//sdate = Date.parse(sdate);
					acc.innerHTML = "Reimbursment id:" + accounts[i].r_id;
					amo.innerHTML = "$" + accounts[i].amount;
					type.innerHTML = accounts[i].status_id;
					sdate.innerHTML = accounts[i].subDate;
					rdate.innerHTML = accounts[i].resdDate;
					des.innerHTML = accounts[i].description;
					rn.innerHTML = accounts[i].notes;
					r_id.innerHTML = accounts[i].res_id;
					
				}
			}
		}
	}
	xhr.open("GET", "Reimbursement", true);
	xhr.send();
	
}