/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */
function fib(n){
	//console.log(n);
	if(n <= 1){
		return n;
	}
	else{
		return (fib(n-1) + fib(n-2));
	}
}
function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = "The Fibonacci value of "+n+" is "+fib(n);
	document.getElementById("fib").value = fib(n);
}
document.getElementById("doFib").addEventListener("click", runFib);



/**
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */
function bubbleSort(numArray){
	numArray.replace(/ /g,'');
	numArray = numArray.split(',').map(Number);
	var swap;
	var length = numArray.length;
	for (var i = (length-1);i>=0;i--){
		for(var j = (length-i);j>0;j--){
			if(numArray[j]<numArray[j-1]){
				var temp = numArray[j];
				numArray[j]=numArray[j-1];
				numArray[j-1]=temp;
			}
		}
	}
	return numArray;
}
function runBubble(){
	var display = document.getElementById("bubbleDisplay");
	var numArr = document.getElementById("bubble").value;
	display.innerHTML = "Sorted Array: "+bubbleSort(numArr);
}
document.getElementById("doBubble").addEventListener("click",runBubble);



/**
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String
 */
function reverseStr(someStr){
	someStr = someStr.split('');
	var revStr ="";
	for (var i=someStr.length-1;i>=0;i--){
		revStr+=someStr[i];
	}
	return revStr;
}
function runReverse(){
	var display = document.getElementById("reverseDisplay");
	var someStr = document.getElementById("reverse").value;
	display.innerHTML = "Reversed: "+reverseStr(someStr);
}
document.getElementById("doReverse").addEventListener("click",runReverse);



/**
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum
 */
function factorial(someNum){
	if(someNum==0){
		return 1;
	}
	return someNum * factorial(someNum-1);
}
function runFactorial(){
	var display = document.getElementById("factorialDisplay");
	var someNum = document.getElementById("factorial").value;
	display.innerHTML = someNum+"! = "+factorial(someNum);
}
document.getElementById("doFactorial").addEventListener("click",runFactorial);



/**
 * 5. Substring
 * Define function substring(someStr,length,offset)
 * Return the substring contained between offset and (offset+length) inclusively.
 * If incorrect input is entered, use alert function and describe why the input was incorrect.
 */
function substring(someStr,len,offset){
	someStr = someStr.split('');
	var doPrint = true;
	var lenoff = parseInt(len) + parseInt(offset);
	if(someStr.length==0){
		window.alert("Please enter a String");
		doPrint=false;
	}
	else if(someStr.length<offset){
		window.alert("Please enter a starting index within the String...");
		doPrint=false;
	}
	else if(someStr.length<len){
		window.alert("The length you've given me to substring is longer than your String is...");
		doPrint=false;
	}
	else if(someStr.length<(lenoff)){
		window.alert("Sorry, your substring indexes past the String's end!");
		doPrint=false;
	}
	else{
		doPrint=true;
	}
	
	if(doPrint){
		var subStr = "";
		for (var i=offset;i<=lenoff;i++){
			subStr+=someStr[i];
		}
		return subStr;
	}
	else{
		return "Please Enter Correct Values";
	}
	
}
function runSubstring(){
	var display = document.getElementById("substringDisplay");
	var someStr = document.getElementById("someStr").value;
	var len = document.getElementById("len").value;
	var offset = document.getElementById("offset").value;
	display.innerHTML = "Substring: "+substring(someStr,len,offset);
}
document.getElementById("doSubstring").addEventListener("click",runSubstring);


/**
 * 6. Even number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
 */
function isEven(someNum){
	someNum = someNum.toString();
	someNum.split('');
	var endNum = someNum[someNum.length-1];
	if(endNum==0||endNum==2||endNum==4||endNum==6||endNum==8){
		return true;
	}
	else{
		return false;
	}
}
function runIsEven(){
	var display = document.getElementById("isEvenDisplay");
	var someNum = document.getElementById("someNum").value;
	var result = isEven(someNum);
	if(result){
		display.innerHTML = "The number "+someNum+" is even!";
	}
	else{
		display.innerHTML = "The number "+someNum+" is odd!";
	}
}
document.getElementById("doIsEven").addEventListener("click",runIsEven);



/**
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */
function isPalindrome(someStr){
	someStr = someStr.toLowerCase();
	someStr = someStr.split('');
	var len = someStr.length;
	for(var i=0;i<(len/2);i++){
		if(someStr[i]!==someStr[len-1-i]){
			return false;
		}
	}
	return true;
}
function runPalindrome(){
	var display = document.getElementById("palindromeDisplay");
	var someStr = document.getElementById("someStrPal").value;
	var result = isPalindrome(someStr);
	if(result){
		display.innerHTML = "The String "+someStr+" is a palindrome!";
	}
	else{
		display.innerHTML = "The String "+someStr+" is not a palindrome!";
	}
}
document.getElementById("doPalindrome").addEventListener("click",runPalindrome);



/**
 * 8. Shapes
 * Define function: printShape(shape,height,character)
 * Shape is a String and is either "Square", "Triangle", or "Diamond."
 * Height is a Number and is the height of the shape. Assume the number is odd.
 * Character is a String that represents the contents of the shape. Assume this String contains
 *		just one character.
 * Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 */
function printShape(shape,height,character){
	height = parseInt(height);
	if(height%2==0){
		height+=1;
	}
	shape = parseInt(shape);
	var row;
	row = "";
	var row2;
	row2 ="";
	var col;
	col ="";
	switch(shape){
	case 0:
		row = (character+"&numsp;").repeat(height);
		col = (row+"<br />").repeat(height);
		return col;
	case 1:
		for(var i=1;i<=height;i++){
			row = character.repeat(i);
			col = col + row + "<br/>";
			row="";
		}
		return col;
	case 2:
		var space="&nbsp;".repeat(character.length);
		for(var i=1;i<=height/2;i++){
			row2 = space.repeat((height/2)-(i)+1);
			row = character.repeat(i);
			row2 = row2 + row;
			col=col+(row2+row+"<br/>");
			row2="";
			row="";
		}
		row="";
		row = character.repeat(height+1);
		col=col+(row);
		row=space;
		for(var i=height/2;i>0;i--){
			row2 = space.repeat((height/2)-(i)+1);
			row=character.repeat(i);
			row2 = row2 + row;
			col=col+("<br/>"+row2+row);
			row2="";
			row="";
		}
		return col;
	default:
		return "";
	}
	
}
function runPrintShape(){
	var display = document.getElementById("shapeDisplay");
	var shape = document.querySelector('input[name=shape]:checked').value;
	var height = document.getElementById("height").value;
	var character = document.getElementById("character").value;
	display.innerHTML = printShape(shape,height,character);
}
document.getElementById("doShape").addEventListener("click",runPrintShape);


/**
 * 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and its value.
 */
function traverseObject(someObj){
	var props = [];
	for(var key in someObj){
		props.push(" [Property: "+key+" Value: "+someObj[key]+"]");
	}
	return props;
}
function runTraverse(){
	var display = document.getElementById("traverseDisplay");
	var kat = getObject();
	display.innerHTML = traverseObject(kat);
}
document.getElementById("doTraverse").addEventListener("click",runTraverse);
function getObject(){
	var myObj = new Object();
	myObj.firstname = "Katie";
	myObj.lastname = "Bixby";
	myObj.age = 21;
	myObj.haircolor = "Red";
	myObj.favmovie = "Spirited Away";
	return myObj;
}




/**
 * 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array
 * Print length
 * The lengths should be the same.
 */
function deleteElement(deleteArr){
	deleteArr.replace(/ /g,'');
	var array = deleteArr.split(',');
	delete array[2];
	return array;
}
function runDelete(){
	var display = document.getElementById("deleteDisplay");
	var someArr = document.getElementById("deleteArr").value;
	var deletedArr = deleteElement(someArr);
	var arrLen = someArr.split(',');
	arrLen = arrLen.length
	display.innerHTML = "Length Before: "+arrLen+" || Array: "+deletedArr+" || Length After: "+deletedArr.length+"!";
}
document.getElementById("doDelete").addEventListener("click",runDelete);



/**
 * 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
 */
function spliceElement(someArr){
	someArr.replace(/ /g,'');
	someArr = someArr.split(',');
	someArr.splice(2,1);
	return someArr;
}
function runSplice(){
	var display = document.getElementById("spliceDisplay");
	var spliceArr = document.getElementById("spliceArr").value;
	var splicedArr = spliceElement(spliceArr);
	var spliceLen = spliceArr.split(',');
	spliceLen = spliceLen.length;
	display.innerHTML = "Length before: "+spliceLen+" || Array: "+splicedArr+" || Length After: "+splicedArr.length+"!";
}
document.getElementById("doSplice").addEventListener("click",runSplice);



/**
 * 12. Defining an object using a constructor
 * Define a function Person(name,age)
 * The following line should set a Person object to the variable john:
 * 		var john = new Person("John",30);
 */
function Person(name,age){
	this.age = parseInt(age);
	this.name = name;
}
function runPerson(){
	var display = document.getElementById("personDisplay");
	var john = new Person("John",30);
	display.innerHTML = "Hi, here I generated a person named "+john.name+", who is "+john.age+" years old!";
}
document.getElementById("doRunPerson").addEventListener("click",runPerson);

/**
 * 13. Define an object using an object literal
 * Define function getPerson(name,age)
 * The following line should set a Person object to the variable john:
 * 		var john = getPerson("John",30);
 */
function getPerson(name,age){
	var myPerson = new Object();
	myPerson.name=name;
	myPerson.age=age;
	return myPerson;
}
function runGetPerson(){
	var display = document.getElementById("getPersonDisplay");
	var john = getPerson("John",30);
	display.innerHTML = "Hi, here I got a person named "+john.name+", who is "+john.age+" years old!";
}
document.getElementById("doGetPerson").addEventListener("click",runGetPerson);




