window.onload = function(){
	loadDashboardView();
	console.log("wowowwo");
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
			var reimb = dto.reimbs;
			
			
			if(reimb.length == 0){
				
			}
			else{
				for(var i =0; i <reimb.length; i++){
					var table = document.getElementById("empReimbs");
					var row = table.insertRow();
					var reid = row.insertCell(0);
					var subid = row.insertCell(1)
					var subdate = row.insertCell(2);
					var status = row.insertCell(3);
					var desc = row.insertCell(4);
					var amt = row.insertCell(5);
					reid.innerHTML = "No.: " + reimb[i].id + " ";
					subid.innerHTML = reimb[i].submitter.firstname + " "+reimb[i].submitter.lastname+" ";
					subdate.innerHTML = reimb[i].submitdate+ " ";
					status.innerHTML = reimb[i].type.name + " ";
					desc.innerHTML = reimb[i].descript+ " ";
					amt.innerHTML = "$ "+reimb[i].amount;
				}
			}
			//document.getElementById('info').innerHTML = JSON.stringify(user,null,4);
		}
	}
	xhr.open("GET","getManagerInfo",true);
	xhr.send();
}

$(document).ready(function(){
	document.getElementById("approve").addEventListener("click", approve)
	document.getElementById("deny").addEventListener("click", deny)
});



function approve(){
	
	var id = document.getElementById("reid").value;
	var notes = document.getElementById("notes").value;
	
	var tx = [id,notes];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "ApproveReimbursement", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
}
function deny(){
	
	var id = document.getElementById("reid").value;
	var notes = document.getElementById("notes").value;
	
	var tx = [id,notes];
	
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "DenyReimbursement", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
}