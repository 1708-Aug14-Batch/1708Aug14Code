function getInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			doResponse(this);
		}
	}
	
	//HTTP method, servlet-mapping name, use Asynchronous? (always true)
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	var post = "username="+document.getElementById("username").value+"&password="+ document.getElementById("password").value;
			
	
	xhr.send(post);
}

function doResponse(json){
	var response = json.responseText;
	console.log(response);
	if(response == 'username'){
		document.getElementById("showAlert").innerHTML = '<div class="alert alert-danger">Incorrect User, try again.</div>';
	}
	else if(response == 'password'){
		document.getElementById("showAlert").innerHTML = '<div class="alert alert-danger">Incorrect Credentials, try again.</div>';
	}
	else{
		var user_info = JSON.parse(response);
		if(user_info.user.isManager == 1){
			window.location = "manager_homepage.html";
		}
		else{
			window.location = "homepage.html";
		}
	}
}

window.onload = function(){
	document.getElementById("loginButton").addEventListener("click", function(){
		getInfo();
	});
}