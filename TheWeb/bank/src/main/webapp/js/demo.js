


var logged = false;

window.onload = function(){

	
	
	if(logged == false){
		$("#navbar").hide();
	}
	
	loadHomeView();

	document.getElementById("homePage")
	.addEventListener("click", loadDashboardView);

	document.getElementById("accPage")
	.addEventListener("click", loadAccountPageView);


};

//Views





function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;		
			document.getElementById("login")
			.addEventListener("click", login);
		}
	}
	console.log("getting homepage")
	xhr.open("GET", "getLoginView", true);
	xhr.send();
}



function login(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("pass").value;
	var tx = [email, pass];

	tx = JSON.stringify(tx);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){

		if(xhr.readyState == 4 && xhr.status == 200){
			var response =  xhr.responseText;
			console.log(response);
			if (response == "success"){
				logged = true;
				successfulLog();
			}
			else{
				document.getElementById("message")
				.innerHTML = response;}
		}

	}

	xhr.open("POST", "login", true);

	//set the header to tell the server you have data for it to process
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
};

function successfulLog(){
	
}


function loadDashboardView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getUserPageInfo(); // loads user info by calling function
		
		}
	}
	console.log("getting dash")
	xhr.open("GET", "getDashboard", true);
	xhr.send();
}







function loadAccountPageView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getAcctPageInfo(); // loads user info by calling function
			
		}
	}
	console.log("getting accts")
	xhr.open("GET", "getAccPage", true);
	xhr.send();
}

function getAcctPageInfo(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;


			if (accounts.length == 0){
				document.getElementById("accounts").style.visibility = "hidden"; 

			}
			else{

				for(var i = 0; i < accounts.length; i++){
					// populate accounts table
					var table = document.getElementById("accTable");
					var row = table.insertRow();
					var acc = row.insertCell(0);
					var type = row.insertCell(1);
					var bal = row.insertCell(2);
					acc.innerHTML = "Account No. " + accounts[i].id;
					type.innerHTML = accounts[i].type;
					bal.innerHTML = "$" + accounts[i].balance;
				}
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	
}




function getUserPageInfo(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			document.getElementById('name')
			.innerHTML = user.firstname + " " + user.lastname;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	
}









function addAccount(){ // allows us to acc new accounts 
	var accType = document.getElementById("accType").value;
	console.log(accType);

	var type = JSON.stringify(accType);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);

		}
	}

	xhr.open("POST", "addAccount", true);
	//set the header to tell the server you have data for it to process
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//research this !!!
	xhr.send(input); //include your post data in the send()

}
