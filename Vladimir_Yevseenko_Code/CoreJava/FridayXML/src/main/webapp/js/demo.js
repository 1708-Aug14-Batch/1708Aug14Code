



function getText() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('things').innerHTML = xhr.responseText;
		}
	}
	xhr.open('GET', 'getText', true);
	
	xhr.send();
}


document.getElementById('myBtn').addEventListener('click', getText, false);