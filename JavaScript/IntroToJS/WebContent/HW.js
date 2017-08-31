/**
 * JS Homework
 * Connor Monson
 */

///////////////////////////////////////////////////////////////////////////////
//
// NOTE: The homework assignment is in the root JavaScript directory and is
// 		 named: "JavaScript HW.html"
//
// This file is for reference only
///////////////////////////////////////////////////////////////////////////////

/*
 * 1. Fibonacci
 * Define function: fib(n) 
 * Return the nth number in the fibonacci sequence.
 */
function fib(n) {
    console.log(n);
	if (n <= 1) return n;
    else return (fib(n-1) + fib(n-2));
}

function runFib() {
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);
document.getElementById("inner").addEventListener("click", function(){alert("inner div!")});
document.getElementById("middle").addEventListener("click", function(){alert("middle div!")});
document.getElementById("outer").addEventListener("click", function(){alert("outer div!")});

/*
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
*/
