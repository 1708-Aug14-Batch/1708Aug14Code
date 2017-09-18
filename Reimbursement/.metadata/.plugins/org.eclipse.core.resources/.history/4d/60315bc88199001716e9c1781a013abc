/**
 * 
 */
var logged = false;
window.onload = function(){
	console.log("isworkinh");
	loadHomeView();

	if(logged == false){
		$("#navbar").hide();	
	}
	else{
		$("#navbar").show();
	};
	document.getElementById("homePage").addEventListener("click", loadDashboardView);

	document.getElementById("reimbursePage").addEventListener("click", loadReimbursePageView);

};

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			document.getElementById("login").addEventListener("click", login);

		}
	}
	xhr.open("GET", "getLoginView", true);
	xhr.send();
};


function login(){
	var email = document.getElementById("email").value;
	var pwd = document.getElementById("pwd").value;
	var tx = [email, pwd];
	tx = JSON.stringify(tx);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response = xhr.responseText;
			console.log("inside of login request");
			if(response == "fail"){
				document.getElementById("message").innerHTML = "Invalid credentials. Try again";
			}
			else if (response == "pass"){
				document.getElementById("message").innerHTML = "invalid user, try agin";
			}
			else{
				login = true;
				console.log(response);
				loadDashboardView();
				$('#navbar').show();
			}
		}
	}
	console.log(tx);
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");
	xhr.send(tx);
};


function loadDashboardView(){
	console.log("in the load dashboard view ");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.staus == 200){
			doocument.getElementById('view').innerHTML = xhr.responseText;
			getUserPageInfo();
		}
	}
	console.log("getting dash");
	xhr.open("GET", "getDashboard", true);
	xhr.send();

};

function loadReimbursePageView(){
	var xhr = new XMLHttpRequest();
	xhr.getonreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			getReimbursementPage();
		}

	}
	console.log("getting reimbursement");
	xhr.open("GET", "getReimbursement", true);
	xhr.sent();
}
