/**
 * 
 */



var reset = 0;

function getReimbursement(){
	var selection = $(".dropdown-item :selected").text();
	console.log(selection);
	console.log(reset);
	if(reset != 0){
		$("td").remove();
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			console.log(accounts);
//			document.getElementById("name").innerHTML = user.firstname + " " + user.lastname;
			if(accounts.length == 0){
			document.getElementById("accounts").style.visiblity = "hidden";
			}
			else{
				
				for (var i = 0; i < accounts.length; i++){
					
					var table = document.getElementById("list");
					var row = table.insertRow();
					var fname = row.insertCell(0);
					var lname = row.insertCell(1);
					var rID = row.insertCell(2);
					var status = row.insertCell(3);
					var subDate = row.insertCell(4);
					var ResDate = row.insertCell(5);
					var reason = row.insertCell(6);
					var amount = row.insertCell(7);
					var resID = row.insertCell(8);
					fname.innerHTML = user.firstname;
					lname.innerHTML = user.lastname;
					rID.innerHTML = accounts[i].r_id;
					if(selection == "All Reimbursements"){
						if(accounts[i].status_id === 0){
							status.innerHTML = "Pending";
						}
						else if(accounts[i].status_id === 1){
							status.innerHTML = "Approved";
						}
						else if(accounts[i].status_id === 2){
							status.innerHTML = "Denied";
						}
					}
					else if(selection == "Pending Reimbursements"){
						status.innerHTML = "Pending"
					}
					else if(selection == "Resolved Reimbursements"){
						if(accounts[i].status_id == 1){
							status.innerHTML = "Approved";
						}
						else if(accounts[i].status_id == 2){
							status.innerHTML = "Denied";
						}
					}
					subDate.innerHTML = accounts[i].subDate;
					ResDate.innerHTML = accounts[i].resDate;
					reason.innerHTML = accounts[i].description;
					amount.innerHTML = "$" + accounts[i].amount;
					resID.innerHTML = accounts[i].res_id;
				}
				
			}
		}
	}
	xhr.open("GET", "UserReimbursement", true);
	xhr.send();
	reset = reset + 1;
}




