function loadSubmitReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('content1').innerHTML = xhr.responseText;
			$('#submit').click(function(){
				submitReim();
				$('#submitModal').appendTo("body").modal('show');
			});
		}
	}
	xhr.open("GET", "loadSubmitReim", true);
	xhr.send();
}

function submitReim(){
	var description = $('#description').val();
	var amount = $('#amount').val();

 	var to = [description,amount];

 	to = JSON.stringify(to);
 	$.ajax({
 		type: 'POST',
 		url: 'submitReim',
 		data: to,
 		dataType: 'JSON',
 		success: function(response){
			if(response == "Reimbursement Submitted"){
				$('#submitStatus').text("Reimbursement Submitted");
				$('body').one("click", loadSubmitReim);
 			}
 		}
	})
}
