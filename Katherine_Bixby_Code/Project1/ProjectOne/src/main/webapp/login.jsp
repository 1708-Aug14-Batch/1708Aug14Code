<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Diplomata" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Balthazar" rel="stylesheet">
<script src="https://www.w3schools.com/lib/w3color.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Login</title>
<style>
p {
	text-align: center;
}

input[type=submit] {
	padding: 5px 15px;
	background: #FFCF46;
	border: 0 none;
	cursor: pointer;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

.jumbotron {
	background-color: RGBA(10, 20, 60, 0.95);
}

body {
	background-image: url("images/background1.jpg");
}
</style>
</head>
<body>
	<br>
	<div class="container-fluid">
		<div class="jumbotron">
			<h1 class="text-center">
				<font face="Diplomata" color="#FFCF46">Login</font>
			</h1>
			<br />
			<div align="center">
				<form action="login" method="post" class="text-center">
					<font face="Balthazar" color="black">
					<input type="text" id="username" name="username" placeholder="Enter username"><br />
						<br />
						<input type="password" id="password" name="password" placeholder="Password"><br /> <br />
						<input type="submit" value="Login" id="loginSubmit" />
					</font> <br>
					<br>
				</form>
			</div>
			<!--<font face="Balthazar" color="#FFCF46"><p id="message"></p></font>-->
			
			<div id="loginAlert" align="center">
				<font face="Balthazar" color="#FFCF46" size="5">
					${loginAlert}
				</font>
			</div>
		</div>
	</div>

	
</body>
</html>