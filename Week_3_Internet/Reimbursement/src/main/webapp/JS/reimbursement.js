/**
 * 
 */


window.onload = function(){
	
	getReimbursement();
	
}


function getReimbursement(){
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
					var subDate = row.insertCell(3);
					var ResDate = row.insertCell(4);
					var reason = row.insertCell(5);
					var amount = row.insertCell(6);
					var resID = row.insertCell(7);
					fname.innerHTML = user.firstname;
					lname.innerHTML = user.lastname;
					rID.innerHTML = accounts[i].r_id;
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
}


$(document).ready(function(){
	$('button').click(function(){
		
		var email = $('#inputEmail3').val();
		var password = $('#inputPassword3').val();
		var reason = $('#inputReason').val();
		var amount = $("#inputAmount").val();
		
		var tx = [email,password,reason,amount];
		
		tx = JSON.stringify(tx);
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				
				
			}
		}
		
		xhr.open("POST", "whatever", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(tx);
		
		
	});

});

