window.onload = function(){
		
	loadDashboardView();
	
};



//Views
function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "getDashboard", true);
	xhr.send();
}