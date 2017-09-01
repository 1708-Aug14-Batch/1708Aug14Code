/**
 * Emma Bownes
 * Javascript Homework
Due Monday @ noon
Put all homework in:
	....Emma_Bownes_Code/Week4/Javascript_Homework/
-----------------------------------------------------------------------------------
PART I
Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
 */

function fib(n){ 
	if(n<=1) return n; 
	else return (fib(n-1) + fib(n-2)); }

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
	document.getElementById("fib").value = fib(n);
}
document.getElementById("doFib").addEventListener("click", runFib);

/**
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
 */
function bubbleSort(a){
	//first we want to get our input string into an array
	var A = [];
	num="";
	for(i=0;i<a.length;i++)
	{if (a[i] != "," && a[i] != " ")
	{num = num + a[i];
	}
	else
	{if(num!==""){A=A.concat(parseInt(num,10));}
	num="";}
	}
	A=A.concat(parseInt(num,10));
	resort = true;
	while(resort){
		resort = false;
		for(i=1; i < A.length; i++){
			first = A[i-1];
			second = A[i];
			if (first>second){
				//sorting is only needed if the first number is larger than the second
				resort = true;
				//If a switch is made, resort is set to true to tell the program to sort through again
				A[i-1] = second;
				A[i] = first;
				//The actual switch is made
			}
		}
	}
	return A;
}

function runBubble(){
	var dispbub = document.getElementById("bubDisplay");
	var a = document.getElementById("bub").value;
	 SortedArray = bubbleSort(a);
	 dispbub.innerHTML = SortedArray;
	 document.getElementById("putdelete").innerHTML = "<br><a href=\"#delspot\"><button>Delete the third element!</button></a>";
	 document.getElementById("putsplice").innerHTML = "<br><a href=\"#splicespot\"><button id =\"putsplice\">Splice around the third element!</button></a>";
}
document.getElementById("sortbub").addEventListener("click", runBubble);
function puttosplice(){
	document.getElementById("spliceable").value = SortedArray;
}

function puttoDelete(){
	var a = document.getElementById("bub").value;
	SortedArray = bubbleSort(a);
	document.getElementById("deletable").value = SortedArray;
}

document.getElementById("putdelete").addEventListener("click", puttoDelete);
document.getElementById("putsplice").addEventListener("click", puttosplice);


/**
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
 */
function reverseString(s){
	a = "";
	for(i=0;i<s.length;i++){
		a = a.concat(s[s.length-1-i]);
	}
	return a;
}

function nurString(){
	var display = document.getElementById("stringDisplay");
	var n = document.getElementById("str").value;
	display.innerHTML = reverseString(n);
	document.getElementById("str").value = reverseString(n);
	var button = document.getElementById("reverse");
	var tex = document.getElementById("reverse").innerHTML;
	button.innerHTML = reverseString(tex);
}
document.getElementById("reverse").addEventListener("click", nurString);

/**
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
 */
function factorial(n){
	if(n==1){
		return n;
	}
	else{return (n*factorial(n-1));}
}

function runFact(){
	var display = document.getElementById("factDisplay");
	var n = document.getElementById("fact").value;
	display.innerHTML = factorial(n);
	document.getElementById("fact").value = factorial(n);
}
document.getElementById("factorial").addEventListener("click", runFact);


/**
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */ 
function substring(someStr, length, offset){
	n = "";
	length++;
	for(i=offset; i <= length-1 ;i++){
		if(someStr[i]){
			n = n + (someStr[i]);	
		}
		else{
			alert("This substring does not exist. \n Please enter a shorter length or smaller beginning index.");
			return "";}

	}
	return n;
}

function runSub(){
	var display = document.getElementById("subDisplay");
	var someStr = document.getElementById("sub").value;
	var offset = document.getElementById("offset").value;
	var length = document.getElementById("length").value;
	document.getElementById("sub").value = display.innerHTML = substring(someStr, length, offset);
	
}
document.getElementById("substring").addEventListener("click", runSub);


/**
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
 */ 
function isEven(someNum){
	if(someNum < 2){return !(someNum);}
	else{return isEven(someNum-2);}
}

function runEven(){
	var display = document.getElementById("evenDisplay");
	var n = document.getElementById("even").value;
	display.innerHTML = isEven(n);
	document.getElementById("even").value = "";
}
document.getElementById("iseven").addEventListener("click", runEven);

/**
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
 */ 

function isPalindrome(someStr){
	len = someStr.length;
	if(len%2===0) {
		middle = len/2;
		//if the word's length is even, l/2 returns an int
	}
	else {len++;
	middle = (len)/2;
	//if the word's length is odd, length+1 / 2 returns an int
	}	
	for(i=0;i<middle;i++){
		if(someStr[i] === someStr[someStr.length-1-i]) {
			check = true;
		}
		else {
			return false;
		}
	}
	return check;
}

function runPal(){
	var display = document.getElementById("palDisplay");
	var someStr = document.getElementById("pal").value;
	display.innerHTML = isPalindrome(someStr);
	document.getElementById("pal").value = "";
	
}
document.getElementById("palindrome").addEventListener("click", runPal);


/**
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");

 **/
function printShape(shape, height, character){
	str = "";
	lo = "";
	switch(shape){
	case "triangle":
		height++;
		for(i=1;i<height;i++){
			for(j=0;j<i;j++){
				str = str + character;
				lo = lo + character;
			}
			console.log(lo);
			lo = "";
			str = str + "<br>";
		}
		break;
	case "square":
		for(i=0;i<height;i++){
			for(j=0;j<height;j++){
				str = str + character;
				lo = lo + character;
			}
			console.log(lo);
			lo = "";
			str = str + "<br>";
		}
		break;		
	case "diamond": 
		for(i=1;i<height/2;i++){
			for(j=0;j<i;j++){
				str = str + character;
				lo = lo + character;
			}
			console.log(lo);
			str = str + "<br>";
		}
		for(i=0;i<(height/2);i++){
			for(j=(height/2);j>i;j--){
				str = str + character;
				lo = lo + character;
			}
			console.log(lo);
			lo = "";
			str = str + "<br>";
		}
		break;
	}
	return str;
}

function runShape(){
	var display = document.getElementById("shapeDisplay");
	var shape = document.querySelector('input[name="shape"]:checked').value;
	var height = document.getElementById("height").value;
	var character = document.getElementById("char").value;
	display.innerHTML = printShape(shape, height, character);
	document.getElementById("height").value = document.getElementById("char").value = "";
}
document.getElementById("makeShape").addEventListener("click", runShape);



/**
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/ 

function traverseObject(someObj){
	objprop ="";
	arr = Object.getOwnPropertyNames(someObj);
	for(i=0;i<arr.length;i++){
				str = arr[i]+": ";
				str = str + someObj[arr[i]]
				console.log(str);
				objprop+= "<br>"+ str;
	}
	return objprop;
}



/**
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/

//This function will be useful for the next two problems
function makeArray(a){
	var A = [];
	el="";
	for(i=0;i<a.length;i++)
	{if (a[i] != "," && a[i] != " ")
	{el = el + a[i];
	console.log("IF "+ el);
	}
	else
	{if(el!==""){A=A.concat(el);}
	el="";}
	}
	A=A.concat(el);
	return A;
}

function deleteElement(someArr){
	console.log(someArr.length);
	delete someArr[2];
	console.log(someArr.length);
	return someArr;
}

function runDelete(){
	var display = document.getElementById("deleteDisplay");
	var a = document.getElementById("deletable").value;
	var arr = makeArray(a);
	display.innerHTML = deleteElement(arr);
}

function runArray(){
	var display = document.getElementById("deleteDisplay");
	var a = document.getElementById("deletable").value;
	display.innerHTML = makeArray(a);
}
document.getElementById("makeArray1").addEventListener("click", runArray);
document.getElementById("delArray").addEventListener("click", runDelete);


/**
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
 */ 
function spliceElement(someArr){
	console.log(someArr.length);
	someArr.splice(2, 1);
	console.log(someArr.length);
	return someArr;
}
function runArray2(){
	var display = document.getElementById("spliceDisplay");
	var a = document.getElementById("spliceable").value;
	display.innerHTML = makeArray(a);
}
function runSplice(){
	var display = document.getElementById("spliceDisplay");
	var a = document.getElementById("spliceable").value;
	var arr = makeArray(a);
	display.innerHTML = spliceElement(arr);
}
document.getElementById("makeArray2").addEventListener("click", runArray2);
document.getElementById("spliceArray").addEventListener("click", runSplice);

/**
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
 */ 
function Person(name, age){
	this.name = name;
	this.age = age;
}
function runPerson(){
	var display = document.getElementById("personDisplay");
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	var person = new Person(name, age);
	display.innerHTML = traverseObject(person);
}
document.getElementById("makePerson").addEventListener("click", runPerson);


/**
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
 */ 

function getPerson(name, age){
	var person = {name: name, age:age};
	return person;
}
function rungPerson(){
	var display = document.getElementById("getDisplay");
	var name = document.getElementById("getname").value;
	var age = document.getElementById("getage").value;
	var person = getPerson(name, age);
	display.innerHTML = traverseObject(person);
}

document.getElementById("getaPerson").addEventListener("click", rungPerson);
