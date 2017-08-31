/**
 * JS HOMEWORK
 * ANDREW BONDS



-----------------------------------------------------------------------------------
PART I
Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
 */

/*
 * Problem 1
 */

function fib(n){ 
	if(n <= 1) return n;
	else return (fib(n-1) + fib(n-2));
	}

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fibN").value;
	display.innerHTML = fib(n);
}
  
document.getElementById("doFib").addEventListener("click",runFib);

document.getElementById("inner").addEventListener("click", 
		function(){alert("inner!")});

document.getElementById("middle").addEventListener("click", 
		function(){alert("middle!")});

document.getElementById("outer").addEventListener("click", 
		function(){alert("outer!")});


/*
 * Problem 2
 */


var numArray = (1,0,5,6,3,2,3,7,9,8,4);


//I think this works???????
function bubbleSort(items) {
	  var length = items.length;
	  for (var i = 0; i < length; i++) { 
	    for (var j = 0; j < (length - i - 1); j++) { 
	      if(items[j] > items[j+1]) {
	        var tmp = items[j];  
	        items[j] = items[j+1]; 
	        items[j+1] = tmp; 
	      }
	    }        
	  }
	}
console.log(numArray);

/*
 * Problem 3
 * 
 */

function reverseString(str){

	var value = str;
			for(var i = value.length - 1; i >= 0; i--) { //For loop that initializes i at the end of string and increments backwards
		console.log(value.charAt(i)); //Prints out the character at i, thus reversing it.
	}   
}

/*
 * Problem 4
 */









