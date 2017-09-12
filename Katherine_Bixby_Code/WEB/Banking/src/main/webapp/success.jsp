<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron" style="background:transparent !important">
			<div class="media-middle" align="center">
				<img class="media object" src="images/congratulations.gif"
					alt="YOU'RE A WINNER">
			</div>
			<br><br>
			Logged in as <%=request.getAttribute("username") %>
		</div>
	</div>
	
</body>
</html>