/**
 * JS Homework
 * Lauren Wallace
 */

/*-----------------------------------------------------------------------------------
PART I
Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------*/
/* 1. Fibonacci
 * Define function: fib(n) 
 * Return the nth number in the fibonacci sequence.
 */
function fibonanci(n){
    if(n<=1) return n;
    else return (fibonanci(n-1) + fibonanci(n-2));
}

function runFib() {
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fibonanci(n);
}

document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("inner").addEventListener("click", function(){alert("inner")}, true);
document.getElementById("middle").addEventListener("click", function(){alert("middle")}, true);
document.getElementById("outer").addEventListener("click", function(){alert("outer")}, true);

/* 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */
function swapLeftGreater(array, k, v1, v2) {
    var temp = v2;
    array[k+1] = v1;
    array[k] = temp;
}

function bubbleSort(array) {
    for(var i = 0; i < array.length; i++) {
        for(var k = 0; k < array.length - 1; k++) {
            if(array[k] > array[k+1]) {
                swapLeftGreater(array, k, array[k], array[k+1]);
            }
        }
    }
    return array;
}

/*function printArray(array) {
    for(var j = 0; j < array.length; j++) {
        console.log(array[j] + " ");
    }
}
*/

function runBubSort() {
	var display = document.getElementById("bubbleSortDisplay");
	var arr = [];
	arr = document.getElementById("array").value;
	arr.replace(/ /g, ''); //this replaces all spaces found with nothing 
	arr = arr.split(',').map(Number); //.map(Number) makes it a number array
	display.innerHTML = bubbleSort(arr);
}

document.getElementById("doBubSort").addEventListener("click", runBubSort);

/* 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */

function getReverse(str) {
	var s = '';
	for (var r = str.length -1; r >= 0; r--) {
		s += str[r];
	}
	return s;
}

function runReverse() {
	var display = document.getElementById("reverseDisplay");
	var str = document.getElementById("instr").value;
	display.innerHTML = getReverse(str);
}

document.getElementById("doReverse").addEventListener("click", runReverse);

/* 4. Factorial
 *    Define function: factorial(someNum)
 *    Use recursion to compute and return the factorial of someNum.
*/
function factorial(num) {
	if (num === 0) {
		return 1;
	}
	return num * factorial(num - 1);
}

function runFactorial() {
	var display = document.getElementById("factDisplay");
	var n = document.getElementById("fact").value;
	display.innerHTML = factorial(n);
}

document.getElementById("doFactorial").addEventListener("click", runFactorial);

/* 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(str, length, offset) {

	if (str == null) {
		alert("There is no string to get a substring of!");
	}
	if (offset == 0) {
		alert("What is the point of using substring to return\n the entire string?");
	}
	else if (str == null && offset == 0) {
		alert("There is no string to get a substring of!\nWhat is the point of using substring to return\n the entire string?");
	}
	return str.slice(offset,(offset+length));
}

function runSubstring() {
	var display = document.getElementById("subDisplay");
	//takes in string arguments for the string & offset, where offset is where the substring begins
	var sub = document.getElementById("strarg").value;
	var off = parseInt(document.getElementById("off").value);
	var len = parseInt(document.getElementById("rlen").value);
	display.innerHTML = substring(sub, len, off);
}

document.getElementById("doSubstring").addEventListener("click", runSubstring);

/*
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 */
function isEven(num) {
	if ((num & 1) == 0) {
		return true;
	}
	else {
		return false;
	}
}

function runIsEven() {
	var display = document.getElementById("evenDisplay");
	var number = document.getElementById("numTest").value;
	display.innerHTML = isEven(number);
}

document.getElementById("doIsEven").addEventListener("click", runIsEven);

/*
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */

function isPalindrome(cstr) {
	var pstr = getReverse(cstr);
	if (cstr == pstr) {
		return true;
	}
	return false;
}

function runIsPalindrome() {
	var display = document.getElementById("checkDisplay");
	var cstr = document.getElementById("strText").value;
	display.innerHTML = isPalindrome(cstr);
}

document.getElementById("doPalindrome").addEventListener("click", runIsPalindrome);

/* 8. Shapes
 * Define function: printShape(shape, height, character)
 * shape is a String and is either "Square", "Triangle", "Diamond".
 * height is a Number and is the height of the shape. Assume the number is odd.
 * character is a String that represents the contents of the shape. Assume this String contains just one character.
 * Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 * Example for printShape("Square", 3, "%");
 * %%%
 * %%%
 * %%%
 * Example for printShape("Triangle", 3, "$");
 * $
 * $$
 * $$$
 * Example for printShape("Diamond", 5, "*");
 *   *
 *  ***
 * *****
 *  ***
 *   *
*/
function printShape(shape, no, img) {
	var space = " ";
	
	switch(shape) {
	case "square": for (var c = 1; c <= no; c++) {
						  console.log((img).repeat(no));
						  console.log(" ");
				   }
				   break;
	case "triangle": for (var co = 1; co <= no; co++) {
						 for (var row = 1; row <= no; row++) {
							 console.log(img.repeat(co));
						 }
					  }
					  break;
	case "diamond": for (var col = 1; col <= no; col++) {
						console.log(thinSpace.repeat((no/2) - (col)) + img.repeat(col));
					}
					console.log(img.repeat(no/2 + 1));
					for (var colu = no; colu >= 1; colu--) {
						console.log(thinSpace.repeat((no/2) - (colu)) + img.repeat(colu));
						console.log(" ");
					}
					break;
	}
}

function runPrintShapes() {
	var display = document.getElementById("printDisplay");
	var shapearr = [];
	shapearr = document.getElementById("cshape").value;
	shapearr = shapearr.split(",");
	display.innerHTML = printShape(shapearr[0].toLowerCase(), shapearr[1], shapearr[2]);
}

document.getElementById("doPrintShapes").addEventListener("click", runPrintShapes);

/* 9. Object literal
 *    Define function traverseObject(someObj)
 *    Print every property and it's value.
*/

function traverseObject(sobj) {
	sobj = sobj.split(",");
	var students = [];
	var student = {name: sobj[0], alias: sobj[1], age: sobj[2]};
	for (var p in student) {
		students.push("Property: " + p + " Value: " + student[p] + " ");
	}
	return students;
}

function runTraverse() {
	var display = document.getElementById("objDisplay1");
	var values = document.getElementById("ol1").value;
	display.innerHTML = traverseObject(values);
}

document.getElementById("doObjLit1").addEventListener("click", runTraverse);

/* 10. Delete Element
 *     Define function deleteElement(someArr)
 *     Print length
 *	   Delete the third element in the array.
 *     Print length
 *     The lengths should be the same.
*/
function deleteElement(dearr) {
	dearr.replace(/ /g, '');
	var narr = dearr.split(",");
	var arr1 = narr;
	if (dearr.length < 3) {
		alert("The String is not long enough");
	}
	delete narr[2];
	console.log(narr);
	return "This is your original string length: " + arr1.length +
			". This is your new string length: " + narr.length + ".";
}

function runDelete() {
	var display = document.getElementById("dDisplay");
	var dnarr = document.getElementById("darr").value;
	display.innerHTML = deleteElement(dnarr);
}

document.getElementById("doDelete").addEventListener("click", runDelete);

/* 11. Splice Element
 *     Define function spliceElement(someArr)
 *     Print length
 *	   Splice the third element in the array.
 *     Print length
 *     The lengths should be one less than the original length.
*/
function spliceElement(sarr) {
	var nsarr = sarr;
	
	if (sarr.length < 3) {
		alert("The String is not long enough");
	}
	nsarr.splice(2,1);
	return ". This is your new string [" + nsarr + "] and length: " + nsarr.length + ".";
}

function runSplice() {
	var display = document.getElementById("splDisplay");
	var csplarr = document.getElementById("splarr").value;
	csplarr = csplarr.split(",");
	display.innerHTML = "This is your original string [" + csplarr + "] and length: " + csplarr.length + spliceElement(csplarr);
}

document.getElementById("doSplice").addEventListener("click", runSplice);

/* 12. Defining an object using a constructor
 *     Define a function Person(name, age)
 *     The following line should set a Person object to the variable john:
 *	   var john = getPerson("John", 30)
*/
function person(name, age) {
	this.name = name;
	this.age = age;
}

function getCPerson(rName, rAge) {
	console.log("Name: " + rName + " Age: " + rAge);
	return person(rName, rAge);
}

function runPerson() {
	var display = document.getElementById("personDisplay");
	var ocarr = document.getElementById("person").value;
	ocarr = ocarr.split(",");
	display.innerHTML = getCPerson(ocarr[0],parseInt(ocarr[1]));
}

document.getElementById("doGetPerson").addEventListener("click", runPerson);

/* 13. Defining an object using an object literal
 *     Define function getPerson(name, age)
 *     The following line should set a Person object to the variable john:
 *	   var john = getPerson("John", 30)
*/
function Person(name, age) {
	var Person = {name: name, age: age};
}

function getPerson(rName, rAge) {
	var rperson = Person(rName,rAge);
	console.log("You have created person " + rName + " who is " + rAge + " years old.");
	return rperson;
}

function runPersonL() {
	var display = document.getElementById("litDisplay");
	var olarr = document.getElementById("per").value;
	olarr = olarr.split(",");
	display.innerHTML = getPerson(olarr[0],parseInt(olarr[1]));
}

document.getElementById("doGetPersonL").addEventListener("click", runPersonL);