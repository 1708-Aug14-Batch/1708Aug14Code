$(document).ready(function(){
	document.getElementById("submit").addEventListener("click", submit)
});



function submit(){
	
	var descript = document.getElementById("description").value;
	var amount = document.getElementById("amount").value;
	var file = document.getElementById("file").value;
	
	var filetho = file.replace("C:\\fakepath\\", "C:\\Users\\Matt\\Pictures\\");
	
	var tx = [descript,amount,filetho];
	
	
	tx = JSON.stringify(tx);
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "SubmitReimbursement", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	
	
}