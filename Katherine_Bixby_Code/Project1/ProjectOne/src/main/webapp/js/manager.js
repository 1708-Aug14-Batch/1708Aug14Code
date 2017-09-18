
window.onload = function(){
	
	loadDashboardView();
	$("#viewingAllReimb").click(function(){
		loadAllReimbView();
	});
	$("#viewingPendReimb").click(function(){
		loadPendReimbView();
		loadHandlePendView();
	});
	$("#viewingAllEmp").click(function(){
		loadAllEmpView();
	});
	$("#addingEmployee").click(function(){
		loadAddEmpView();
	});
};


//Views


function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			//getReimbursements();
			//pendingReimbursements();
		}
	}
	xhr.open("GET","getDashboard",true);
	xhr.send();
}


function loadAddEmpView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('addAnEmp').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET","addEmpView",true);
	xhr.send();
}



function loadAllReimbView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('allReimbView').innerHTML = xhr.responseText;
			getReimbursements();
		}
	}
	xhr.open("GET","getAllReimbView",true);
	xhr.send();
}


function loadHandlePendView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('handlePendReimbView').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET","getHandlePendingView",true);
	xhr.send();
}

function loadPendReimbView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('pendReimbView').innerHTML = xhr.responseText;
			pendingReimbursements();
		}
	}
	xhr.open("GET","getPendReimbView",true);
	xhr.send();
}

function loadAllEmpView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('allEmpView').innerHTML = xhr.responseText;
			getAllUsers();
		}
	}
	xhr.open("GET","getAllEmpView",true);
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



function getAllUsers(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var allTheUsers = dto.allUsers;
			if (allTheUsers.length == 0){
				document.getElementById("employee").style.visibility = "hidden"; 
			}
			else{
				var table = document.getElementById("allEmpTable");
				for(var i = 0; i < allTheUsers.length; i++){
					// populate accounts table
					var nrow = table.insertRow(i+1);
					var eid = nrow.insertCell(0);
					var uname = nrow.insertCell(1);
					var fn = nrow.insertCell(2);
					var ln = nrow.insertCell(3);
					var email = nrow.insertCell(4);
					var isman = nrow.insertCell(5);
					
					
					eid.innerHTML = allTheUsers[i].u_id;
					uname.innerHTML = allTheUsers[i].userName;
					fn.innerHTML = allTheUsers[i].firstName;
					ln.innerHTML = allTheUsers[i].lastName;
					email.innerHTML = allTheUsers[i].email;
					var displayManager = allTheUsers[i].isManager;
					if(displayManager==0){
						isman.innerHTML="Employee";
					}
					else if(displayManager==1){
						isman.innerHTML="Manager";
					}
					else{
						isman.innerHTML="ERROR";
					}
					
					
				}
			}
		}
	}
	xhr.open("GET","allEmpGet",true);
	xhr.send();
}




function getReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto2 = JSON.parse(xhr.responseText);
			var theReimbursements = dto2.reimbursements;
			var reimbStatuses = dto2.statuses;
			var allTheUsers = dto2.allUsers;

			if (theReimbursements.length == 0){
				document.getElementById("reimbursements").style.visibility = "hidden"; 
			}
			else{
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
					subid.innerHTML = getTheirName(theReimbursements[i].submitterId,allTheUsers);
					var resolverid = theReimbursements[i].resolverId;
					if(resolverid<1){
						resid.innherHTML = "";
					}
					else{
						resid.innerHTML = getTheirName(theReimbursements[i].resolverId,allTheUsers);
					}
					subdate.innerHTML = timeConverter(theReimbursements[i].submitDate);
					var theResDate = theReimbursements[i].resolveDate;
					if(theResDate){
						resdate.innerHTML = timeConverter(theReimbursements[i].resolveDate);
					}
					else{
						resdate.innerHTML = "";
					}
					
					var tyId = theReimbursements[i].statusId;
					var thatstat =  getType(tyId,reimbStatuses);
					statid.innerHTML = thatstat;
					desc.innerHTML = theReimbursements[i].description;
					resnotes.innerHTML = theReimbursements[i].resolveNotes;
					amt.innerHTML = "$"+theReimbursements[i].amount;
					
					
				}
			}
		}
	}
	xhr.open("GET", "getReimbursements", true);
	xhr.send();
	
}



function pendingReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto2 = JSON.parse(xhr.responseText);
			var pendingReimb = dto2.reimbursements;
			var reimbStatuses = dto2.statuses;
			var allTheUsers = dto2.allUsers;

			if (pendingReimb.length == 0){
				document.getElementById("reimbursements").style.visibility = "hidden"; 
			}
			else{
	
				for(var i = 0; i < pendingReimb.length; i++){
					
					console.log("!!!!!!!!!!!!!!!!!!!!!! "+i+" !!!!!!!!!!!!!!!");
					
					var table = document.getElementById("pendingReimbTable");
					var nrow = table.insertRow();
					var preimb = nrow.insertCell(0);
					var psubid = nrow.insertCell(1);
					var presid = nrow.insertCell(2);
					var psubdate = nrow.insertCell(3);
					var presdate = nrow.insertCell(4);
					var pstatid = nrow.insertCell(5);
					var pdesc = nrow.insertCell(6);
					var presnotes = nrow.insertCell(7);
					var pamt = nrow.insertCell(8);
					var approve = nrow.insertCell(9);
					var deny = nrow.insertCell(10);
					
					
					preimb.innerHTML = pendingReimb[i].r_id;
					psubid.innerHTML = getTheirName(pendingReimb[i].submitterId,allTheUsers);
					var presolverid = pendingReimb[i].resolverId;
					if(presolverid<1){
						presid.innherHTML = "";
					}
					else{
						presid.innerHTML = getTheirName(pendingReimb[i].resolverId,allTheUsers);
					}
					psubdate.innerHTML = timeConverter(pendingReimb[i].submitDate);
					presdate.innerHTML = pendingReimb[i].resolveDate;
					var tyId = pendingReimb[i].statusId;
					var thatstat =  getType(tyId,reimbStatuses);
					pstatid.innerHTML = thatstat;
					pdesc.innerHTML = pendingReimb[i].description;
					presnotes.innerHTML = pendingReimb[i].resolveNotes;
					pamt.innerHTML = "$"+pendingReimb[i].amount;
					
				}

				var radioRID = document.getElementById("needsHandling");
				var theOptions = "";
				for(var i = 0; i < pendingReimb.length; i++){
					theOptions+="<input type=\"radio\" id=\"option"+i+"\" name=\"ridoption\" value="+pendingReimb[i].r_id+">"+pendingReimb[i].r_id+"<br/>";
				}
				radioRID.innerHTML = theOptions;
				
			}
		}
	}
	
	xhr.open("GET", "pendingReimbursements", true);
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

