///**
// * 
// */
//Javascript Homework
//Due Monday @ noon
//Put all homework in:
//    ....Firstname_Lastname_Code/Week4/Javascript_Homework/
//-----------------------------------------------------------------------------------
//PART I
//Create a single Javascript file called homework.js to answer these questions.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.

function fib(n) {
	if (n <= 1) return n;
	return (fib(n-1) + fib(n-2));
}

function doFib() {
	var input = $('#fib').val();
	$('#fibDisplay').text(fib(input));
}

document.getElementById('doFibonacci').addEventListener('click', doFib);


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

function bubbleSort(numArray) {
	//console.log("in bubbleSort");
	for (n = numArray.length; n > 0; n--) {
		//console.log("in outer loop");
		for (i = 1; i < n; i++) {
			//console.log("in inner loop");
			if (numArray[i-1] > numArray[i]) {
				var temp = numArray[i];
				numArray[i] = numArray[i-1];
				numArray[i-1] = temp;
			}
		}
	}
	//console.log("end bubbleSort");
	return numArray;
}

function doSort() {
	var array = [];
	$('#sortList').find('td').each(function(index, elem) {
		array.push(parseInt($(elem).text()));
	});
	array = bubbleSort(array);
	
	$('#sortList').find('td').each(function(index) {
		$(this).text(array[index]);
	});	
}

function doScramble() {
	var list = [];
	$('#sortList').find('td').each(function() {
		while (true) {
			var rand = Math.floor(Math.random() * 10 + 1);
			if (!list.find(function(n) {
				return n == rand;
			})) {
				list.push(rand);
				$(this).text(rand);
				break;
			}
		}
	});
}

document.getElementById('doSort').addEventListener('click', doSort);
document.getElementById('doScramble').addEventListener('click', doScramble);


//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function reverseStr(someStr) {
	//console.log(someStr);
	var ca = someStr.split('');
	//console.log(ca);
	for (i = 0; i < Math.floor(ca.length / 2); i++) {
		var temp = ca[i];
		ca[i] = ca[ca.length - i - 1];
		ca[ca.length - i - 1] = temp;
	}
	var ret = "";
	for (i = 0; i < ca.length; i++) {
		ret = ret + ca[i];
	}
	return ret;
}

function doReverse() {
	$('#reversed').text(reverseStr($('#toReverse').val()));
}

document.getElementById('doReverse').addEventListener('click', doReverse);

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

function factorial(someNum) {
	if (someNum < 2) return 1;
	return someNum * factorial(someNum-1);
}

function doFactorial() {
	var input = $('#fac').val();
	$('#facDisplay').text(factorial(input));
}

document.getElementById('doFactorial').addEventListener('click', doFactorial);


//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset) {
	console.log('in substring')
	var ret = '';
	for (i = offset; i < length + offset; i++) {
		//if (i < someStr.length) {
			ret = ret + someStr[i];
		//}
	}
	return ret;
}

function doSubstring() {
	var str = $('#subString').val();
	var len = parseInt($('#subLength').val());
	var off = parseInt($('#subOffset').val());

	if (off < 0 || len < 0) {
		console.log('invalid offset or length < 0');
		alert('Substring length and offset cannot be negative');
	}
	else if (len + off > str.length) {
		console.log('invalid substring range');
		alert('Substring range [' + off + ', ' + (off + len) + '] invalid for string with length ' + str.length);
	}
	else {
		var substr = substring(str, len, off);
		$('#substrDisplay').text(substr);
	}
}

document.getElementById('doSubstring').addEventListener('click', doSubstring);


//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function isEven(num) {
	//console.log('in isEven');
	return Math.floor(num / 2) == num / 2;
}

function doIsEven() {
	var num = parseInt($('#isEven').val());
	$('#isEvenDisplay').text(isEven(num));
}

document.getElementById('doIsEven').addEventListener('click', doIsEven);


//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
	console.log('in isPalindrome');
	for (i = 0; i < Math.floor(someStr.length / 2); i++) {
		if (someStr[i] != someStr[someStr.length - i - 1])
			return false;
	}
	return true;
}

function doPalindrome() {
	var str = $('#palindrome').val();
	$('#isPalindrome').text(isPalindrome(str));
}

document.getElementById('doPalindrome').addEventListener('click', doPalindrome);


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

function printSquare(height, char) {
	var ret = "";
	for (i = 0; i < height; i++) {
		for (j = 0; j < height; j++) {
			ret = ret + char;
		}
		ret = ret + '\n';
	}
	return ret;
}

function printTriangle(height, char) {
	var ret = "";
	for (i = 1; i < height + 1; i++) {
		for (j = i; j > 0; j--) {
			ret = ret + char;
		}
		ret = ret + "\n";
	}
	return ret;
}

function printDiamond(height, char) {
	var ret = "";
	for (i = Math.ceil(height / 2) - 1; i >= 0; i--) {
		for (n = 0 ; n < i; n++) {
			ret = ret + " ";
		}
		for (n = 0 ; n < height - 2*i; n++) {
			ret = ret + char;
		}
		ret += "\n";
	}
	for (i = 1; i < Math.ceil(height / 2); i++) {
		for (n = 0 ; n < i; n++) {
			ret = ret + " ";
		}
		for (n = 0 ; n < height - 2*i; n++) {
			ret = ret + char;
		}
		ret += "\n";
	}
	return ret;
}

function printShape(shape, height, char) {
	if (!height || !char || char.length > 1) {
		alert('Enter valid height and character');
		return;
	}
	switch (shape) {
		case "square":
		return printSquare(height, char);
		break;
		case "triangle":
		return printTriangle(height, char);
		break;
		case "diamond":
		return printDiamond(height, char);
		break;
		default:
	}
	return "";
}

function doPrintShape() {
	var shape = $('#shapeSelect').val();
	var height = parseInt($('#shapeHeight').val());
	var char = $('#shapeChar').val();
	
	var printShap = printShape(shape, height, char);
	console.log(printShap);
	//$('#printShape').text(printShap);
}

document.getElementById('doPrintShape').addEventListener('click', doPrintShape);


//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

function traverseObject(someObj) {
	var ret = "";
	for (var prop in someObj) {
		ret += prop + " = " + someObj[prop] + ", ";
	}
	return ret;
}

function doTraverseObject() {
	var input = $('#objectIn').val();
	//console.log(input);
	var obj;
	try {
		obj = JSON.parse(input);
	}
	catch (err) {
		alert('Bad JSON structure');
		return;
	}
	//console.log(obj);
	$('#traverseObject').text(traverseObject(obj));
}

document.getElementById('doTraverseObject').addEventListener('click', doTraverseObject);


//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

function deleteElement(someArr, i) {
	console.log("before delete: length = " + someArr.length);
	delete someArr[i];
	console.log("after delete: length = " + someArr.length);
	return someArr;
}

function doDeleteElement() {
	var i = parseInt($('#deleteElement').val());
	var arr = ["A", "B", "C", "D", "E", "F"];
	if (i < 0 || i >= arr.length) {
		alert('Index out of range');
		return;
	}
	$('#originalArray').text(arr);
	$('#deletedArray').text(deleteElement(arr, i));
}

document.getElementById('doDeleteElement').addEventListener('click', doDeleteElement);


//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

function spliceElement(someArr, i) {
	console.log("before splice: length = " + someArr.length);
	someArr.splice(i, 1);
	console.log("after splice: length = " + someArr.length);
	return someArr;
}

function doSpliceElement() {
	var i = parseInt($('#spliceElement').val());
	var arr = ["A", "B", "C", "D", "E", "F"];
	if (i < 0 || i >= arr.length) {
		alert('Index out of range');
		return;
	}
	$('#originalArray2').text(arr);
	$('#splicedArray').text(spliceElement(arr, i));
}

document.getElementById('doSpliceElement').addEventListener('click', doSpliceElement);


//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//    var john = new Person("John", 30);

function Person(name, age) {
	this.name = name;
	this.age = age;
}

function doCreatePerson() {
	var john = new Person("John", 30);
	console.log(john);
}

document.getElementById('doCreatePerson').addEventListener('click', doCreatePerson);


//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//    var john = getPerson("John", 30);

function getPerson(name, age) {
	return { "name":name, "age":age };
}

function doGetPerson() {
	var john = getPerson("John", 30);
	console.log(john);
}

document.getElementById('doGetPerson').addEventListener('click', doGetPerson);


//-----------------------------------------------------------------------------------
//PART II
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//      They should be done separately.
//      Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
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
//    <input id="num1" class="nums" type="text"/>
//    <input id="num2" class="nums" type="text"/>
//    <h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//    "Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//    "So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//    Hide the name if shown.
//    Show the name if hidden.
//10. Current Time
//Regarding this element:
//    <h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
//11. Delay
//Regarding this element:
//    <p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).