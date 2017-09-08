
function getInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			showResolved(this);
		}
	}
	
	//HTTP method, servlet-mapping name, use Asynchronous? (always true)
	xhr.open("POST", "employeeresolved", true);
	xhr.send(null);
}
function showResolved(json) {
	  var i;
	  var response = json.responseText;
	  var user_info = JSON.parse(response);
	  var list_items_approved = "";
	  var list_items_denied = "";
	  var list_items = "";
	  var approve_count = 0;
	  var deny_count = 0;
	  
	  for (i = 0; i <user_info.reimbursements.length; i++) { 
		  list_items = '<li class="list-group-item m-1"> <div class="row"><div class="col-3"><h5>Amount: $<span>' + user_info.reimbursements[i].amount;
		  list_items += '</span></h5><a class="btn btn-info mt-3" data-toggle="collapse" href="#collapseItem' + user_info.reimbursements[i].reimbursementId;
		  list_items += '" aria-expanded="false" aria-controls="collapseExample"> More info </a></div><div class="col"><strong>Description: </strong><span>';
		  list_items += user_info.reimbursements[i].description;
		  list_items += '</span><div class="collapse mt-2" id="collapseItem'+ user_info.reimbursements[i].reimbursementId;
		  list_items += '"><div class="card card-body"><div class="row"><div class="col">Reimbursement Number: <span>' + user_info.reimbursements[i].reimbursementId;
		  list_items += '</span></div><div class="col">Submit Date: <span>';
		  
		  var date = new Date(parseInt(user_info.reimbursements[i].submitDate));
		  list_items += date.toLocaleDateString();
		  list_items += '</span></div></div><hr style="width: 100%; color: black; height: 1px; background-color:black;" />';
		  list_items += '<div class="row"> <div class="col"><strong>Reason: </strong><br><span>'+user_info.reimbursements[i].managerNotes+'</span></div>';
		  
		  date = new Date(parseInt(user_info.reimbursements[i].resolveDate));
		  list_items += '<div class="col">Resolve Date: <span>'+date.toLocaleDateString()+'</span></div>';
		  list_items += '</div></div></div></div></div></li>';
		  
		  if(user_info.reimbursements[i].statusId == 1){
			  list_items_approved += list_items;
			  approve_count++;
		  }
		  else{
			  list_items_denied += list_items;
			  deny_count++;
		  }
	  }
	  if(approve_count > 0){
		  document.getElementById("ul-approved").innerHTML = list_items_approved;
	  }
	  else{
		  document.getElementById("ul-approved").innerHTML = "<h3>No Approved Requests</h3>";
	  }
	  if(deny_count > 0){
		  document.getElementById("ul-denied").innerHTML = list_items_denied;
	  }
	  else{
		  document.getElementById("ul-denied").innerHTML = "<h3>No Denied Requests</h3>";
	  }
}

window.onload = function(){
	getInfo();
}
