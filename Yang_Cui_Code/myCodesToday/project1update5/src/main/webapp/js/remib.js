var logged = false;
var current="nobody";
/*$( document ).ready(function(){
	loadHomeView();
	if(logged == false){
		$("#navbar").hide();
	}
	else{
		$("#navbar").show();
		setUpPage();
	}

});
function setUpPage(){
	document.getElementById("homePage").addEventListener("click", loadEmployeeView);
	document.getElementById("myInfo").addEventListener("click", loadEmployeeInfoView);
	document.getElementById("myReq").addEventListener("click", loadReimbursmentView);
	
	if(current=="employee"){
		console.log("I am employee");
		$("#userInfo").remove();
		$("#resolve").remove();
	}else if(current=="mananger"){
		console.log("I am mananger");
		document.getElementById("userInfo").addEventListener("click", loadUserListView);
		document.getElementById("resolve").addEventListener("click", loadResolveiew);
	}else{
		console.log("I am nobody");
	}
};*/



window.onload = function(){

	loadHomeView();
	
	if(logged == false){
		$("#navbar").hide();
	}
	else{
		if(current=="employee"){
			console.log("I am employee");
			$("#navbar").show();
		}else if(current=="mananger"){
			console.log("I am mananger");
			$("#navbar").show();
		}else{
			console.log("I am nobody");
			$("#navbar").hide();
		}


	}
	console.log($("#myReq"));
	document.getElementById("homePage").addEventListener("click", loadEmployeeView);
	document.getElementById("myInfo").addEventListener("click", loadEmployeeInfoView);
	document.getElementById("myReq").addEventListener("click", loadReimbursmentView);
	document.getElementById("userInfo").addEventListener("click", loadUserListView);
	document.getElementById("resolve").addEventListener("click", loadResolveiew);
};


/*
window.onload = function(){
	loadHomeView();
	if(logged == false){
		$("#navbar").hide();
	}
	else{
		$("#navbar").show();
		setUpPage();
	}
};

function setUpPage(){
	document.getElementById("homePage").addEventListener("click", loadEmployeeView);
	document.getElementById("myInfo").addEventListener("click", loadEmployeeInfoView);
	document.getElementById("myReq").addEventListener("click", loadReimbursmentView);
	
	if(current=="employee"){
		console.log("I am employee");
		$("#userInfo").remove();
		$("#resolve").remove();
	}else if(current=="mananger"){
		console.log("I am mananger");
		document.getElementById("userInfo").addEventListener("click", loadUserListView);
		document.getElementById("resolve").addEventListener("click", loadResolveiew);
	}else{
		console.log("I am nobody");
	}
};
*/

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;
			console.log($("#login"));
			document.getElementById("login").addEventListener("click", login);
		}
	}
	console.log("getting homepage")
	xhr.open("GET", "getLoginView", true);
	xhr.send();
};


function login(){
	var uname = document.getElementById("uname").value;
	var pass = document.getElementById("pass").value;
	var tx = [uname, pass];
	tx = JSON.stringify(tx);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("got login response");
			var response =  xhr.responseText;
			var user = JSON.parse(xhr.responseText);
			console.log(user.firstName);
			console.log(user.lastName);
			console.log(user.isMananger);

			if (response == "fail"){
				document.getElementById("message").innerHTML = "Invalid credentials. Please try again";
				console.log("login fial");
			}
			else if(response == "pass"){
				document.getElementById("message").innerHTML = "Invalid user. Please try again";
				console.log("login fial");
			}
			else{
				 if(user.isMananger==true){
					logged = true;
					current="mananger";
					console.log(response);
					loadEmployeeView();
					$("#navbar").show();
				}else{
					logged = true;
					current="employee";
					console.log(response);
					loadEmployeeView();
					$("#navbar").show();
				}
			}
		}
	}

	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(tx);
};

function loadEmployeeView(){
	console.log("in load dashboard employee view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getEmployeeName(); // loads user info by calling function

		}
	}
	console.log("getting dash");
	xhr.open("GET", "getDashboard", true);
	xhr.send();
};

function loadEmployeeInfoView(){
	console.log("in load dashboard view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
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
			document.getElementById('view').innerHTML = xhr.responseText;
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
			//console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var reimbs = dto.rv;

		if(user.isMananger==true){
			for(var i = 0; i < reimbs.length; i++){
				//console.log(reimbs[i].sender.charAt(reimbs[i].sender.length-1));
				//console.log(user.id);
				//console.log(reimbs[i].sender.charAt(reimbs[i].sender.length-1)==user.id);
				if(reimbs[i].sender.charAt(reimbs[i].sender.length-1)==user.id){
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
		}else{

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
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}


function getEmployeeName(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			document.getElementById('employee').innerHTML = user.firstName + " " + user.lastName + " " +user.isMananger;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();

};

function getEmployeeInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			//console.log(user);
			document.getElementById('userid').innerHTML = user.id;
			//console.log(user.firstName);
			//console.log($("#firstname"));
			//console.log($('p.fuckoff'));
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

function loadUserListView(){
	console.log("in load dashboard view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			//console.log($('#userInfo'));
			getUserListInfo(); // loads user info by calling function

		}
	}
	console.log("getting dash");
	xhr.open("GET", "GetEveryOneInfo", true);
	xhr.send();
}

function getUserListInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var listUser=dto.all;
			
			for(var i = 0; i < listUser.length; i++){
				var table = document.getElementById("userList");
				var row = table.insertRow();
				var userID =row.insertCell(0);
				var uname = row.insertCell(1);
				var fname = row.insertCell(2);
				var lname = row.insertCell(3);
				var email = row.insertCell(4);
				var mananger = row.insertCell(5);
				userID.innerHTML=listUser[i].userID;
				uname.innerHTML=listUser[i].userName;
				fname.innerHTML=listUser[i].firstName;
				lname.innerHTML=listUser[i].lastName;
				email.innerHTML=listUser[i].email;
				mananger.innerHTML=listUser[i].isMananger;
			}
		}
	}
	xhr.open("GET", "getAllUserInfo", true);
	xhr.send();
}

function loadResolveiew(){
	console.log("in load dashboard view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById("approve").addEventListener("click", approveRemib);
			document.getElementById("reject").addEventListener("click", rejectRemib);
			//console.log($('#resolve'));
			getReimbListInfo(); // loads user info by calling function

		}
	}
	console.log("getting dash");
	xhr.open("GET", "GetReimbList", true);
	xhr.send();
}

function getReimbListInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var reimbs = dto.rv;
			for(var i = 0; i < reimbs.length; i++){
				// populate accounts table
				var table = document.getElementById("reqList");
				var row = table.insertRow();
				var reimbID = row.insertCell(0);
				var resolve = row.insertCell(1);
				var sumbitDate = row.insertCell(2);
				var resolveDate = row.insertCell(3);
				var amount = row.insertCell(4);
				var status = row.insertCell(5);
				var discrib = row.insertCell(6);
				var note = row.insertCell(7);
				var check= row.insertCell(8);
				var checkbox = document.createElement('input');
				checkbox.type = "checkbox";
				checkbox.name = "name";
				checkbox.value = "value";
				checkbox.id = String(i);
				reimbID.innerHTML = reimbs[i].remibID;
				resolve.innerHTML = reimbs[i].resolver;
				sumbitDate.innerHTML = reimbs[i].sumbitDate;
				resolveDate.innerHTML = reimbs[i].resolveDate;
				amount.innerHTML = reimbs[i].amount;
				status.innerHTML = reimbs[i].stat;
				discrib.innerHTML = reimbs[i].description;
				note.innerHTML = reimbs[i].note;
				check.appendChild(checkbox);
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}


function approveRemib(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var reimbs = dto.rv;
			for(var i=0; i<reimbs.length; i++){
				if(document.getElementById(String(i)).checked){
					console.log(document.getElementById(String(i)).checked);
					var resolve =[i, user.id, "is approved", 1];
					resolveRemib(resolve);
				}
			}
			loadResolveiew();
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

function rejectRemib(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			for(var i=0; i<dto.reimbs.length; i++){
				console.log(document.getElementById(String(i)).checked);
				if(document.getElementById(String(i)).checked){
					var resolve =[i, user.id, "is rejected", 2];
					resolveRemib(resolve);
				}
			}
			loadResolveiew();
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

function resolveRemib(resolve){
	var dicition=JSON.stringify(resolve);
	console.log(dicition);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			//loadResolveiew();
		}
	}
	//console.log("getting dash");
	xhr.open("POST", "resolve", true);
	xhr.send(dicition);
}
