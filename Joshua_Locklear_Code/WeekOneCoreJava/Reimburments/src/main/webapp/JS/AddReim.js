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
	var password = document.getElementById("password").value;
	var reason = document.getElementById("reason").value.trim();
	var amount = document.getElementById("amount").value;
	
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
