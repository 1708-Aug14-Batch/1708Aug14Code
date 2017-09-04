/**
 * JS HOMEWORK Trevor Lory
 * 
 * -----------------------------------------------------------------------------------
 * PART I Create a single Javascript file called homework.js to answer these
 * questions. Please put the question itself as a comment above each answer.
 * -----------------------------------------------------------------------------------
 */

// 1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.
function fib(n) {
	if (n <= 1)
		return n;
	else
		return (fib(n - 1) + fib(n - 2));
}

function runFib() {
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray) {
	var notSorted = true;
	while(notSorted) {
		notSorted = false;
		for(var i = 0; i < numArray.length - 1; i++) {
			if(numArray[i] > numArray[i + 1]) {
				notSorted = true;
				var temp = numArray[i];
				numArray[i] = numArray[i + 1];
				numArray[i + 1] = temp;
			}
		}
	}
	return numArray;
}

function runBub() {
	var numArray = [ 1, 10, 9, 6, 7, 8, 5, 4, 2, 3];
	numArray = bubbleSort(numArray);
	console.log(numArray);
}

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr) {
	return someStr.split("").reverse().join("");
}

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
	if(someNum <= 1) return someNum;
	else return factorial(someNum - 1) * someNum;
}

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substr(someStr, length, offset) {
	if(typeof length === "number") {
		if(typeof offset === "number") {
			if(typeof someStr === "string") {
				return someStr.substring(offset, length + offset);
			}
			else {
				window.alert("Value someStr was not a string");
			}
		}
		else {
			window.alert("Value Offset was not a number");
		}
	}
	else {
		window.alert("Value Length was not a number");
	}
}

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum) {
	if(someNum / 2 == Math.floor(someNum / 2)) {
		return true;
	}
	return false;
}

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function Palindrome(someStr) {
	if(someStr == reverseStr(someStr)) {
		return true;
	}
	return false;
}

//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *
function printShape(shape, height, character) {
	var str = "";
	if(shape == "Square") {
		for(var i = 0; i < height; i++) {
			for(var e = 0; e < height; e++) {
				str = str.concat(character);
			}
			str = str.concat("\n");
		}
		console.log(str);
	}
	else if(shape == "Triangle") {
		for(var i = 0; i < height; i++) {
			for(var e = 0; e < i + 1; e++) {
				str = str.concat(character);
			}
			str = str.concat("\n");
		}
		console.log(str);
	}
	else if(shape == "Diamond") {
		for(var i = 1; i < height; i += 2) {
			for (var j = 0; j < height - 1 - i / 2; j++)//Output correct number of spaces before
		    {
		        str = str.concat(" ");
		    }
		    for (var j = 0; j < i; j++)//Output correct number of asterix
		    {
		        str = str.concat(character);
		    }

		    str = str.concat("\n");//Skip to next line
		}
		for(var e = height; e > 0; e -= 2) {
			for (var j = 0; j < height -1 - e / 2; j++)
		    {
				str = str.concat(" ");
		    }

		    for (var j = 0; j < e; j++)
		    {
		    	str = str.concat(character);
		    }

		    str = str.concat("\n");
		}
		console.log(str);
	}
}

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj) {
	var vals = Object.values(someObj);
	for(var i = 0; i < vals.length; i++) {
		console.log(vals[i]);
	}
}

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
function deleteElement(someArr) {
	console.log(someArr.length);
	delete someArr[2];
	console.log(someArr.length);
}

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function spliceElement(someArr) {
	console.log(someArr.length);
	someArr.splice(3, 1);
	console.log(someArr.length);
}

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//    var john = new Person("John", 30);
function Person(name, age) {
	var john = { "Name" : name, "Age" : age};
	console.log(john);
}

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//    var john = getPerson("John", 30);
function getPerson(name, age) {
	return {"name" : name, "Age" : age};
}















