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
	  var response = json.responseText;
	  var user_info = JSON.parse(response);
	  
	  if(user_info.user.isManager == 0){
		  document.getElementById("reimburseButton").style.display = 'block';
	  }
	  
	  document.getElementById("name").innerHTML = user_info.user.firstname + " " +user_info.user.lastname;
	  document.getElementById("username").innerHTML = user_info.user.username;
	  document.getElementById("email").innerHTML = user_info.user.email;
	  document.getElementById("userid").innerHTML = user_info.user.userId;
	  document.getElementById("numReim").innerHTML = user_info.reimbursements.length;
	  document.getElementById("inputfn").value = user_info.user.firstname;
	  document.getElementById("inputln").value = user_info.user.lastname;
	  document.getElementById("inputemail").value = user_info.user.email;
	  
	  
}

window.onload = function(){
	getInfo();
}