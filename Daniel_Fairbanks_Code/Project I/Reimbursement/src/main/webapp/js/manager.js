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
			for (var r in requests) {
				$("#requests").append("<tr>");
				if (requests[r].status == 1){
					$("#requests").append("<th><button type=\"button\" class=\"accept\">&#x2713</button>" +
										  "<button type=\"button\" class=\"deny\">&#x2717</button></th>");
				}
				else
					$("#requests").append("<th>RESOLVED</th>");
				if (requests[r].status == 1)
					$("#requests").append("<th class=\"pending\">"+requests[r].statusName+"</th>");
				else if (requests[r].status == 2)
					$("#requests").append("<th class=\"accepted\">"+requests[r].statusName+"</th>");
				else
					$("#requests").append("<th class=\"denied\">"+requests[r].statusName+"</th>");
				$("#requests").append("<th>$"+(requests[r].amount).toFixed(2)+"</th>");
				$("#requests").append("<th>"+(new Date(requests[r].submit_date)).toLocaleString()+"</th>");
				$("#requests").append("<th>"+requests[r].submitter.firstname+" "+requests[r].submitter.lastname+"</th>");
				if (requests[r].status == 1){
					$("#requests").append("<th>-</th>");
					$("#requests").append("<th>-</th>");
				}
				else{
					$("#requests").append("<th>"+(new Date(requests[r].resolve_date)).toLocaleString()+"</th>");
					$("#requests").append("<th>"+requests[r].resolver.firstname+" "+requests[r].resolver.lastname+"</th>");
				}
				$("#requests").append("<th>Details</th>");
				$("#requests").append("</tr>");
			}
		}
	}
	xhr.open("POST", "manager_home", true);
	xhr.send();
})