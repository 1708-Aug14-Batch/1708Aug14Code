window.onload = function() {
	getLoginInfo();
}

function getLoginInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200)  {
			var user = xhr.responseText;
			console.log(user);
			document.getElementById("uname").innerHTML = user;
		}
	}
	xhr.open('Get', "homePage", true);
	xhr.send();
}
