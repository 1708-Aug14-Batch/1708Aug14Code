/**
 * Java Script Homework
 */
//Fibonacci Function
function fib(n){
	if(n <= 1)return n;
	else return (fib(n-1) + fib(n-2));
}

function runFib(){
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("inner").addEventListener("click", 
		function(){alert("inner!")}, true);

document.getElementById("middle").addEventListener("click", 
		function(){alert("middle")}, true);

document.getElementById("outer").addEventListener("click", 
		function(){alert("outer")}, true);
//Bubble Sort Function
function bubbleSort(numArray){
	var sort;
	do{
		sort = false;
		for(var i=0;i<numArray.length-1;i++){
			if(numArray[i]>numArray[i+1]){
				var temp = numArray[i];
				numArray[i]=numArray[i+1];
				numArray[i+1] = temp;
				sort = true;
			}
		}
	}while(sort);
	return numArray;
}
$('#addNumber').on('click',function(){
	$('numberDisplay').text(bubbleSort('#Number').val());
})
//Reverse String
function reverseStr(someStr){
	return someStr.split("").reverse().join("");
}
$('#reverse').on('click',function(){
	$('#stringDisplay').text(reverseStr($('#myString').val()))
});
//Factorial
function factorial(someNum){
	if(someNum == 0){
		return 1
	}else{
		return someNum *factorial(someNum-1);
	}
}
$('#numberButton').on('click',function(){
	$('#numberDisplay').text(factorial($('#numberIn').val()));
})
//SubString
function substring(someStr, length, offset){
	var res;
	if(someStr.length == false){
		alert("No String");
	}
	else if(length == false){
		alert("No Length");
	}
	else if(offset == false){
		alert("No Offset");
	}
	else if(someStr.length < parseInt(offset)){
		alert("String is too short or offset is too large");
	}
	else if(someStr.length < (parseInt(offset) + parseInt(length))){
		alert("String is too short, offset is too large, or length is too large");
	}
	else{
		return someStr.substr(parseInt(offset),parseInt(length));
	}
}
$('#5out').on('click',function(){
	$('#stringDisplay5').text(substring($('#5in1').val(),$('#5in2').val(),$('#5in3').val()));
})
//Even Number
function isEven(n) {
	  if (n == 0)
	    return true;
	  else if (n == 1)
	    return false;
	  else if (n < 0)
	    return isEven(-n);
	  else
	    return isEven(n - 2);
	}
$('#7out').on('click',function(){
	$('#stringDisplay7').text(isEven($('#7in').val()));
})
//Palindrome
function isPalindrome(someStr){
	var re = /[^A-Za-z0-9]/g;
	 someStr = someStr.toLowerCase().replace(re, '');
	 var len = someStr.length;
	 for (var i = 0; i < len/2; i++) {
	   if (someStr[i] !== someStr[len - 1 - i]) {
	       return false;
	   }
	 }
	 return true;
}
$('#7out').on('click',function(){
	$('#stringDisplay7').text(isPalindrome($('#7in').val()));
//Shapes ****************
function printShape(shape, height, charecter){
	var temp = shape;
	switch(temp){
		case "Square":
		for(var x = 0; x < parseInt(height); x++){
			console.log(Array(parseInt(height)+1).join(character) + "\n");
		}
		break;
		case "Triangle":
		for(var x = 1; x < parseInt(height)+2; x++){
				console.log(Array(x).join(character));
		}
		break;
		case "Diamond":
		for(var x = 1; x < parseInt(height)-1; x+= 2){
			var tempString = "";
			var tempSpace = parseInt(height) - x;
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			for(var z = 0; z < x; z++){
				tempString += character;
			}
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			console.log(tempString);
		}

		var tempStringM = "";
		for(var x = 0; x < parseInt(height); x++){
			tempStringM += character;
		}
		console.log(tempStringM);

		for(var x = parseInt(height)-1; x > 1; x-= 2){
			var tempString = "";
			var tempSpace = parseInt(height) - x;
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			for(var z = 0; z < x-1; z++){
				tempString += character;
			}
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			console.log(tempString);
		}
		break;
	}
	
}
$('#8out').on('click',function(){
	$('#stringDisplay8').text(substring($('#8in1').val(),$('#8in2').val(),$('#8in3').val()));
})
//Object literal
function traverseObject(someObj){
	var map = new Map(Object.entries(someObj));
	console.log(map);
}
$('#9in').on('click',function(){
	$('#stringDisplay9').text(traverseObject($('#9out').val()));
//Delete Element
function deleteElement(someArr){
	someArr.pop();
	return someArr.length;
}
$('#10in').on('click',function(){
	$('#stringDisplay10').text(deleteElement($('#10out').val()));
//Splice Element
function spliceElement(someArr){
	someArr.splice(5);
	return someArr
	
}
$('#10in').on('click',function(){
	$('#stringDisplay10').text(spliceElement($('#10out').val()));
function spliceElement3(someArr){
	someArr.splice(2,1);
	return someArr;
}
$('#11in').on('click',function(){
	$('#stringDisplay11').text(spliceElement3($('#11out').val()));
//Defining an object using a constructor
function Persion(name, age){
	this.name = name;
	this.age = age;
}
$('#construct').on('click',function(){
	$('#stringDisplay').text(Persion($('#name').val(),$('#age').val));
//Defining an object using an object literal
function getPerson(name, age){
	var john = {name: "John", age: 30};

}

//function runFib(){
//	var display = document.getElementById("fibDisplay");
//	var n = document.getElementById("fib").value;
//	display.innerHTML = fib(n);
//}

//document.getElementById("doFib").addEventListener("click",runFib());
//document.getElementById("inner").addEventListener("click",function(){alert("inner")});
