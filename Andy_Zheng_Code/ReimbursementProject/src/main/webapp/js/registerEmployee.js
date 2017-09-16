function loadRegisterEmployee(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#register').click(function(){
				registerEmployee();
				$('#registerModal').appendTo("body").modal('show');
			});
		}
	}
	xhr.open("GET", "loadRegisterEmployee", true);
	xhr.send();
}

function registerEmployee(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
 	var email = $('#email').val();
 	var password = $('#password').val();

 	var to = [fn,ln,email,password];

 	to = JSON.stringify(to);

	$.ajax({
		type: 'POST',
		url: 'registerEmployee',
		data: to,
		dataType: 'JSON',
		success: function(response){
			if(response == "Employee Registered"){
				$('#registerStatus').text("Employee Registered");
				$('body').one("click", loadRegisterEmployee);
			}else if(response == "Failed Registration"){
				$('#registerStatus').text("Failed Registration");
				$('body').one("click", loadRegisterEmployee);
			}
		}
	})
}
