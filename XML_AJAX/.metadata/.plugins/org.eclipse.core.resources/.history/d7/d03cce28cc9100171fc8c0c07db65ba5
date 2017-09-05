<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jQuery AJAX example with Java</title>
<script type="text/javascript" src="./hs/jquery-1.11.3.min.js"></script>
</head>
<body>
	<center>
		<div id="divId">
			Username : <input type="text" name="username" id="username"/><br>
			Password : <input type="password" name="password" id="password"/><br>
			<button name="login" id="login">Login</button>
		</div>
		<div id="messageDiv" style="display:none;"></div>
	</center>
	<script>
		$("#login").on('click', function() {
			var username = $("#username").val();
			var password = $("#password").val();
			if(username == "") {
				$('#messageDiv').css("display", "none");
				alert("Username is required");
				return;
			}
			if(password == "") {
				$('#messageDiv').css("display", "none");
				alert("Password is required");
				return;
			}
			$.ajax({
				url : "loginRequest",
				method : get,
				data : {
					username : username,
					password : password
				},
				success : function(results){
					if(results != null && results != "") {
						showMessage(results);
						$('#messageDiv').css("display", "block");
					}else{
						$('#messageDiv').css("display", "none");
						$('#messageDiv').html("");
						alert("Some exception has occurred! Please try again.");
					}
				}
			});
		});
		
		// function to display message to the user
		function showMessage(results) {
			if (results== 'SUCCESS'){
				$('#messageDiv').html("<font color='green'>You are successfully logged in. </font>")
			}else if(results== 'FAILURE'){
				$('#messageDiv').html("<font color='red'>Username or password is incorrect</font>")
			}
		}
	</script>
</body>
</html>