
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




function getType(tyId, stati){
	var tyId = parseInt(tyId);
	for(var i=0;i<stati.length;i++){
		if(stati[i].st_id==tyId){
			return stati[i].stName;
		}
	}
	
}



function getTheirName(uid, allThem){
	var uid = parseInt(uid);
	for(var i=0;i<allThem.length;i++){
		if(allThem[i].u_id==uid){
			return allThem[i].firstName+" "+allThem[i].lastName;
		}
	}
	
}




function getUserInformation(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var aUser = dto.auser;
			var reimbursements = dto.reimbursements;
			var reimbStatuses = dto.statuses;
			var allTheUsers = dto.allUsers;
			
			var fullName = aUser.firstName+" "+aUser.lastName;
			document.getElementById('fullname').innerHTML = fullName;
			document.getElementById('theiruname').innerHTML = aUser.userName;
			document.getElementById('theiremail').innerHTML = aUser.email;
			document.getElementById('theiruid').innerHTML = aUser.u_id;
			
			if (reimbursements.length == 0&&aUser.isManager==0){
				document.getElementById("reimbursements").style.visibility = "hidden"; 
				
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
					subid.innerHTML = getTheirName(reimbursements[i].submitterId,allTheUsers);
					var resolverid = reimbursements[i].resolverId;
					if(resolverid<1){
						resid.innherHTML = "";
					}
					else{
						resid.innerHTML = getTheirName(reimbursements[i].resolverId,allTheUsers);
					}
					subdate.innerHTML = timeConverter(reimbursements[i].submitDate);
					resdate.innerHTML = reimbursements[i].resolveDate;
					var tyId = reimbursements[i].statusId;
					var thatstat =  getType(tyId,reimbStatuses);
					statid.innerHTML = thatstat;
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


