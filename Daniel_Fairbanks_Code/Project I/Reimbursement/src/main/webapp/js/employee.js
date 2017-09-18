function onLoad() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
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
				var notes = row.insertCell(0);
				var status = row.insertCell(1);
				var amount = row.insertCell(2);
				var submit_date = row.insertCell(3);
				var resolve_date = row.insertCell(4);
				var resolve_by = row.insertCell(5);
				var details = row.insertCell(6);
				if (requests[r].status == 1) {
					notes.innerHTML = "";
					status.className = status.style.color = "gray";
					resolve_date.innerHTML = "";
					resolve_by.innerHTML = "";
				}
				else if (requests[r].status == 2) {
					notes.innerHTML = "<button type=\"button\" class=\"btn btn-secondary\" data-container=\"body\" " +
										"data-toggle=\"popover\" data-placement=\"right\" data-content=\""+requests[r].resolve_notes+"\">Notes</button>";
					status.className = status.style.color = "green";
					status.className = status.style.fontWeight = "bold";
					resolve_date.innerHTML = (new Date(requests[r].resolve_date)).toLocaleString();
					resolve_by.innerHTML = requests[r].resolver.firstname+" "+requests[r].resolver.lastname;
				}
				else {
					notes.innerHTML = "<button type=\"button\" class=\"btn btn-secondary\" data-container=\"body\" " +
										"data-toggle=\"popover\" data-placement=\"right\" data-content=\""+requests[r].resolve_notes+"\">Notes</button>";
					status.className = status.style.color = "red";
					status.className = status.style.fontWeight = "bold";
					resolve_date.innerHTML = (new Date(requests[r].resolve_date)).toLocaleString();
					resolve_by.innerHTML = requests[r].resolver.firstname+" "+requests[r].resolver.lastname;
				}
				status.innerHTML = requests[r].statusName;
				amount.innerHTML = "<i>$"+(requests[r].amount).toFixed(2)+"</i>";
				submit_date.innerHTML = (new Date(requests[r].submit_date)).toLocaleString();
				details.innerHTML = "<button type=\"button\" class=\"btn btn-secondary\" data-container=\"body\" " +
									"data-toggle=\"popover\" data-placement=\"left\" data-content=\""+requests[r].description+"\">Info</button>";
			}
			$('[data-toggle="tooltip"]').tooltip();
			$('[data-toggle="popover"]').popover();
		}
	}
	xhr.open("GET", "employee_home", true);
	xhr.send();
}