/**
JS HOMEWORK
ANDY ZHENG
*/

// part 1

function fib(n) {
	if(n<=1) return n;
	else return(fib(n-1) + fib(n-2));
}

function runFib(){
	document.getElementById("fibout").innerHTML = fib(document.getElementById("fibin").value)
}

var tacos = document.getElementById("fibButton");
if(tacos){
document.getElementById("fibButton").addEventListener("click", runFib);
}


document.getElementById("inner").addEventListener("click",
	function(){alert("inner!")});

document.getElementById("middle").addEventListener("click",
	function(){alert("middle!")});

document.getElementById("outer").addEventListener("click",
	function(){alert("outer!")}, true);

