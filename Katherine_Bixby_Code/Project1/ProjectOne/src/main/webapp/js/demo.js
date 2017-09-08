
window.onload = function(){
	
	loadDashboardView();
	
};


//Views

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
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
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var aUser = dto.auser;
			var reimbursements = dto.reimbursements;
			
			//document.getElementById('name').innerHTML = aUser.firstName + " " + aUser.lastName;
			if (reimbursements.length == 0&&aUser.isManager==0){
				document.getElementById("reimbursements").style.visibility = "hidden"; 
				//console.log("null");
				//console.log("reimbursements");
			}
			else{
				var table = document.getElementById("reimbTable");
				for(var i = 0; i < reimbursements.length; i++){
					// populate accounts table
					var nrow = table.insertRow(i+1);
					var reimb = nrow.insertCell(0);
					var subid = nrow.insertCell(1);
					var resid = nrow.insertCell(2);
					var subdate = nrow.insertCell(3);
					var resdate = nrow.insertCell(4);
					var statid = nrow.insertCell(5);
					var desc = nrow.insertCell(6);
					var resnotes = nrow.insertCell(7);
					var amt = nrow.insertCell(8);
					
					reimb.innerHTML = reimbursements[i].r_id;
					subid.innerHTML = reimbursements[i].submitterId;
					resid.innerHTML = reimbursements[i].resolverId;
					subdate.innerHTML = timeConverter(reimbursements[i].submitDate);
					resdate.innerHTML = reimbursements[i].resolveDate;
					statid.innerHTML = reimbursements[i].statusId;
					desc.innerHTML = reimbursements[i].description;
					resnotes.innerHTML = reimbursements[i].resolveNotes;
					amt.innerHTML = "$"+reimbursements[i].amount;
					
				}
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	
}


function timeConverter(ts){
	var a = new Date(ts);
	var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	var year = a.getFullYear();
	var month = months[a.getMonth()];
	var date = a.getDate();
	var hour = a.getHours();
	var min = a.getMinutes();
	var sec = a.getSeconds();
	var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
	return time;
}


