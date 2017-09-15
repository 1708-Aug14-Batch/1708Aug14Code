/**
 * 
 */
$(document).ready(function(){
	document.getElementById("button").addEventListener("click",submitRe)
});

function submitRe(){
	var xhr = new XMLHttpRequest();
	
	var email = document.getElementById("email").value;
	console.log(email);
	var password = document.getElementById("password").value;
	console.log(password);
	var reason = document.getElementById("reason").value;
	console.log(reason);
	var amount = document.getElementById("amount").value;
	console.log(amount);
	
	var tx =[email,password,reason,amount];
	
	tx.JSON.stringify(tx);
	
	xhr.open("POST","AddRei",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(tx);
}