$(document).ready(function() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var requests = dto.requests;
			
			var hr = (new Date()).getHours();
			if (hr >= 5 && hr < 12)
				document.getElementById('welcome').innerHTML = "Good morning, "+ user.firstname + " " + user.lastname;
			else if (hr >= 12 && hr < 18)
				document.getElementById('welcome').innerHTML = "Good afternoon, "+ user.firstname + " " + user.lastname;
			else
				document.getElementById('welcome').innerHTML = "Good evening, "+ user.firstname + " " + user.lastname;
			
			var table = document.getElementById("requests");
			for (var r in requests) {
				var row = table.insertRow(r);
				row.id = requests[r].id;
				console.log(row.id);
				var resolve = row.insertCell(0);
				var status = row.insertCell(1);
				var amount = row.insertCell(2);
				var submit_date = row.insertCell(3);
				var submit_by = row.insertCell(4);
				var resolve_date = row.insertCell(5);
				var resolve_by = row.insertCell(6);
				var details = row.insertCell(7);
				if (requests[r].status == 1) {
					resolve.innerHTML = "<button type=\"button\" class=\"accept btn\"><b>&#x2713</b></button>" +
				  						"<button type=\"button\" class=\"deny btn\"><b>&#x2717</b></button>";
					status.className = status.style.color = "gray";
					resolve_date.innerHTML = "-";
					resolve_by.innerHTML = "-";
				}
				else if (requests[r].status == 2) {
					resolve.innerHTML = "<button type=\"button\" class=\"btn btn-secondary\" data-container=\"body\" " +
										"data-toggle=\"popover\" data-placement=\"right\" data-content=\""+requests[r].resolve_notes+"\">Reason</button>";
					status.className = status.style.color = "green";
					status.className = status.style.fontWeight = "bold";
					resolve_date.innerHTML = (new Date(requests[r].resolve_date)).toLocaleString();
					resolve_by.innerHTML = requests[r].resolver.firstname+" "+requests[r].resolver.lastname;
				}
				else {
					resolve.innerHTML = "<button type=\"button\" class=\"btn btn-secondary\" data-container=\"body\" " +
										"data-toggle=\"popover\" data-placement=\"right\" data-content=\""+requests[r].resolve_notes+"\">Reason</button>";
					status.className = status.style.color = "red";
					status.className = status.style.fontWeight = "bold";
					resolve_date.innerHTML = (new Date(requests[r].resolve_date)).toLocaleString();
					resolve_by.innerHTML = requests[r].resolver.firstname+" "+requests[r].resolver.lastname;
				}
				status.innerHTML = requests[r].statusName;
				amount.innerHTML = "<i>$"+(requests[r].amount).toFixed(2)+"</i>";
				submit_date.innerHTML = (new Date(requests[r].submit_date)).toLocaleString();
				submit_by.innerHTML = requests[r].submitter.firstname+" "+requests[r].submitter.lastname;
				details.innerHTML = "<button type=\"button\" class=\"btn btn-secondary\" data-container=\"body\" " +
									"data-toggle=\"popover\" data-placement=\"left\" data-content=\""+requests[r].description+"\">Info</button>";
			}
			$('[data-toggle="tooltip"]').tooltip();
			$('[data-toggle="popover"]').popover();
			
			$('.deny').click(function(){
		    	var id = $(this).parent().parent().attr('id');
		    	console.log(id);
		    	$('#resolveModalLabel').html("Deny Reimbursement Request");
		    	//$('#resolveBtn').html("Deny");
		    	$('button[name=approve]').hide();
		    	$('button[name=deny]').show();
		    	$('#resolveRequest').modal('show');
		    	$('#denyBtn').click(function(){
		    		console.log("Hello, "+id);
		    		var description = $('#description').val();
		    		var transaction = [id, "3", description];
		    		transaction = JSON.stringify(transaction);
		    		$('#description').val("");
		    		$('#resolveRequest').modal('hide');
		
			    	
			    	var xhr = new XMLHttpRequest();
			    	xhr.onreadystatechange = function(){
			    		if(xhr.readyState == 4 && xhr.status == 200){   			
			    			window.location.href = "manager.html";
			    		}
			    	};
			    	
			    	xhr.open("POST", "resolveRequest", true);
			    	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			    	xhr.send(transaction);
		    	});
		    });
			$('.accept').click(function(){
		    	var id = $(this).parent().parent().attr('id');
		    	console.log(id);
		    	$('#resolveModalLabel').html("Approve Reimbursement Request");
		    	$('button[name=deny]').hide();
		    	$('button[name=approve]').show();
		    	$('#resolveRequest').modal('show');
		    	
		    	$('#approveBtn').click(function(){
		    		console.log("Hello, "+id);
		    		var description = $('#description').val();
		    		var transaction = [id, "2", description];
		    		transaction = JSON.stringify(transaction);
		    		$('#description').val("");
		    		$('#resolveRequest').modal('hide');
		    		
			    	
			    	var xhr = new XMLHttpRequest();
			    	xhr.onreadystatechange = function(){
			    		if(xhr.readyState == 4 && xhr.status == 200){
			    			window.location.href = "manager.html";
			    		}
			    	};
			    	
			    	xhr.open("POST", "resolveRequest", true);
			    	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			    	xhr.send(transaction);
		    	}); 
		    });
		}
	}
	xhr.open("POST", "manager_home", true);
	xhr.send();
});
