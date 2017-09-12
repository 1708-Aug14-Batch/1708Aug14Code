
window.onload = function(){
	
	loadDashboardView();
	
	
	
};


//Views

function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getReimbursements();
		}
	}
	xhr.open("GET","getDashboard",true);
	xhr.send();
}





function getReimbursements(){
	console.log("here");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto2 = JSON.parse(xhr.responseText);
			var theReimbursements = dto2.reimbursements;
			var reimbStatuses = dto2.statuses;
			console.log(reimbStatuses);
			/*
			 * OKAY SO I HAVE THE STATUSES HERE
			 * NOW HOW DO I MAP THEM TO THE IDS SO THAT I CAN
			 * CHANGE IT FROM STATUS ID TO JUST STATUS
			 * 
			 * 
			 * ALSO DO THIS WITH LIKE
			 * SUBMITTER ID
			 * AND RESOLVER ID
			 * YAAAAAY
			 */

			if (theReimbursements.length == 0){
				document.getElementById("reimbursements").style.visibility = "hidden"; 
				//console.log("null");
				//console.log("reimbursements");
			}
			else{
				console.log("AAAAAAAAAAAAAAA");
				console.log("Statuses: "+reimbStatuses);
				var table = document.getElementById("allReimbTable");
				for(var i = 0; i < theReimbursements.length; i++){
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
					
					reimb.innerHTML = theReimbursements[i].r_id;
					subid.innerHTML = theReimbursements[i].submitterId;
					resid.innerHTML = theReimbursements[i].resolverId;
					subdate.innerHTML = timeConverter(theReimbursements[i].submitDate);
					resdate.innerHTML = theReimbursements[i].resolveDate;
					statid.innerHTML = theReimbursements[i].statusId;
					desc.innerHTML = theReimbursements[i].description;
					resnotes.innerHTML = theReimbursements[i].resolveNotes;
					amt.innerHTML = theReimbursements[i].amount;
					
				}
			}
		}
	}
	xhr.open("GET", "getReimbursements", true);
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
