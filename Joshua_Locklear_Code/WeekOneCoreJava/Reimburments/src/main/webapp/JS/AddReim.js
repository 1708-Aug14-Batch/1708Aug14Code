/**
 * 
 */
log('');

$(document).ready(function(){
	log('document ready');
	document.getElementById("submitRequest").addEventListener("click",submitRe)
});

function submitRe(){
	'use strict';
	log('in submitRe');
	var xhr = new XMLHttpRequest();
	
	var email = document.getElementById("email").value.trim();
	console.log(email);
	var password = document.getElementById("password").value;
	console.log(password);
	var reason = document.getElementById("reason").value.trim();
	console.log(reason);
	var amount = document.getElementById("amount").value;
	console.log(amount);
	
	var tx = [email,password,reason,amount];
	
	tx = JSON.stringify(tx);
	
	xhr.open("POST","AddRei",true);
	xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			log('submit request response');
		}
	};
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(tx);
	document.getElementById("upper").reset();
}

function log(message) {
	console.log('AddReim.js -- '+message);
}
