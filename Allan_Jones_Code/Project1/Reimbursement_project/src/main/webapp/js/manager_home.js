window.onload = function() {
	getLoginInfo();
	$(document).ready(function() {
	    $.post("mgrAllPendingReqs",
	    		{},
	    		function(reqs) {
	    			let dataz = $('#pendingdata').DataTable();
	    			console.log(reqs);
	    			for(let i = 0; i < reqs.length; i++){
	    				dataz.row.add([
	    					reqs[i].employee,
	    					reqs[i].description,
	    					reqs[i].amount,
	    					reqs[i].submit_date,
	    				]).draw(false);
	    			}
	    		},
	    	"json");
	});
}

function getLoginInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200)  {
			var user = xhr.responseText;
			console.log(user);
			document.getElementById("uname").innerHTML = user;
		}
	}
	xhr.open('Get', "homePage", true);
	xhr.send();
}
