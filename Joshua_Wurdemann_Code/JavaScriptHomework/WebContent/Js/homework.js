//Javascript Homework
//Due Monday @ noon
//Put all homework in:
//....Firstname_Lastname_Code/Week4/Javascript_Homework/
//-----------------------------------------------------------------------------------
//PART I
//Create a single Javascript file called homework.js to answer these questions.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
function fib(n){
	if(n <= 1)return n;

	else return fib(n-1) + fib(n-2);
}
function runFib(e){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

//document.getElementById("doFib").addEventListener("click", runFib);
//document.getElementById("inner").addEventListener("click", function(){alert("inner!")})
//document.getElementById("middle").addEventListener("click", function(){alert("middle!")})
//document.getElementById("outer").addEventListener("click", function(){alert("outer!")})

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

function bubbleSort(numString){
	// spilts string into array of numbers. 
	var numbers = numString.split(' ').map(Number).filter(Boolean);;

	var swap = true;
	var j = 0;
	var temp;

	while ( swap){
		swap = false;
		j++;

		for( i = 0; i < numbers.length - j; i++){
			if (numbers[i] > numbers[i+1]) {
				temp = numbers[i];
				numbers[i] = numbers[i+1];
				numbers[i+1] = temp;
				swap = true;
			}
		}
	}
	return numbers;
}


function runBubble(e){
	var display = document.getElementById("bubbleDisplay");
	var n = document.getElementById("bub").value;
	display.innerHTML = bubbleSort(n);
}

//document.getElementById("doBubble").addEventListener("click", runBubble);



//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function reverseStr(someStr){

	var splitString = someStr.split(""); 
	var reverseStringArray = splitString.reverse();
	var joinArray = reverseStringArray.join(""); 
	return joinArray; 
}

function runReverseStr(){
	var display = document.getElementById("reverseDisplay");
	var n = document.getElementById("rever").value;
	console.log(n);
	display.innerHTML = reverseStr(n);
}

//document.getElementById("doReverse").addEventListener("click", runReverseStr);


//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

function factorial(n){

	if( n == 0){ //Base Case
		return 1;
	} else
		return(n * factorial(n-1));
}

function runFactorial(){
	var display = document.getElementById("factorialDisplay");
	var n = document.getElementById("fact").value;
	display.innerHTML = factorial(n);
}

//document.getElementById("doFactorial").addEventListener("click",runFactorial);

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.


function substring(someStr, length, offset){

//	if(someStr == null ){
//	return alert("No string was entered. please enter a string");
//	}
	//check if length is great than zero
	var indexSum = offset - length;
	if(offset < 0 || length < 0){
		return	alert("incorrect input. please enter a number greater" +
		" than zero for both length and offset!");
	} if (offset > someStr.length || length > someStr.length || indexSum > someStr.length){
		return 	alert("incorrect input. please enter a number less" +
		" or equal the length of string");
	} else{
		var someSubString = someStr.substring(offset, length);
		return someSubString;
	}
}

function runSubString(){
	var display = document.getElementById("substringDisplay");
	var sub = document.getElementById("sub").value 
	var s = document.getElementById("startIndex").value 
	var l = document.getElementById("length").value

	display.innerHTML = substring(sub, s, l);
}

//document.getElementById("doSubString").addEventListener("click", runSubString);



//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(num) {
	if((num & 1) == 0){ return true
	}
	return false;
}


function runEven(){
	var display = document.getElementById("isEvenDisplay");
	var n = document.getElementById("even").value;
	display.innerHTML = isEven(n);
}






//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
	var len = Math.floor(someStr.length / 2);
	for (var i = 0; i < len; i++){
		if (someStr[i] !== someStr[someStr.length - i - 1]){
			return false;
		}
	}
	return true;
}
function runPalindrome(){
	var display = document.getElementById("palindromeDisplay");
	var n = document.getElementById("pal").value;
	display.innerHTML = isPalindrome(n);
}

//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
function printShape(shape, height, character){

	switch(shape){

	case 'Square':
		var i;
		var j;

		for(i = 0; i < height; i++){
			for(j = 0; j < height; j++){
				if ((i == 0) || (j == 0) || (i == height - 1) || (j == height - 1) 
						|| (i == height/ 2) || (j == height / 2) || (i == j) || (i + j == height - 1))
				{
					var someShapes = Console.log(character);
					return		someShapes;
				}
				else
				{ 
					var something = Console.log(" ");
					return	something;	
				}

			}
		} 

		break;

	case 'Triangle':

		for(var i = 0 ; i < height ; i++) {
			var ast = [], i;

			ast[i] = new Array(i + 2).join(character);
			var num = console.log(ast[i]);
			return	num;
		}

		break;

	case 'Dimond':

		var y, w, space = '';

		for(y = 0; y < height * 2 - 1; y++) {
			w = y < height ? y : height * 2 - y - 2;
			space += Array(height - w).join(' ') + Array(w + 1).join(character +'') + '*\n';
		}
  var j = console.log(space);
		return j;
		// document.write('<pre>' + space + '</pre>');
		break;
	}

} 


function runPrintShape(){
var display = document.getElementById("printDisplay");
var shape = document.getElementById("shape").value 
var height = document.getElementById("height").value 
var character = document.getElementById("character").value
display.innerHTML = printShape(shape, height, character);
}


//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//*
//***
//*****
//***
//*
//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.


//prints key and value properties in google crome but not sure if that is the case for all browsers.
var	person = {
		firstname: "joe",
		lastname: "miller",
		age: 95,
		haircolor:'gray'
};
function traverseObject(someObj){
	//prints both key and value in google crome.
	console.log(someObject);


}

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
function deleteElement(someArr){
	console.log(someArr.length);
	delete someArr[1];
	console.log(someArr.length);
}


//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

function spliceElement(someArr){

	return	console.log(someArr.length);
	someArr.splice(2, 1);
	return	console.log(someArr.length);

}
function runSpliceElement(){
	var display = document.getElementById("spliceElementDisplay");
	var n = document.getElementById("splice").value;
	display.innerHTML = spliceElement(n);
}

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//var john = new Person("John", 30);


//contructs a person object
function Person(name, age){
	this.fistname = name;
	this.age = age;

}
var john = new Person("John", 30);


//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//var john = getPerson("John", 30);

var person = {
		firstname: "john",
		lastname: 'bob',
		age: 19
}
function getPerson(name, age){
	return person.name, person.age;
}
var john = getPerson("John", 30);


//-----------------------------------------------------------------------------------
//PART II
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//They should be done separately.
//Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.

//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>

//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//<input id="num1" class="nums" type="text"/>
//<input id="num2" class="nums" type="text"/>
//<h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//Hide the name if shown.
//Show the name if hidden.
//10. Current Time
//Regarding this element:
//<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
//11. Delay
//Regarding this element:
//<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).