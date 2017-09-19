var reset = 0;


$(document).ready(function(){
		

$('#View').on('click',function(){
	
	var selection = $("#selectList option:selected").text();
var restriction;
	if(reset != 0){
		$("td").remove();
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;
			var EmployeeList = dto.EmployeeList;

			console.log("User: " + user);
			console.log("EmployeeList: "+ EmployeeList);
			console.log("Accounts: " + accounts)
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
						var fname = row.insertCell(1);
						var lname = row.insertCell(2);
						var status = row.insertCell(3);
						var subDate = row.insertCell(4);
						var ResDate = row.insertCell(5);
						var reason = row.insertCell(6);
						var amount = row.insertCell(7);
						var resID = row.insertCell(8);

							if(accounts[i].status_id === 0){
								status.innerHTML = "Pending";
							}
							else if(accounts[i].status_id === 1){
								status.innerHTML = "Approved";
								for(var j = 0; j < EmployeeList.length; j++){
									if(EmployeeList[j].userid === accounts[i].res_id){
										resID.innerHTML = EmployeeList[j].firstName +" " +EmployeeList[j].lastName;
									}
								}
							}
							else if(accounts[i].status_id === 2){
								status.innerHTML = "Denied";
								for(var j = 0; j < EmployeeList.length; j++){
									if(EmployeeList[j].userid === accounts[i].res_id){
										resID.innerHTML = EmployeeList[j].firstName +" " +EmployeeList[j].lastName;
									}
								}
							}
						if(EmployeeList != null){
							for(var j = 0; j < EmployeeList.length; j++){
							if(EmployeeList[j].userid == accounts[i].sub_id){
								console.log(EmployeeList[j]);
								fname.innerHTML = EmployeeList[j].firstName;
								lname.innerHTML = EmployeeList[j].lastName;
							}
						}
						}
						else{
							fname.innerHTML = user.firstName;
							lname.innerHTML = user.lastName;
						}
						rID.innerHTML = accounts[i].r_id;
						if(accounts[i].status_id == 1 || accounts[i].status_id == 2){
							rID.setAttribute("class","resolvedID");
							rID.setAttribute("data-toggle","modal");
							rID.setAttribute("data-target","#exampleModal");
							$('.resolvedID').css({"color": "green"});
						}
						if(user.isManager == 1){
							if(accounts[i].status_id == 0){
								rID.setAttribute("class","resolvedID");
								rID.setAttribute("data-toggle","modal");
								rID.setAttribute("data-target","#pendingModal");
								$('.resolvedID').css({"color": "green"});
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
							ResDate.innerHTML = null;
						}
						ResDate.innerHTML = accounts[i].resDate;
						reason.innerHTML = accounts[i].description;
						amount.innerHTML = "$" + accounts[i].amount;
							
						
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
						for(var j = 0; j < EmployeeList.length; j++){
							if(EmployeeList[j].userid === accounts[i].res_id){
								$("#modalResolved").val(EmployeeList[j].firstName + " " + EmployeeList[j].lastName);
							}
							if(EmployeeList[j].userid == accounts[i].sub_id){
								$("#modalSubmitted").val(EmployeeList[j].firstName + " " + EmployeeList[j].lastName);
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
function mySearch() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value;
	  table = document.getElementById("list");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {

	    td = tr[i].getElementsByTagName("td")[3];
	    if (td) {
	      if (td.innerHTML.indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
function mySearch2() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput2");
	  filter = input.value;
	  table = document.getElementById("list");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      if (td.innerHTML.indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
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
	
	$('#ManagerModal').modal("toggle");
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
	
	$('#ManagerModal').modal("toggle");
})



})


