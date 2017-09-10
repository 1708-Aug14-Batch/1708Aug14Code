// ....

function loadLogin(){
	$.ajax({
		type: 'GET',
		url: 'loadLogin',
		success: function(response){
			document.getElementById('content').innerHTML = response;
			$('#login').click(loginRequest);
			$('#loginKey').keypress(function(e){
				if(e.which == 13){
					$('#login').click(loginRequest());
				}
			})
		}
	})
}

function loginRequest(){
 	var email = $('#email').val();
 	var password = $('#password').val();

 	var to =[email,password];

 	to = JSON.stringify(to);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if(xhr.responseText == "0" || xhr.responseText == "1"){
				loadMenu(xhr.responseText);
			}else if(xhr.responseText == "Incorrect Password"){
				document.getElementById('fail').innerHTML = xhr.responseText;
			}else if(xhr.responseText == "Incorrect Credentials"){
				document.getElementById('fail').innerHTML = xhr.responseText;
			}
		}	
	}
	xhr.open("POST", "loginRequest", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
	xhr.send(to);
}

function loadMenu(value){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content').innerHTML = xhr.responseText;
			loadHome();
			if(value == "0"){
				$('#four').click(loadSubmitReim);
			}else if(value == "1"){
				$('#four').click(loadRegisterEmployee);
			}
			//$('#one').click(loadHome);
			$('#two').click(loadUser);
			$('#three').click(loadReim);
			$('#five').click(invalidateSession);
		}
	}
	xhr.open("GET", "loadMenu", true);
	xhr.send();
}

function loadUser(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			getUserInfo();
			$('#edit').click(function(){
				if($('#edit').text() == "Edit"){
					$("#fn").prop('readonly', false);
					$("#ln").prop('readonly', false);	
					$("#email").prop('readonly', false);
					$("#password").prop('readonly', false);	
					$('#edit').text("Save");	
				}else if($('#edit').text() == "Save"){
					$('#myModal').modal('show');
					$('#update').click(validateUpdateUserInfo);
				}
			})
		}
	}
	xhr.open("GET", "loadUser", true);
	xhr.send();
}

function getUserInfo(){
	$.ajax({
		type: 'GET',
		url: 'userInfo',
		success: function(response){
			//var dto = JSON.parse(response);
			var user = response;
			$('#fn').val(user.fname);
			$('#ln').val(user.lname);
			$('#email').val(user.email);
			$('#password').val(user.password);
			//$('#fn').attr("placeholder",user.fname);
			//$('#ln').attr("placeholder",user.lname);
			//$('#email').attr("placeholder",user.email);
		}
	})
}

function validateUpdateUserInfo(){
	var password1 = $('#password1').val(); 
 	var password2 = $('#password2').val();	

 	if(password1 == password2){
	 	var to = [password2];

	 	to = JSON.stringify(to);

		$.ajax({
	 		type: 'POST',
	 		url: 'validateUser',
	 		data: to,
	 		dataType: 'JSON',
	 		success: function(response){
				if(response == true){
					var fn = $('#fn').val();
					var ln = $('#ln').val();
				 	var email = $('#email').val();
				 	var password = $('#password').val();
				 	var to = [fn,ln,email,password];

				 	to = JSON.stringify(to);
					$.ajax({
				 		type: 'POST',
				 		url: 'updateUserInfo',
				 		data: to,
				 		dataType: 'JSON',
				 		success: function(response2){
							if(response2 == "User Information Updated"){
								$('#updateStatus').text("User Information Updated");
								$("#fn").prop('readonly', true);
								$("#ln").prop('readonly', true);
								$("#email").prop('readonly', true);
								$("#password").prop('readonly', true);
								$('#edit').text("Edit");
				 			}
				 		}
					})	
				}else if(response == false){
					$('#updateStatus').text("Invalid Password");
				}
	 		}
		})
 	}
	else{
 		$('#updateStatus').text("Password Mismatch");
	}
}

function loadReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#reimTable').DataTable();
			getReimInfo();
		}
	}
	xhr.open("GET", "loadReim", true);
	xhr.send();
}

function getReimInfo(){
	$.ajax({
		type: 'GET',
		url: 'reimInfo',
		success: function(response){
			var reim = response;
			console.log(reim);
			var reimTable = document.getElementById('reimTable');
			console.log(reimTable);
			for(var x = 0; x<reim.length; x++){
				var row = reimTable.insertRow(x+1);
				var col1 = row.insertCell(0);
				var col2 = row.insertCell(1);
				var col3 = row.insertCell(2);
				var col4 = row.insertCell(3);
				var col5 = row.insertCell(4);
				var col6 = row.insertCell(5);
				var col7 = row.insertCell(6);

				col1.innerHTML = reim[x].reimID;
				col2.innerHTML = (reim[x].submitterID.fname + " " + reim[x].submitterID.lname);
				if(reim[x].resolverID){
					col3.innerHTML = (reim[x].resolverID.fname + " " + reim[x].resolverID.lname);
				}
				else{
					col3.innerHTML = (reim[x].resolverID);
				}
				col4.innerHTML = reim[x].submitDate;
				col5.innerHTML = reim[x].resolveDate;
				col6.innerHTML = reim[x].statusID.statusName;
				col7.innerHTML = reim[x].amount;
				console.log(reim[x]);
			}
		}
	})
}

function loadSubmitReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#submit').click(submitReim);
		}
	}
	xhr.open("GET", "loadSubmitReim", true);
	xhr.send();
}

function submitReim(){
	var description = $('#description').val();
	var amount = $('#amount').val();

 	var to = [description,amount];

 	to = JSON.stringify(to);
 	$.ajax({
 		type: 'POST',
 		url: 'submitReim',
 		data: to,
 		dataType: 'JSON',
 		success: function(response){
			if(response == "Reimbursement Submitted"){
				alert("Reimbursement Submitted");
 			}
 		}
	})
}

function loadRegisterEmployee(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#register').click(registerEmployee);
		}
	}
	xhr.open("GET", "loadRegisterEmployee", true);
	xhr.send();
}

function registerEmployee(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
 	var email = $('#email').val();
 	var password = $('#password').val();

 	var to = [fn,ln,email,password];

 	to = JSON.stringify(to);

	$.ajax({
		type: 'POST',
		url: 'registerEmployee',
		data: to,
		dataType: 'JSON',
		success: function(response){
			if(response == "Employee Registered"){
				alert("Employee Registered");	
			}else if(response == "Failed Registration"){
				alert("Failed Registration");	
			}
		}
	})
}

function invalidateSession(){
	$.ajax({
		type: 'GET',
		url: 'logout',
		success: function(){
			window.location = "";
		}
	})
}

//???
function loadHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "loadHome", true);
	xhr.send();
}

$(document).ready(function(){
	loadLogin();
});