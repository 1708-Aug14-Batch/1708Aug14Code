/**
 * 
 */

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
	  var table="<tr><th>ID</th><th>Status</th><th>Amount</th><th>Description</th><th>Manager Notes</th><th>Submitted</th></tr>";
	  var user_info = JSON.parse(response);
	  document.getElementById("username").innerHTML = "Welcome " + user_info.user.firstname + " " + user_info.user.lastname;
	  
	  
	  for (i = 0; i <user_info.reimbursements.length; i++) { 
	    table += "<tr><td>" + user_info.reimbursements[i].reimbursementId +"</td><td>";
	    
	    if(user_info.reimbursements[i].statusId == 0){
	    	table+= "Pending </td><td>";
	    }
	    else if(user_info.reimbursements[i].statusId == 1){
	    	table+= "Approved </td><td>";
	    }
	    else{
	    	table+= "Denied </td><td>";
	    }
	    table+=user_info.reimbursements[i].amount +"</td><td>";
	    
	    if(user_info.reimbursements[i].description != null){
	    	table+=user_info.reimbursements[i].description +"</td><td>";
	    }
	    else{
	    	table+="</td><td>";
	    }
	    
	    if(user_info.reimbursements[i].managerNotes != null){
	    	table+=user_info.reimbursements[i].managerNotes +"</td><td>";
	    }
	    else{
	    	table+="</td><td>";
	    }
	    
	    var date = new Date(parseInt(user_info.reimbursements[i].submitDate));
	    table+= date.toLocaleDateString() + "</td></tr>";
	    
	  }
	  if(user_info.reimbursements.length==0){
		  document.getElementById("user-table").style.visibility = "hidden";
	  }
	  else{
		  document.getElementById("user-table").innerHTML = table;
	  }
}

window.onload = function(){
	getInfo();
}
