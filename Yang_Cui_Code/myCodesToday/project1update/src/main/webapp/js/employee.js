window.onload = function(){

	getEmployeeName();
	loadEmployeeInfoView();
	document.getElementById("myInfo").addEventListener("click", loadEmployeeInfoView);
	document.getElementById("myReq").addEventListener("click", loadReimbursmentView);
};

function loadEmployeeInfoView(){
	console.log("in load dashboard view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("employeeview").innerHTML = xhr.responseText;
			console.log($('#empInfo'));
			getEmployeeInfo(); // loads user info by calling function

		}
	}
	console.log("getting dash");
	xhr.open("GET", "GetEmployeeInfo", true);
	xhr.send();
}




function loadReimbursmentView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('employeeview').innerHTML = xhr.responseText;
			document.getElementById("sendRemib").addEventListener("click", sendNewRemib);
			getReimbRageInfo(); // loads user info by calling function
			//addRemib();
			
		}
	}
	console.log("getting accts")
	xhr.open("GET", "GetEmployeeReimb", true);
	xhr.send();
}

function getReimbRageInfo(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var reimbs = dto.rv;


			for(var i = 0; i < reimbs.length; i++){
				// populate accounts table
				var table = document.getElementById("reqListEmployee");
				var row = table.insertRow();
				var reimbID = row.insertCell(0);
				var resolve = row.insertCell(1);
				var sumbitDate = row.insertCell(2);
				var resolveDate = row.insertCell(3);
				var amount = row.insertCell(4);
				var status = row.insertCell(5);
				var discrib = row.insertCell(6);
				var note = row.insertCell(7);
				reimbID.innerHTML = reimbs[i].remibID;
				resolve.innerHTML = reimbs[i].resolver;
				sumbitDate.innerHTML = reimbs[i].sumbitDate;
				resolveDate.innerHTML = reimbs[i].resolveDate;
				amount.innerHTML = reimbs[i].amount;
				status.innerHTML = reimbs[i].stat;
				discrib.innerHTML = reimbs[i].description;
				note.innerHTML = reimbs[i].note;		
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	
}


function getEmployeeName(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			document.getElementById("welcome").innerHTML = user.firstName + " " + user.lastName;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();

};

function getEmployeeInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			console.log(user);
			document.getElementById('userid').innerHTML = user.id;
			console.log(user.firstName);
			console.log($("#firstname"));
			console.log($('p.fuckoff'));
			//$('#firstname').text(user.firstName);
			document.getElementById("firstname").innerHTML =user.firstName;
			document.getElementById('lastname').innerHTML =user.lastName;
			document.getElementById('username').innerHTML =user.userName;
			document.getElementById('email').innerHTML =user.email;
			document.getElementById('pass').innerHTML =user.password;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

function sendNewRemib(){
	var reason=document.getElementById("reason").value;
	var amount=document.getElementById("amount").value;
	
	console.log(reason);
	console.log(amount);
	
	var remibInput=[reason, amount];
	var remibSend=JSON.stringify(remibInput);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			loadReimbursmentView();
		}
	}

	xhr.open("POST", "newRemib", true);
	//set the header to tell the server you have data for it to process
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//research this !!!
	xhr.send(remibSend); //include your post data in the send()
	//loadReimbursmentView();
}
