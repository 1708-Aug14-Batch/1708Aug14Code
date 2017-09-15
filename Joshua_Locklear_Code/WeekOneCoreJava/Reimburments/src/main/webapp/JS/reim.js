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
	xhr2.open("GET", "Reimbursement", true);
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
						var rID = row.insertCell(0);
						//var fname = row.insertCell(1);
						//var lname = row.insertCell(2);
						
						var status = row.insertCell(1);
						var subDate = row.insertCell(2);
						var ResDate = row.insertCell(3);
						var reason = row.insertCell(4);
						var amount = row.insertCell(5);
						var resID = row.insertCell(6);
						if(selection === "All Reimbursements"){
							if(accounts[i].status_id === 0){
								status.innerHTML = "Pending";
							}
							else if(accounts[i].status_id === 1){
								status.innerHTML = "Approved";
								for(var j = 0; j < userlist.length; j++){
									if(userlist[j].userid === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstName +" " +userlist[j].lastName;
									}
								}
							}
							else if(accounts[i].status_id === 2){
								status.innerHTML = "Denied";
								for(var j = 0; j < userlist.length; j++){
									if(userlist[j].userid === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstName +" " +userlist[j].lastName;
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
									if(userlist[j].userid === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstName + " " + userlist[j].lastName;
									}
								}
								
							}
							else if(accounts[i].status_id === 2){
								status.innerHTML = "Denied";
								for(var j = 0; j < userlist.length; j++){
									if(userlist[j].userid === accounts[i].res_id){
										resID.innerHTML = userlist[j].firstName +" " +userlist[j].lastName;
									}
								}
							}
							else if(accounts[i].status_id === 0)
								continue;
						}
//						if(userlist != null){
//						console.log("We here?");
//							for(var j = 0; j < userlist.length; j++){
//							if(userlist[j].userid == accounts[i].sub_id){
//								console.log(userlist[j]);
//								fname.innerHTML = userlist[j].firstName;
//								lname.innerHTML = userlist[j].lastName;
//							}
//						}
//						}
//						else{
//							console.log("WE GOT HERE");
//							fname.innerHTML = user.firstName;
//							lname.innerHTML = user.lastName;
//						}
						
						
						
						rID.innerHTML = accounts[i].r_id;
						if(accounts[i].status_id == 1 || accounts[i].status_id == 2){
							rID.setAttribute("class","resolvedID");
							rID.setAttribute("data-toggle","modal");
							rID.setAttribute("data-target","#exampleModal");
							$('.resolvedID').css({"color": "red", "text-decoration": "underline"});
						}
						if(user.isManager == 1){
							if(accounts[i].status_id == 0){
								rID.setAttribute("class","resolvedID");
								rID.setAttribute("data-toggle","modal");
								rID.setAttribute("data-target","#pendingModal");
								$('.resolvedID').css({"color": "blue", "text-decoration": "underline"});
							}
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

			$(".resolvedID").on('click',function(){
				var value = $(this).text();
				console.log(value);
				for(var i = 0; i < accounts.length; i++){
					if(accounts[i].r_id == value){
						
						$("#modalAmount").val("$" + accounts[i].amount);
						$("#modalreAmount").val("$" + accounts[i].amount);
						$("#modalNotes").val(accounts[i].notes);
						for(var j = 0; j < userlist.length; j++){
							if(userlist[j].userid === accounts[i].res_id){
								$("#modalResolved").val(userlist[j].firstName + " " + userlist[j].lastName);
							}
							if(userlist[j].userId == accounts[i].sub_id){
								$("#modalSubmitted").val(userlist[j].firstName + " " + userlist[j].lastName);
								$("#modalDescription").val(accounts[i].description);
								$("#reID").val(accounts[i].r_id);
							}
						}
						
					}
				}
			})
		}
	}
	xhr.open("GET", "Reimbursement", true);
	xhr.send();
	reset = reset + 1;
	
});


$("#approve").on('click', function(){


	
	var xhr3= new XMLHttpRequest();
	var notes = $("#modalGivenNotes").val();
	console.log(notes);
	var appID = "1";
	var re_id = $("#reID").val();
	console.log(re_id);
	var tx = [notes,appID,re_id];
	
	tx = JSON.stringify(tx);
	
	console.log(tx);
	xhr3.open("POST", "Reimbursement", true);
	xhr3.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr3.send(tx);
	
	$('#pendingModal').modal("toggle");
})

$("#denied").on('click', function(){
	var xhr4= new XMLHttpRequest();
	var notes = $("#modalGivenNotes").val();
	console.log(notes);
	var appID = "2";
	var re_id = $("#reID").val();
	console.log(re_id);
	var tx = [notes,appID,re_id];
	
	tx = JSON.stringify(tx);
	
	console.log(tx);
	xhr4.open("POST", "Reimbursement", true);
	xhr4.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr4.send(tx);
	
	$('#pendingModal').modal("toggle");
})



})