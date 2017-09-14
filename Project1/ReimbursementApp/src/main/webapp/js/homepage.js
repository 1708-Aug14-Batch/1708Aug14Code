
function getInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			showNameAndAccounts(this);
		}
	}
	
	//HTTP method, servlet-mapping name, use Asynchronous? (always true)
	xhr.open("POST", "homepage", true);
	xhr.send(null);
}
function showNameAndAccounts(json) {
	  var i;
	  var response = json.responseText;
	  var user_info = JSON.parse(response);
	  document.getElementById("username").innerHTML = "Welcome " + user_info.user.firstname + " " + user_info.user.lastname + ".";
	  
	  var table="<thead><th>ID</th><th>Amount</th><th>Description</th><th>Submitted</th></thead>";
	  var table2="<thead><th>ID</th><th>Amount</th><th>Description</th><th>Reason</th></thead>";
	  var table3="<thead><th>ID</th><th>Amount</th><th>Description</th><th>Reason</th></thead>";
	  for (i = 0; i <user_info.reimbursements.length; i++) { 
		var add = "";
	    add +="<tr><td>";
		  
	    add += user_info.reimbursements[i].reimbursementId +"</td><td>$";
	    
	    add += user_info.reimbursements[i].amount.toFixed(2) +"</td><td>";
	    
	    if(user_info.reimbursements[i].description != null){
	    	add += user_info.reimbursements[i].description +"</td><td>";
	    }
	    else{
	    	add += "</td><td>";
	    }
	    
	    if(user_info.reimbursements[i].statusId == 0){
	    	var date = new Date(parseInt(user_info.reimbursements[i].submitDate));
		    add += date.toLocaleDateString() + "</td></tr>";
		    table += add;
	    }
	    else{
		    if(user_info.reimbursements[i].managerNotes != null){
		    	add += user_info.reimbursements[i].managerNotes +"</td></tr>";
		    }
		    else{
		    	add += "</td></tr>";
		    }
		    
		    if(user_info.reimbursements[i].statusId == 1){
		    	table2 += add;
		    }
		    else{
		    	table3 += add;
		    }
	    }
	  }
	  if(user_info.reimbursements.length==0){
		  document.getElementById("pending-table").style.visibility = "hidden";
		  document.getElementById("approved-table").style.visibility = "hidden";
		  document.getElementById("denied-table").style.visibility = "hidden";
	  }
	  else{
		  document.getElementById("pending-table").innerHTML = table;
		  document.getElementById("approved-table").innerHTML = table2;
		  document.getElementById("denied-table").innerHTML = table3;
		  
	  }
}

window.onload = function(){
	getInfo();
}
