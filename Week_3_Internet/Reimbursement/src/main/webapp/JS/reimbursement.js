/**
 * 
 */



var reset = 0;


$(document).ready(function(){
	
	var xhr2 = new XMLHttpRequest();
	xhr2.onreadystatechange = function(){
		if(xhr2.readyState == 4 && xhr2.status == 200){
			var dto2 = JSON.parse(xhr2.responseText);
			var user2 = dto2.user;
			var userlist2 = dto2.userList;
			if(user2.isManager == 1){
				$("#addReimbursement").remove();
			}
			for(var i = 0; i < userlist2.length; i++){
				if(userlist2[i].isManager== 0){
				$("#userlist").append($("<option value =" + i+'">' + userlist2[i].firstname + " " + userlist2[i].lastname +'</option>'));
				}
			}
		}
		
	}
	xhr2.open("GET", "UserReimbursement", true);
	xhr2.send();


	
	
$("#userlist").on('click',function(){
	
	var userselection = $("#userlist option:selected").text();
	console.log(userselection);
	
//	var userRestriction = $("#selectlist option:selected").text();
//	var restriction2;
//	if (userRestriction === "Pending Reimbursements"){
//		restriction2 = 0;
//	}
//	else if(userRestriction === "All Reimbursements"){
//		restriction2 = 2;
//	}
//	else if(userRestriction === "Resolved Reimbursements"){
//		restriction2 = 1;
//	}
//	
//	
//	if(reset != 0){
//		$("td").remove();
//	}
//	var xhr5 = new XMLHttpRequest();
//	xhr5.onreadystatechange = function(){
//		if(xhr5.readyState == 4 && xhr5.status == 200){
//			
//			var dto = JSON.parse(xhr.responseText);
//			var user3 = dto.user;
//			var accounts3 = dto.accounts;
//			var userlist3 = dto.userList;
//			console.log("User: " + user3);
//			console.log("UserList: "+ userlist3);
//			console.log("Accounts: " + accounts3)
////			document.getElementById("name").innerHTML = user.firstname + " " + user.lastname;
//			if(accounts3.length == 0){
//			document.getElementById("accounts").style.visiblity = "hidden";
//			}
//			else{
//				
//				for (var i = 0; i < accounts3.length; i++){
//					
//					if(restriction2 == 0){
//						if(accounts3[i].status_id != 0)
//							continue;
//					}
//					else if(restriction2 == 1){
//						if(accounts3[i].status_id != 1 && accounts3[i].status_id != 2)
//							continue;
//					}
//
//
//					if(accounts3[i].status_id === 0 || accounts3[i].status_id === 1 || accounts3[i].status_id === 2){
//						var table = document.getElementById("list");
//						var row = table.insertRow();
//						var fname = row.insertCell(0);
//						var lname = row.insertCell(1);
//						var rID = row.insertCell(2);
//						var status = row.insertCell(3);
//						var subDate = row.insertCell(4);
//						var ResDate = row.insertCell(5);
//						var reason = row.insertCell(6);
//						var amount = row.insertCell(7);
//						var resID = row.insertCell(8);
//						if(userRestriction === "All Reimbursements"){
//							if(accounts3[i].status_id === 0){
//								status.innerHTML = "Pending";
//							}
//							else if(accounts3[i].status_id === 1){
//								status.innerHTML = "Approved";
//								for(var j = 0; j < userlist3.length; j++){
//									if(userlist3[j].userId === accounts3[i].res_id){
//										resID.innerHTML = userlist3[j].firstname +" " +userlist3[j].lastname;
//									}
//								}
//							}
//							else if(accounts3[i].status_id === 2){
//								status.innerHTML = "Denied";
//								for(var j = 0; j < userlist3.length; j++){
//									if(userlist3[j].userId === accounts3[i].res_id){
//										resID.innerHTML = userlist3[j].firstname +" " +userlist3[j].lastname;
//									}
//								}
//							}
//							else
//								continue;
//						}
//						else if(userRestriction === "Pending Reimbursements"){
//							if(accounts3[i].status_id === 0){
//							status.innerHTML = "Pending"
//							}
//							else
//								continue;
//						}
//						else if(userRestriction === "Resolved Reimbursements"){
//							console.log("Resolved ID: " + accounts3[i].status_id)
//							
//							if(accounts3[i].status_id === 1){
//								status.innerHTML = "Approved";
//								for(var j = 0; j < userlist3.length; j++){
//									if(userlist3[j].userId === accounts3[i].res_id){
//										resID.innerHTML = userlist3[j].firstname + " " + userlist3[j].lastname;
//									}
//								}
//								
//							}
//							else if(accounts3[i].status_id === 2){
//								status.innerHTML = "Denied";
//								for(var j = 0; j < userlist3.length; j++){
//									if(userlist3[j].userId === accounts3[i].res_id){
//										resID.innerHTML = userlist3[j].firstname +" " +userlist3[j].lastname;
//									}
//								}
//							}
//							else if(accounts3[i].status_id === 0)
//								continue;
//						}
//						if(userlist != null){
//						console.log("We here?");
//							for(var j = 0; j < userlist3.length; j++){
//							if(userlist3[j].userId == accounts3[i].sub_id){
//								console.log(userlist3[j]);
//								fname.innerHTML = userlist3[j].firstname;
//								lname.innerHTML = userlist3[j].lastname;
//							}
//						}
//						}
//						else{
//							console.log("WE GOT HERE");
//							fname.innerHTML = user3.firstname;
//							lname.innerHTML = user3.lastname;
//						}
//						
//						
//						
//						rID.innerHTML = accounts3[i].r_id;
//						if(accounts3[i].status_id == 1 || accounts3[i].status_id == 2){
//							rID.setAttribute("class","resolvedID");
//							rID.setAttribute("data-toggle","modal");
//							rID.setAttribute("data-target","#exampleModal");
//							$('.resolvedID').css({"color": "blue", "text-decoration": "underline"});
//						}
//						if(user3.isManager == 1){
//							if(accounts3[i].status_id == 0){
//								rID.setAttribute("class","resolvedID");
//								rID.setAttribute("data-toggle","modal");
//								rID.setAttribute("data-target","#pendingModal");
//								$('.resolvedID').css({"color": "blue", "text-decoration": "underline"});
//							}
//						}
//						
//						
//						
//						var date = new Date(parseInt(accounts3[i].subDate));
//						accounts3[i].subDate = date.toLocaleDateString();
//						console.log(accounts3[i].subDate);
//						subDate.innerHTML = accounts3[i].subDate;
//						var resDate = new Date(parseInt(accounts3[i].resDate));
//						accounts3[i].resDate = resDate.toLocaleDateString();
//						console.log("Res date: " +accounts3[i].resDate)
//						if(accounts3[i].ResDate == null){
//							ResDate.innerHTML = " ";
//						}
//						ResDate.innerHTML = accounts3[i].resDate;
//						reason.innerHTML = accounts3[i].description;
//						amount.innerHTML = "$" + accounts3[i].amount;
//						
////						resID.innerHTML = accounts[i].res_id;
//							
//						
//						console.log(accounts);
//					}
//				}
//			}
//
//			$(".resolvedID").on('click',function(){
//				var value = $(this).text();
//				console.log(value);
//				for(var i = 0; i < accounts3.length; i++){
//					if(accounts3[i].r_id == value){
//						
//						$("#modalAmount").val("$" + accounts3[i].amount);
//						$("#modalreAmount").val("$" + accounts3[i].amount);
//						$("#modalNotes").val(accounts3[i].notes);
//						for(var j = 0; j < userlist3.length; j++){
//							if(userlist3[j].userId === accounts3[i].res_id){
//								$("#modalResolved").val(userlist3[j].firstname + " " + userlist3[j].lastname);
//							}
//							if(userlist3[j].userId == accounts3[i].sub_id){
//								$("#modalSubmitted").val(userlist3[j].firstname + " " + userlist3[j].lastname);
//								$("#modalDescription").val(accounts3[i].description);
//								$("#reID").val(accounts3[i].r_id);
//							}
//						}
//						
//					}
//				}
//			})
//		}
//	}
//	xhr5.open("GET", "UserReimbursement", true);
//	xhr5.send();
//	reset = reset + 1;
})


	
	
	
	
$('#selectList').on('click',function(){
	
	var selection = $("#selectList option:selected").text();
	var userselection = $('#userlist option:selected').text();
	console.log(userselection);
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
//			var fullnames = [];
//			for(var i = 0; i <userlist.length; i++){
//				fullnames.push(userlist[i].firstname + " " + userlist[i].lastname);
//			}
//			console.log(fullnames);
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
							if(userlist[j].userId === accounts[i].res_id){
								$("#modalResolved").val(userlist[j].firstname + " " + userlist[j].lastname);
							}
							if(userlist[j].userId == accounts[i].sub_id){
								$("#modalSubmitted").val(userlist[j].firstname + " " + userlist[j].lastname);
								$("#modalDescription").val(accounts[i].description);
								$("#reID").val(accounts[i].r_id);
							}
						}
						
					}
				}
			})
		}
	}
	xhr.open("GET", "UserReimbursement", true);
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
	xhr3.open("POST", "UserReimbursement", true);
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
	xhr4.open("POST", "UserReimbursement", true);
	xhr4.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr4.send(tx);
	
	$('#pendingModal').modal("toggle");
})



})


