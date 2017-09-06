function onLoad() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("requests").innerHTML =
				xhr.responseText;
		}
	}
	xhr.open("GET", "employee_home", true); //HTTP method, url-pattern, use asynchronously
	xhr.send(); 
}