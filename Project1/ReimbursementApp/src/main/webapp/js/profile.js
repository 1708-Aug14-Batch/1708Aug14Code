/**
 * 
 */
var user_info;
function getInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			showNameAndAccounts(this);
		}
	}
	
	//HTTP method, servlet-mapping name, use Asynchronous? (always true)
	xhr.open("POST", "homepage", true);
	xhr.send(null);
}

function showNameAndAccounts(json) {
	  var response = json.responseText;
	  user_info = JSON.parse(response);
	  
	  if(user_info.user.isManager == 0){
		  document.getElementById("reimburseButton").style.display = 'block';
	  }
	  
	  document.getElementById("name").innerHTML = user_info.user.firstname + " " +user_info.user.lastname;
	  document.getElementById("username").innerHTML = user_info.user.username;
	  document.getElementById("email").innerHTML = user_info.user.email;
	  document.getElementById("userid").innerHTML = user_info.user.userId;
	  document.getElementById("numReim").innerHTML = user_info.reimbursements.length;
	  document.getElementById("inputfn").value = user_info.user.firstname;
	  document.getElementById("inputln").value = user_info.user.lastname;
	  document.getElementById("inputemail").value = user_info.user.email;
	  document.getElementById("inputpass1").value = '';
	  document.getElementById("inputpass2").value = '';
	  document.getElementById("inputpass").value = '';
	  document.getElementById("inputun").value = '';
}

function updateInfo(){
	$('#exampleModal').modal('hide');
	var details = $('#profile_form').serialize();
	var success = '<div class="alert alert-success">Successfully updated!</div>';
	
	$('#showSuccessAlert').html(success).hide().fadeIn(750);
	$.post('edit_profile', details, getInfo);
}

window.onload = function(){
	getInfo();
	
	//set on submit for modal
	$('#profile_form').submit(function(e){
		  e.preventDefault();
		  
		  if($('#inputpass1').val() != $('#inputpass2').val()){
			  document.getElementById("showAlert").innerHTML = '<div class="alert alert-danger">New passwords do not match.</div>';
		  }
		  else if($('#inputpass1').val() == $('#inputpass2').val()){
			  var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4 && xhr.status == 200){
						var response = this.responseText;
						
						
						if(response == 'username'){
							document.getElementById("showAlert").innerHTML = '<div class="alert alert-danger">Incorrect User, try again.</div>';
						}
						else if(response == 'password'){
							document.getElementById("showAlert").innerHTML = '<div class="alert alert-danger">Incorrect Credentials, try again.</div>';
						}
						else{
							//correct credentials, send info to update 
							if($('#inputpass1').val().length == 0){
								$('#inputpass1').val(user_info.user.pwd);
							}
							updateInfo();
						}
					}
				}
				xhr.open("POST", "login", true);
				xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				var post = "username="+document.getElementById("inputun").value+"&password="+ document.getElementById("inputpass").value;
				xhr.send(post);
			  
		  }
		  
	  })
}