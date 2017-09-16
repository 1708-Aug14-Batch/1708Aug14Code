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
					$('#myModal').appendTo("body").modal('show');
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
								//$('#updateStatus').text("User Information Updated");
								$("#fn").prop('readonly', true);
								$("#ln").prop('readonly', true);
								$("#email").prop('readonly', true);
								$("#password").prop('readonly', true);
								$('#edit').text("Edit");
								$('#myModal').appendTo("body").modal('hide');
								$('#password1').val("");
								$('#password2').val("");
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