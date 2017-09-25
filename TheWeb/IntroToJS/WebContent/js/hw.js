/*
JS HOMEWORK
GENESIS BONDS


-----------------------------------------------------------------------------------
PART I - 
Create a single JavaScript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
 */

//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
function fib(n){
	//console.log(n);
	if(n <= 1) return n;

	else return (fib(n-1) + fib(n-2));
}

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("inner").addEventListener("click", 
		function(){alert("inner!")}, true);

document.getElementById("middle").addEventListener("click", 
		function(){alert("middle")}, true);

document.getElementById("outer").addEventListener("click", 
		function(){alert("outer")}, true);


