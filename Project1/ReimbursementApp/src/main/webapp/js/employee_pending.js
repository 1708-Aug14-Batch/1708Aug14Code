
function getInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			showPending(this);
		}
	}
	
	//HTTP method, servlet-mapping name, use Asynchronous? (always true)
	xhr.open("POST", "employeepending", true);
	xhr.send(null);
}
function showPending(json) {
	  var i;
	  var response = json.responseText;
	  var user_info = JSON.parse(response);
	  var list_items = "";
	  for (i = 0; i <user_info.reimbursements.length; i++) { 
		  list_items += '<li class="list-group-item m-1"> <div class="row"><div class="col-3"><h5>Amount: $<span>' + user_info.reimbursements[i].amount.toFixed(2);
		  list_items += '</span></h5><a class="btn btn-info m-3" data-toggle="collapse" href="#collapseItem' + user_info.reimbursements[i].reimbursementId;
		  list_items += '" aria-expanded="false" aria-controls="collapseExample"> More info </a></div><div class="col"><p>Description: <span>';
		  list_items += user_info.reimbursements[i].description;
		  list_items += '</span></p><div class="collapse" id="collapseItem'+ user_info.reimbursements[i].reimbursementId;
		  list_items += '"><div class="card card-body"><div class="row"><div class="col">Reimbursement Number: <span>' + user_info.reimbursements[i].reimbursementId;
		  list_items += '</span></div><div class="col">Submit Date: <span>';
		  
		  var date = new Date(parseInt(user_info.reimbursements[i].submitDate));
		  list_items += date.toLocaleDateString();
		  list_items += '</span></div></div></div></div></div></div></li>';
	  }
	  if(user_info.reimbursements.length > 0){
		  document.getElementById("ul-pending").innerHTML = list_items;
	  }
	  else{
		  document.getElementById("ul-pending").innerHTML = "<h3>No pending requests</h3>";
	  }
}

window.onload = function(){
	getInfo();
}
