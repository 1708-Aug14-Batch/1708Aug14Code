/**
 * 
 */

function fib(n){
	if(n<=1) return n;
	else return fib(n-1)+fib(n-2);
}

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click",runFib);
document.getElementById("inner").addEventListener("click",
		function(){alert("inner!")});
document.getElementById("middle").addEventListener("click",
		function(){alert("middle!")});
document.getElementById("outer").addEventListener("click",
		function(){alert("outer!")});
