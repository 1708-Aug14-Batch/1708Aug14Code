window.onload = function(){
	loadImg();
};

function loadImg(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var dto = JSON.parse(xhr.responseText);
			var imgLocation = dto.link;
			var img = document.createElement("img");
			img.src = imgLocation;
			var src = document.getElementById("here");
			src.appendChild(img);
		}
	}
	xhr.open("GET", "getImg", true);
	xhr.send();
};