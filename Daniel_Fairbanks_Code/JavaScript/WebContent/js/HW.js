/*
 * Javascript Homework
 * 30 August 2017
 */

//Fibonacci Sequence
function fib(n)
{
	if(n<=1)
		return n;
	else 
		return fib(n-1)+fib(n-2);
}

//Bubblesort
var arr = [10, 7, 3, 1, 9, 7, 4, 3];
function bubbleSort(arr) 
{
    var n = arr.length;
    for (var i = 0; i < n; i++) {
        for (var j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }
}

//Reverse String
function reverse(s)
{
	  return s.split("").reverse().join("");
}

//Factorial
function factorial(num)  
{   
    if (num < 0) {  
        return -1;  
    }    
    else if (num == 0) {  
        return 1;  
    }  
    var tmp = num;  
    while (num-- > 2) {  
        tmp *= num;  
    }  
    return tmp;  
}

//Substring
function substring(s, length, offset)
{
	return s.substring(offset,offset+length);
}

//Check Even
function isEven(num)
{
	return Number.isSafeInteger(num/2);
}

//Check Palindrome
function isPalindrome(s)
{
	var reg = s;
	var rev = s.split("").reverse().join("");
	return reg == rev;
}

//Print Shape
function printShape(shape, height, character)
{
	var str = "";
	switch(shape)
	{
	case "Square":
		for(var i=0; i<height; i++)
		{
			for(var j=0; j<height; j++)
				str+=character;
			str+="\n";
		}
		break;
	case "Triangle":
		for(var i=0; i<height; i++)
		{
			for(var j=0; j<=i; j++)
				str+=character;
			str+="\n";
		}
		break;
	case "Diamond":
		
		break;
	}
	console.log(str);
}


function traverseObject(obj) 
{
	var keys = [];
	for ( var key in obj) {
		var value = obj[key];
		console.log(key +":"+value);
	}
}

function deleteElement(arry)
{
	console.log(arry.length);
	delete arry[2];
	console.log(arry.length);
}

function spliceElement(arry)
{
	console.log(arry.length);
	arry.splice(2,1);
	console.log(arry.length);
}

function person(name, age)
{
	this.name = name;
	this.age = age;
}

function getPerson(name, age)
{
	var john = {"name":name, "age":age};
	return john;
}











function runFib() {
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("val").value;
	display.innerHTML = fib(n);
}
document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("inner").addEventListener("click", function(){alert("inner!")});
document.getElementById("middle").addEventListener("click", function(){alert("middle!")});
document.getElementById("outer").addEventListener("click", function(){alert("outer!")});