/**
 * 
 */



var reset = 0;


$(document).ready(function(){
	
	var xhr2 = new XMLHttpRequest();
	xhr2.onreadystatechange = function(){
		if(xhr2.readyState == 4 && xhr2.status == 200){
			var dto2 = JSON.parse(xhr2.responseText);
			var user2 = dto2.user
			if(user2.isManager == 1){
				$("#addReimbursement").remove();
			}
		}
		
	}
	xhr2.open("GET", "UserReimbursement", true);
	xhr2.send();
	
	
	
	
	
	
$('#selectList').on('click',function(){
	
	var selection = $("option:selected").text();

var restriction;
if (selection === "Pending Reimbursements"){
	restriction = 0;
}
else if(selection === "All Reimbursements"){
	restriction = 2;
}
else if(selection === "Resolved Reimbursements"){
	restriction = 1;
}
////}	console.log("Selection: " + selection);
//	console.log("Restriction: " + restriction);
	
	if(reset != 0){
		$("td").remove();
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			var userlist = dto.userList;
			console.log("User: " + user);
			console.log("UserList: "+ userlist);
			console.log("Accounts: " + accounts)
//			document.getElementById("name").innerHTML = user.firstname + " " + user.lastname;
			if(accounts.length == 0){
			document.getElementById("accounts").style.visiblity = "hidden";
			}
			else{
				
				for (var i = 0; i < accounts.length; i++){
					
					if(restriction == 0){
						if(accounts[i].status_id != 0)
							continue;
					}
					else if(restriction == 1){
						if(accounts[i].status_id != 1 && accounts[i].status_id != 2)
							continue;
					}


					if(accounts[i].status_id === 0 || accounts[i].status_id === 1 || accounts[i].status_id === 2){
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
						if(selection === "All Reimbursements"){
							if(accounts[i].status_id === 0){
								status.innerHTML = "Pending";
							}
							else if(accounts[i].status_id === 1){
								status.innerHTML = "Approved";
								for(var j = 0; j < userlist.length; j++){
									if(userlist[j].userId === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstname +" " +userlist[j].lastname;
									}
								}
							}
							else if(accounts[i].status_id === 2){
								status.innerHTML = "Denied";
								for(var j = 0; j < userlist.length; j++){
									if(userlist[j].userId === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstname +" " +userlist[j].lastname;
									}
								}
							}
							else
								continue;
						}
						else if(selection === "Pending Reimbursements"){
							if(accounts[i].status_id === 0){
							status.innerHTML = "Pending"
							}
							else
								continue;
						}
						else if(selection === "Resolved Reimbursements"){
							console.log("Resolved ID: " + accounts[i].status_id)
							
							if(accounts[i].status_id === 1){
								status.innerHTML = "Approved";
								for(var j = 0; j < userlist.length; j++){
									if(userlist[j].userId === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstname + " " + userlist[j].lastname;
									}
								}
							}
							else if(accounts[i].status_id === 2){
								status.innerHTML = "Denied";
								for(var j = 0; j < userlist.length; j++){
									if(userlist[j].userId === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstname +" " +userlist[j].lastname;
									}
								}
							}
							else if(accounts[i].status_id === 0)
								continue;
						}
						if(userlist != null){
						console.log("We here?");
							for(var j = 0; j < userlist.length; j++){
							if(userlist[j].userId == accounts[i].sub_id){
								console.log(userlist[j]);
								fname.innerHTML = userlist[j].firstname;
								lname.innerHTML = userlist[j].lastname;
							}
						}
						}
						else{
							console.log("WE GOT HERE");
							fname.innerHTML = user.firstname;
							lname.innerHTML = user.lastname;
						}
						
						
						
						rID.innerHTML = accounts[i].r_id;
						if(accounts[i].status_id == 1 || accounts[i].status_id == 2){
							rID.setAttribute("class","resolvedID");
							rID.setAttribute("data-toggle","modal");
							rID.setAttribute("data-target","#exampleModal");
							$('.resolvedID').css({"color": "blue", "text-decoration": "underline"});
						}
						
						
						
						var date = new Date(parseInt(accounts[i].subDate));
						accounts[i].subDate = date.toLocaleDateString();
						console.log(accounts[i].subDate);
						subDate.innerHTML = accounts[i].subDate;
						var resDate = new Date(parseInt(accounts[i].resDate));
						accounts[i].resDate = resDate.toLocaleDateString();
						console.log("Res date: " +accounts[i].resDate)
						if(accounts[i].ResDate == null){
							ResDate.innerHTML = " ";
						}
						ResDate.innerHTML = accounts[i].resDate;
						reason.innerHTML = accounts[i].description;
						amount.innerHTML = "$" + accounts[i].amount;
//						resID.innerHTML = accounts[i].res_id;
							
						
						console.log(accounts);
					}
				}
			}

		}
	}
	xhr.open("GET", "UserReimbursement", true);
	xhr.send();
	reset = reset + 1;
});

})




