/**
 * 
 */


$(document).ready(function(){
	document.getElementById("button").addEventListener("click", submitReimbursement)
});

function submitReimbursement(){
	
	var xhr = new XMLHttpRequest();
	
	
	var email = document.getElementById("email").value;
	console.log(email);
	var password = document.getElementById("password").value;
	console.log(password);
	var reason = document.getElementById("reason").value;
	console.log(reason);
	var amount = document.getElementById("amount").value;
	console.log(amount);
	console.log("HERE");
	var tx = [email,password,reason,amount];
	
	tx = JSON.stringify(tx);
	
	
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			//Do things
//			
//		}
//	}
//	
	xhr.open("POST", "AddReimbursement", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
	$("#success").append("#success", + "Reimbursement Request Successfuly Submitted. Check the Reimbursement Page for Status");
	
}




