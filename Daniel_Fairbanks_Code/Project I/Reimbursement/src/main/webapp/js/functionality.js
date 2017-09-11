function onLoad() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			if (xhr.responseText == "Invalid"){
				window.location.href = "login.html";
			}
			else{
				document.getElementById("requests").innerHTML = xhr.responseText;
				$('[data-toggle="tooltip"]').tooltip();
				$('[data-toggle="popover"]').popover();
			}
		}
	}
	xhr.open("GET", "employee_home", true); //HTTP method, url-pattern, use asynchronously
	xhr.send();
}