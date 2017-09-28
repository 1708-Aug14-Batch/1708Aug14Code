window.onload = function(){
	loadImg();
	document.getElementById("addPic").addEventListener("click", uploadPic);
};

function loadImg(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var dto = JSON.parse(xhr.responseText);
			var imgList = dto.imgs;
			for(var i=imgList.length-1; i>=0; i--){
				
				var table = document.getElementById("imgList");
				var row = table.insertRow();
				var cake = row.insertCell(0);
				var word = row.insertCell(1);
				
				var img = document.createElement("img");
				img.src = imgList[i].link;
				var src = document.getElementById("here");
				
				cake.appendChild(img);
				word.innerHTML=imgList[i].description;
			}
		}
	}
	
	xhr.open("GET", "load", true);
	xhr.send();
}

function uploadPic(){
	var descript = document.getElementById("description").value;
	//var file = document.getElementById("file").value;
	
	var file="blob:http://fiddle.jshell.net/fcae7554-b2f2-4e6d-a5cd-52f2d00732bc";
	/*$('#file').change( function(event) {
		var tmppath = URL.createObjectURL(event.target.files[0]);
		    $("img").fadeIn("fast").attr('src',URL.createObjectURL(event.target.files[0]));
		    $("#disp_tmp_path").html("Temporary Path(Copy it and try pasting it in browser address bar) --> <strong>["+tmppath+"]</strong>");
			console.log(tmppath);
			var tx = [descript,tmppath];
			tx = JSON.stringify(tx);
			var xhr = new XMLHttpRequest();
		});
	*/
	
	//var filetho = file.replace("C:\\fakepath\\", "C:\\Users\\1Z4XS\\Desktop\\imgTest\\");
	//var filetho = file.replace("C:\\fakepath\\", "C:\\Users\\*\\");
	var tx = [descript,file];
	tx = JSON.stringify(tx);
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "upload", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
}