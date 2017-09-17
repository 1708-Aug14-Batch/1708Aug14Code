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
	    					reqs[i].id,
	    					reqs[i].employee,
	    					reqs[i].description,
	    					reqs[i].amount,
	    					reqs[i].submit_date,
	    				]).draw(false);
	    			}
	    		},
	    	"json");
	});
	
	$(document).ready(function() {
	    var table = $('#pendingdata').DataTable();
	     
	    $('#pendingdata tbody').on('click', 'tr', function () {
	        var data = table.row(this).data();
	        localStorage.setItem("dtUser", data[0]);
	        window.location = "emp_requests.html";
	    });
	});

	$(document).ready(function() {
	    $.post("mgrAllResolvedReqs",
	    		{},
	    		function(reqs) {
	    			let dataz = $('#resolveddata').DataTable();
	    			console.log(reqs);
	    			for(let i = 0; i < reqs.length; i++){
	    				dataz.row.add([
	    					reqs[i].id,
	    					reqs[i].employee,
	    					reqs[i].description,
	    					reqs[i].amount,
	    					reqs[i].submit_date,
	    					reqs[i].resolved_date,
	    					reqs[i].manager,
	    					reqs[i].resolution,
	    					reqs[i].status,
	    				]).draw(false);
	    			}
	    		},
	    	"json");
	});
	
	$(document).ready(function() {
	    var table = $('#resolveddata').DataTable();
	     
	    $('#resolveddata tbody').on('click', 'tr', function () {
	        var data = table.row(this).data();
	        localStorage.setItem("dtUser", data[0]);
	        window.location = "emp_requests.html";
	    });
	});

}

function getLoginInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = xhr.responseText;
			console.log(user);
			document.getElementById("uname").innerHTML = user;
		}
	}
	xhr.open('Get', "homePage", true);
	xhr.send();
}

