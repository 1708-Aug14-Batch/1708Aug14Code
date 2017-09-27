//var form = document.getElementById('file-form');
//var fileSelect = document.getElementById('file-select');
//var uploadButton = document.getElementById('upload-button');

var stringFile = '';

function getBase64(file) {
	   var reader = new FileReader();
	   reader.readAsDataURL(file);
	   reader.onload = function () {
	     console.log(reader.result);
	     stringFile = reader.result;
	     console.log(stringFile.length);
	   };
	   reader.onerror = function (error) {
	     console.log('Error: ', error);
	   };
	}

document.getElementById('file-select').onchange = function() {
	var fileChooser = document.getElementById('file-select');
	var file = fileChooser.files[0];
	getBase64(file);
}

document.getElementById('upload-button').addEventListener('click', function() {
	if(stringFile != null && stringFile != '') {
		var xhr = new XMLHttpRequest();
		//var tx = JSON.stringify(stringFile);
		//console.log(tx);
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				document.getElementById('IMG').src = xhr.responseText;
			}
		};
		xhr.open('POST', 'UploadImage', true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(stringFile);
	}
});

//form.onsubmit = function(event) {
//	  	event.preventDefault();
//	  	console.log('I am in the xhr func');
//
//	  	// Update button text.
//	  	uploadButton.innerHTML = 'Uploading...';
//
//	  	// The rest of the code will go here...
//	  	// Get the selected files from the input.
//	  	var files = fileSelect.files;
//	  
//		var xhr = new XMLHttpRequest();
//		var stringPath;
//		var key = Math.floor((Math.random() * 1000000) + 1)+1+"";
//		
//		
////		var bucket = new AWS.S3({params: {Bucket: 'project2bucketforrevatureportfoliostuff'}});
//		var fileChooser = document.getElementById('file-select');
//		var file = fileChooser.files[0];
//		getBase64(file);
//		if (file) {
////			var params = {Key: ''+key, ContentType: file.type, Body: file};
////			bucket.upload(params).on('httpUploadProgress', function(evt) {
////				console.log("Uploaded :: " + parseInt((evt.loaded * 100) / evt.total)+'%');
////			}).send(function(err, data) {
////				
////			});
////			stringPath = "https://s3.us-east-2.amazonaws.com/project2bucketforrevatureportfoliostuff/"+key;
//			console.log(files[0]);
//			console.log(stringPath);
//			var tx = [stringPath];
//			tx = JSON.stringify(tx);
//			xhr.onreadystatechange = function() {
//				if(xhr.readyState == 4 && xhr.status == 200) {
//					document.getElementById('IMG').src = xhr.responseText;
//				}
//			};
//			xhr.open('POST', 'UploadImage', true);
//			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//			xhr.send(tx);
//		}
//	};