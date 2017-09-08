

//Views

function loadNavbar(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('navi').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET","getNavbar",true);
	xhr.send();
}
