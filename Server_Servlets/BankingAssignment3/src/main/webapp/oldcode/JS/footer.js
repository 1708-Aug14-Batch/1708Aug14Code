/**
 * 
 */

loadFooter();

function loadFooter() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// Replace the "view" div with the xhr response
			document.getElementById("footer_view").innerHTML = xhr.responseText;
			getUserInformation();
		}
	}
	xhr.open("GET", "../getFooterView", true);
	xhr.send();
}
