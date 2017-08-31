/**
 * 
 */

//Question 1: Fibonacci
function fib(n){
	if(n<=1) return n;
	else return fib(n-1)+fib(n-2);
}

//Question 2: Bubble Sort
function bubSort(numArray){
	for(i =0; i<numArray.length-1; i++)
	{
		for(j = 0; j < numArray.length-i-1; j++)
		{
			if(arr[j] > arr[j+1])
			{
				var temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
}
//Question 3: Reverse String
function reverseStr(someStr){
	var temp = "";
	
	for(var i = someStr.length-1; i >= 0; i--)
	{
		//System.out.print(c[i]);
		temp += someStr[i];
	}
	return temp;
}

//Question 4: Factorial
function factorial(someNum){
	if(someNum == 1 || someNum == 0)
		return someNum;
	return factorial(someNum-1)*someNum;
}

//Question 5: Substring
function subStr(someStr,length,offset){
	var result = "";
	for(var i = offser; i<length+offset; i++)
	{
		result += someStr[i];
	}
	return result;	
}

//Question 6: Even or Naw
function isEven(someNum){
	if((someNum & 1)==0)
		return true;
	else
		return false;
}

//Question 7: Palindromes
function isPalindrome(someStr){
	var test = reverseStr(someStr);
	if(test == someStr)
		return true;
	else
		return false;
}

//Question 8: Print Shapes
function printShapes(shape, height, character){
	switch(shape){
	case "Square":
		for (var i = 0; i < height; i++) {
		   console.log(character + character + character);
		}
		break;
	case "Triangle":
		var ast = [],j = height;
		for (i = 0; i < j; i++) {
		 ast[i] = new Array(i + 2).join(character);
		 console.log(ast[i]);
		}
		break;
	case "Diamond":
		 var y, w, shape = " ";

		  for(y = 0; y < height * 2 - 1; y++) {
		    w = y < height ? y : height * 2 - y - 2;
		    shape += Array(height - w).join(' ') + Array(w + 1).join('* ') + '*\n';
		  }
		  console.log(shape);
		  break;  
		}
		
	}

//function runFib(){
//	var display = document.getElementById("fibDisplay");
//	var n = document.getElementById("fib").value;
//	display.innerHTML = fib(n);
//}
//
//document.getElementById("doFib").addEventListener("click",runFib);
//document.getElementById("inner").addEventListener("click",
//		function(){alert("inner!")});
//document.getElementById("middle").addEventListener("click",
//		function(){alert("middle!")});
//document.getElementById("outer").addEventListener("click",
//		function(){alert("outer!")});
