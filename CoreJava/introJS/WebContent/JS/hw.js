/**
 * 

Javascript Homework
Due Monday @ noon
Put all homework in:
	....Firstname_Lastname_Code/Week4/Javascript_Homework/
-----------------------------------------------------------------------------------
PART I
Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
*/ 
// Event Propagation
document.getElementById("inner").addEventListener("click", function(){alert("inner!")});
document.getElementById("middle").addEventListener("click", function(){alert("middle!")});
document.getElementById("outer").addEventListener("click", function(){alert("outer!")});

// 1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence. 

function fib(n){ 
	if(n <= 1) return n;
	else return (fib(n-1) + fib(n-2));
	}

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fibN").value;
	display.innerHTML = fib(n);
}
  
document.getElementById("doFib").addEventListener("click", runFib);

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

function bubbleSort(arr){
	var len = arr.length;
    for (i = 0; i < len; i++) {
        for (j = 0; j < (len - i) - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap temp and arr[i]
                var temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
}

function runBubbleSort(){
	var arr = [1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4];
	var display = document.getElementById("bubbleDisplay");
	display.innerHTML = bubbleSort(arr);
}

document.getElementById("doBubbleSort").addEventListener("click", runBubbleSort);

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function reverseStr(s){
    var len = s.length;
    for (i = (len - 1); i >= 0; i--) {
        s += s.charAt(i);
    }
    s = s.substring(len);
    return s;
}

function runReverseStr(){
	var display = document.getElementById("reverseDisplay");
	var s = document.getElementById("rString").value;
	display.innerHTML = reverseStr(s);
}

document.getElementById("doReverse").addEventListener("click", runReverseStr);

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

var f = [];
function factorial(n) {
  if (n == 0 || n == 1)
    return 1;
  if (f[n] > 0)
    return f[n];
  return f[n] = factorial(n-1) * n;
}

function runFactorial(){
	var display = document.getElementById("factorialDisplay");
	var n = document.getElementById("factorialN").value;
	display.innerHTML = factorial(n); 
}

document.getElementById("doFactorial").addEventListener("click", runFactorial);

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset) {
	var len = someStr.length;
	if(len < length) {
		alert('Length entered is larger than String length\n Try Again');
		return null;
	}
	if(len <= offset){
		alert('Offset entered needs to be 1 less than the String length\n Try Again');
		return null;
	}
	var result = someStr.substring(offset, length);
	return result;
}

function runSubStr() {
	var display = document.getElementById("substrDisplay");
	var someStr = document.getElementById("aString").value;
	var len = document.getElementById("lenN").value;
	var offset = document.getElementById("offsetN").value;
	display.innerHTML = substring(someStr, len, offset); 
}

document.getElementById("doSubStr").addEventListener("click", runSubStr);

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function isEven(someNum) {
  if (someNum < 0) { someNum = Math.abs(someNum);  }
  if (someNum==0) { return true;  }
  if (someNum==1) { return false; }
  else {
	someNum = someNum - 2;
    return isEven(someNum);
  }
}

function runIsEven() {
	var display = document.getElementById("evenDisplay");
	var n = document.getElementById("numN").value;
	display.innerHTML = isEven(n);
}

document.getElementById("doEven").addEventListener("click", runIsEven);

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
	if (someStr == someStr.split('').reverse().join('')) {
		return true;
    } else {
    	return false;
    }
}

function runIsPalindrome() {
	var display = document.getElementById("palinDisplay");
	var str = document.getElementById("bString").value;
	display.innerHTML = isPalindrome(str);
}

document.getElementById("doPalin").addEventListener("click", runIsPalindrome);

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
	switch(shape) {
	case "Square":
		var output = "";
		for (row = 1; row <= height; row++) {
			for (x = 1; x <= height; x++) {
				output += character;
			}
			output += "\n"
		}
		console.log(output);
		break;
	case "Triangle":
		var output = "";
		for (row = 1; row <= height; row++) {
			for (x = 1; x <= row; x++) {
				output += character + " ";
			}
			output += "\n";
		}
		console.log(output);
	break;
	case "Diamond":
		var output = "";
		for(row=1 ; row<=height ; ++row) {
		   var i = (2*row) - 1;
		   if(i>height) {
			   i = 2*(height-row+1) - 1;
		   }
		   for(j=0 ; j<(height-i)/2 ; ++j){
			   output += " ";
		   }
		   for(j=0 ; j<i ; ++j) {
			   output += character;
		   }
		   for(j=0 ; j<(height-i)/2 ; ++j) {
			   output += " ";
		   }
		   output += "\n";
		 }
		   console.log(output);
		break;
	default:
		console.log("Shape Must be Square, Triangle, or Diamond");
	}
}

function runPrintShape() {
	var display = document.getElementById("shapesDisplay");
	var shape = document.getElementById("cString").value;
	var height = document.getElementById("height").value;
	var char = document.getElementById("char").value;
	printShape(shape, height, char);
}

document.getElementById("doShapes").addEventListener("click", runPrintShape);

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

function traverseObject(someObj) {
	var output = "";
	for(prop in someObj) {
		if(someObj.hasOwnProperty(prop)) {
			output += prop;
			output += ": ";
			output += someObj[prop];
			output += "<br>"
		}
	}
	return output;
}

function runTravereObject() {
	var obj = {
		name: "Allan Jones",
		address: "123 Main Street",
		city: "Seattle",
		state: "Washington",
		email: "DrJava@gmail.com"
	};
	var display = document.getElementById("traverseDisplay");
	display.innerHTML = traverseObject(obj);
}

document.getElementById("doTraverse").addEventListener("click", runTravereObject);

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

function deleteElement(someArr) {
	delete someArr[2];
	return someArr;
}

function runDeleteElement() {
	var arr = [1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4];
	var arrBefore = document.getElementById("arrBefore");
	var arrAfter = document.getElementById("arrAfter");
	var len = arr.length;
	arrBefore.innerHTML = arr;
	lenBefore.innerHTML = len;
	arrAfter.innerHTML = deleteElement(arr);
	len = arr.length;
	lenAfter.innerHTML = len;
}

document.getElementById("doDelete").addEventListener("click", runDeleteElement);

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

function spliceElement(someArr) {
	someArr.splice(2,1);
	return someArr;
}

function runSpliceElement() {
	var arr = [1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4];
	var arr1 = document.getElementById("arrayBefore");
	var arr2 = document.getElementById("arrayAfter");
	var len = arr.length;
	arr1.innerHTML = arr;
	lenSBefore.innerHTML = len;
	arr2.innerHTML = spliceElement(arr);
	len = arr.length;
	lenSAfter.innerHTML = len;
}

document.getElementById("doSplice").addEventListener("click", runSpliceElement);

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);

function Person(name, age) {
	this.name = name;
	this.age = age;
}

function runPerson() {
	var john = new Person("John",30);
	johnDisplay.innerHTML = "Name: " + john.name + "<br>" + "Age: " + john.age;
}

document.getElementById("doConstruct").addEventListener("click", runPerson);

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);



//-----------------------------------------------------------------------------------
//PART II
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//	  They should be done separately.
//	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
//  
//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
//  
//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
//  
//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
//  
//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.
//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
